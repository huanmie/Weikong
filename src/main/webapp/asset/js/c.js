var ft={
	alert:function(c,fn,t){
		this.popup(c,t||"提示", fn);
	},
	popup:function(t,c,fn){
		 $("#popupDialog h1").html(t);
         $("#popupDialog p").html(c);
         if(fn) {
        	 $("#popupDialog").unbind("popupafterclose").bind("popupafterclose", function() { fn(); });
         }
         $("#popupDialog").popup("open");
	}
}

$(document).on("pageinit","#productPage",function(){
	var list = {
		init: function(){
			var lists = $("li","#productList"),
		    	obj = jQuery.objCookie('cart') || {};
    		for(var i = 0 ; i < lists.length ; i++){
    			var opt = $(lists[i]);
				var id  = opt.attr('data-id');
    			var num = obj[id];
    			if(num) opt.find('.productCount').html(num);
        		this.drawCart(obj,id);
    		}
			this.drawCart(obj);
		},
	    setCart:function(id, num){
			var obj = jQuery.objCookie('cart') || {};
			if(num == 0){
				delete obj[id];
			}else{
				obj[id] = num;
			}
			jQuery.objCookie('cart',obj);
			this.drawCart(obj,id);
			this.drawCart(obj);
	    },
	    drawCart:function(obj,id){
			if(isNaN(id)) {
				var lists = $("li","#productList");
				var totalCount = 0;
				var totalPrice = 0;
				for(var i = 0 ; i < lists.length ; i++) {
					var opt = $(lists[i]);
					var id  = opt.attr('data-id');
					var num = obj[id];
					if(num) {
						var price = opt.attr('data-price');
						totalPrice += (num*price);
						totalCount++;
					}
				}
				var target = $("#custom-orderBar");
				if(totalCount) {
					$("#custom-orderBar-content" , target).html("采购"+totalCount+"种, ¥" + totalPrice + "元");
					target.slideDown(function(){
						$("#custom-orderBar").controlgroup({ excludeInvisible: false });
					});
				} else {
					target.slideUp();
				}
			} else {
				var li  = $("li[data-id='"+id+"']");
				var min = li.attr('data-min'),
					max = li.attr('data-max');
    		
				if(!isNaN(min)) {
					var minus = $('.productMinus', li);
					if(obj[id] > min) {
						minus.removeClass('ui-state-disabled');
					} else {
						minus.addClass('ui-state-disabled');
					}
				}
				if(!isNaN(max)){
					var plus = $('.productPlus', li);
					if(obj[id] >= max) {
						plus.addClass('ui-state-disabled');
					} else {
						plus.removeClass('ui-state-disabled');
					}
    		   }
			}
	    },
		isEmptyObj:function(obj){
			for(var n in obj){
				return false;
			}
			return true; 
		},
	    setCount:function(e, opt){
			var li	= $(e.target).parents("li"),
				box	= li.find('.productCount'),
				count;
    		switch(opt){
    		case '+':
    		    count = parseInt(box.html())+1;
    		    break;
    		case '-':
    		    count = parseInt(box.html())-1;
    		    break;
    		}
			box.html(count);
			this.setCart(li.attr('data-id'), count);
			return false;
	    },
	    removeCount:function(e) {
    		if (confirm("确认要删除？")) {
    			var li	= $(e.currentTarget).parents("li").remove();
    			this.setCart(li.attr('data-id'),0);
				if(this.isEmptyObj(jQuery.objCookie('cart')))
					window.location.href = "${urlUtil.product}";
    		}
		}
		
	};
	list.init();
	
	$("#productList").on("tap",".productPlus",function(e){
		return list.setCount(e , '+');
	});

	$("#productList").on("tap",".productMinus",function(e){
		return list.setCount(e , '-');
	});
	
	$("#productList").on("tap",".remove_btn",function(e){
		return list.removeCount(e);
	});
	
	$("#deliverAddress").on("tap", ".remove-address", function(e) {
		var li = $(e.currentTarget).parent('li');
		var addressId = li.attr('data-id');
		if (confirm("确认要该收货地址？")) {
			jQuery.ajax({
				url:"/address/remove",
				data:{
					'id':addressId
				},
				success:function(json){
					li.remove();
				}
			});
		}
		return false;
	});
	
	$(".add-address").on("tap", function(e) {
		var container = $(e.target).parent('div');
		var name 	= container.find("input[name=name]").val();
		var mobile	= container.find("input[name=mobile]").val();
		var address = container.find("textarea[name=address]").val();
		if(jQuery.trim(name) != '' && jQuery.trim(mobile) != '' && jQuery.trim(address) != '') {
			jQuery.ajax({
				url:"/address/add",
				data:{
					'name':name,
					'mobile':mobile,
					'address':address
				},
				success:function(json) {
					var li = '<li data-id="' + json.id + '"><a href="javascript:;" class="radio"><h2>'+json.name+' - '+json.mobile+'</h2><p>'+json.address+'</p></a><a href="javascript:;" class="remove-address">Purchase album</a></li>';
					$('#deliverAddress ul').append(li).listview('refresh');
					container.find("input[name=name]").val('');
					container.find("input[name=mobile]").val('');
					container.find("textarea[name=address]").val('');
					$('#addressDialog').popup('close');
					$('li:last-child a', container).trigger('tap');
				}
			});
		} else {
			alert("请完善地址信息");
		}
	});
	
	$("#custom-orderBar-create").on("tap", function(e){
		var addrli = $('.ui-btn-active','#deliverAddress').parent('li');
		var timeli = $('.ui-btn-active','#deliverTime').parent('li');
		var addressId = addrli.attr('data-id');
		var timeId	  = timeli.attr('data-id');
		if(!addressId) {
			ft.alert("请选择收货地址");
			return;
		}
		if(!timeId) {
			ft.alert("请选择时间段");
			return;
		}
		
		var deliverTime;
		var date	= new Date();
		var month 	= date.getMonth()+1;
		if(month < 10) month = '0' + month;
		var day 	= date.getDate();
		if(day < 10) day = '0' + day;
		var current = date.getFullYear() + "-" + month + "-" + day;
		
		var ndate	= new Date(date.getTime() + 24*3600*1000);
		var month 	= ndate.getMonth()+1;
		if(month < 10) month = '0' + month;
		var day 	= ndate.getDate();
		if(day < 10) day = '0' + day;
		
		var next	= ndate.getFullYear()+ "-" + month + "-" + day;
		
		var hour  	= date.getHours();
		var flag	= true;
		switch(timeId) {
		case '1':
			if(hour >= 11) flag = false;
		case '2':
			if(hour >= 17) flag = false;
			deliverTime = current;
			break;
		case '3':
		case '4':
			deliverTime = next;
			break;
		}
		if(!flag) {
			alert('时间段过期，重新选择');
			return;
		}
		deliverTime += (" " + timeli.attr('date-suffix'));
		
		if(confirm("确定下单？")) {
			jQuery.ajax({
				url:"/order/add",
				data:{
					'addressId':addressId,
					'deliverTime':deliverTime
				},
				success:function(json){
					jQuery.objCookie('cart',null);
					alert('下单成功');
					window.location.href = "${urlUtil.order}";
				}
			});
		}
	});
			
	$('.radioList').on('tap','.radio', function(e){
		var target = $(e.currentTarget);
		if(target.hasClass('.radio')) return false;
		target.parents('.radioList').find('.radio').removeClass('ui-btn-active');
		target.addClass('ui-btn-active');
		return false;
	});
});