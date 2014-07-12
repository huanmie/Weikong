var ft={
	isEmpty:function(obj){
		for(var n in obj)
			return false;
		return true; 
	},
	alert:function(c,t){
		var page = $.mobile.activePage;
		$('#alert h1', page).html(t||'提示信息');
        $('#alert p', page).html(c);
        $('#alert', page).popup('open');
	},
	confirm:function(c,fn,t) {
		var page = $.mobile.activePage;
		$('#confirm h1', page).text(t||'提示信息');
		$('#confirm p', page).text(c);
		$('#confirm .OK', page).unbind().on('tap',function() {
			fn();
		});
		$('#confirm', page).popup('open');
	},
	popup:function(content){
		var page = $.mobile.activePage;
		$('#dialog', page).html(content.html());
		$('#dialog', page).trigger('create').trigger('refresh').popup();
		$('#dialog', page).popup('open');
	},
	toast:function(msg){
		$("<div class='ui-loader ui-overlay-shadow ui-body-e ui-corner-all'><h3>"+msg+"</h3></div>")
		.css({ display: "block", 
			opacity: 0.90, 
			position: "fixed",
			padding: "7px",
			"text-align": "center",
			width: "270px",
			left: ($(window).width() - 284)/2,
			top: $(window).height()/2 })
		.appendTo( $.mobile.pageContainer ).delay( 1500 )
		.fadeOut( 400, function(){
			$(this).remove();
		});
	}
}
var cart={
	init:function(){
		var page = $.mobile.activePage;
		var obj = $.objCookie('cart') || {},
			lists = $('#productList li',page);
    	for(var i = 0 ; i < lists.length ; i++)
			this.drawCount(obj, $(lists[i]).attr('data-id'));
		this.drawCount(obj);
	},
	setCount:function(id,num){
		var obj = $.objCookie('cart') || {};
		if(num) obj[id] = num;
		else delete obj[id];
		$.objCookie('cart',obj);
		this.drawCount(obj,id);
		this.drawCount(obj);
	},
	changeCount:function(e, value){
		var li	= $(e.currentTarget).parents('li');
		this.setCount(li.attr('data-id'), parseInt($('.productCount', li).html()) + value);
	},
	drawCount:function(obj,id){
		var page = $.mobile.activePage;
		if(!isNaN(id)){
			var li  = $('#productList li[data-id="'+id+'"]', page);
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
			$('.productCount', li).html(obj[id]||0);
		} else {
			var lists = $('#productList li',page);
			var totalCount = 0;
			var totalPrice = 0;
			for(var i = 0 ; i < lists.length ; i++) {
				var opt = $(lists[i]);
				var num = obj[opt.attr('data-id')];
				if(!num) continue;
				totalPrice += (num*opt.attr('data-price'));
				totalCount++;
			}
			var target = $('#custom-orderBar', page);
			if(totalCount) {
				$('#custom-orderBar-content', target).html("采购"+totalCount+"种, ¥" + totalPrice + "元");
				target.slideDown(function(){
					$('#custom-orderBar').controlgroup({excludeInvisible:false});
				});
			} else {
				target.slideUp();
			}
		}
	}
}
$(document).on("pageshow","#item", function(e){
	var slidey = $('.custom-banner').unslider({
		fluid:true,
		dots:true,
		speed:500,
		delay: 3000
	}).on("swipeleft" , function(){
		slidey.data('unslider').next();
	}).on("swiperight" , function(){
		slidey.data('unslider').prev();
	});
});
$(document).on("pagebeforeshow","#market",function(e){
	cart.init();
});
$(document).on("pagebeforeshow","#cart",function(e){
	cart.init();
});

$(document).on("pagehide", "div", function(event, ui){
	$(event.target).remove();
});
$(document).on("pageinit","#market",function(e){
	$("#productList", this).on("tap",".productPlus",function(e){
		cart.changeCount(e , 1);
		return false;
	});
	$("#productList", this).on("tap",".productMinus",function(e){
		cart.changeCount(e , -1);
		return false;
	});
	$("#productList", this).on("tap","a[data-popup=true]",function(e){
		ft.popup($('.custom-popup-holder', $(e.currentTarget).parent()));
		return false;
	});
});

