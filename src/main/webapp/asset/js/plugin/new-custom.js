$.isEmpty = function(obj){
	for(var n in obj)
			return false;
		return true; 
};
var cart={
	setCount:function(id,num){
		var obj = $.objCookie('cart') || {};
		if(num) obj[id] = num;
		else delete obj[id];
		$.objCookie('cart',obj);
	}
}
