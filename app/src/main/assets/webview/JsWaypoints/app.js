$(function(){
	alert("starting");		
	
	$("body").click(function(e){
		
		
		var href=$(e.target).attr("href");
		
		if(!href) return;
		
		if(href.indexOf("#")===0){
			var arr=href.substr(1).split("/");
			var func=arr.shift();
			var text=JsApp.t("version");
			JsApp[func](text);
			//JsApp[func].apply(null,arr);
			return false;
		}
	});
	//JsApp.showToast("bbbbb");
});