$(document).on("pageinit","#cart",function(e){				
	$("#productList", this).on("tap",".productPlus",function(e){
		cart.changeCount(e , 1);
		return false;
	});
	$("#productList", this).on("tap",".productMinus",function(e){
		var li	= $(e.currentTarget).parents("li");
		var c = li.attr('data-remove');
		if(c && $('.productCount', li).text() <= c) {
			if(ft.confirm("删除该商品？" , function(){
				li.remove();
	    		cart.setCount(li.attr('data-id'),0);
				if(ft.isEmpty($.objCookie('cart')))
					$.mobile.changePage('item' , {'reloadpage':true});
			}));
		} else {
			cart.changeCount(e , -1);
		}
		return false;
	});
	$("#productList", this).on("tap","a[data-popup=true]",function(e){
		ft.popup($('.custom-popup-holder', $(e.currentTarget).parent()));
		return false;
	});
	$("#deliverAddress", this).on("tap", ".remove-address", function(e) {
		var li = $(e.currentTarget).parents('li');
		var addressId = li.attr('data-id');
		if(ft.confirm("删除该收货地址？", function(){
			$.ajax({
				url:"/address/remove",
				data:{
					'id':addressId
				},
				success:function(json){
					if(json.success)
						li.remove();
				}
			});
		}));
		return false;
	});
	$("#addressDialog",this).on("tap", ".add-address", function(e) {
		var container = $(e.currentTarget).parent('div');
		var name 	= container.find("input[name=name]").val();
		var mobile	= container.find("input[name=mobile]").val();
		var address = container.find("textarea[name=address]").val();
		if($.trim(name) != '' && $.trim(mobile) != '' && $.trim(address) != '') {
			$.ajax({
				url:"/address/add",
				data:{
					'name':name,
					'mobile':mobile,
					'address':address
				},
				success:function(json) {
					if(json.success){
						var li = '<li data-id="' + json.result.id + '"><a href="javascript:;" class="radio"><h2>'+json.result.name+' - '+json.result.mobile+'</h2><p>'+json.result.address+'</p></a><a href="javascript:;" class="remove-address">remove</a></li>';
						$('#deliverAddress ul').append(li).listview('refresh');
						container.find("input[name=name]").val('');
						container.find("input[name=mobile]").val('');
						container.find("textarea[name=address]").val('');
						$('#addressDialog').popup('close');
					}
				}
			});
		} else {
			ft.toast("请完善地址信息");
		}
	});
	
	$("#custom-orderBar-create",this).on("tap", function(e){
		var addrli = $('.ui-btn-active','#deliverAddress').parent('li');
		var timeli = $('.ui-btn-active','#deliverTime').parent('li');
		var addressId = addrli.attr('data-id');
		var timeId	  = timeli.attr('data-id');
		if(!addressId) {
			ft.alert("请选择收货地址");
			return;
		}
		if(!timeId) {
			ft.alert("请选择送货时间");
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
			ft.alert('该送货时间已过期，重新选择');
			return;
		}
		deliverTime += (" " + timeli.attr('date-suffix'));
		
		if(ft.confirm("亲，确定下单？" , function(){
			$.ajax({
				url:"/order/add",
				data:{
					'addressId':addressId,
					'deliverTime':deliverTime
				},
				success:function(json){
					if(json.success) {
						$.objCookie('cart',null);
						ft.alert('下单成功' , function(){
							$.mobile.changePage('order', {'reloadpage':true});
						});
					} else {
						ft.alert(json.errorMsg);
					}
				}
			});
		}));
	});
		
	$('.radioList',this).on('tap','.radio', function(e){
		var target = $(e.currentTarget);
		if(target.hasClass('ui-btn-active')) return false;
		target.parents('.radioList').find('.radio').removeClass('ui-btn-active');
		target.addClass('ui-btn-active');
		return false;
	});
});
