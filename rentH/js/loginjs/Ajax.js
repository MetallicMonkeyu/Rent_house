	function publicAjax(PrivateUrl, jsonData,msg) {
	if(window.plus && plus.networkinfo.getCurrentType() === plus.networkinfo.CONNECTION_NONE) {
		plus.nativeUI.toast('似乎已断开与互联网的连接', {
			verticalAlign: 'top'
		});
		return;
	}
	
	//设置全局beforeSend 
	mui.ajaxSettings.beforeSend = function(xhr, setting) { 
		console.log('beforeSend:::' + JSON.stringify(setting));
		plus.nativeUI.showWaiting(msg);
	};
	//设置全局complete 
	mui.ajaxSettings.complete = function(xhr, status) {
		console.log('complete:::' + status);
		plus.nativeUI.closeWaiting();
	}
	mui.ajax("http://192.168.70.102:8080/app/"+PrivateUrl, {
		data: jsonData.data, 
		dataType: 'json',
		type: 'post',
		timeout: 10000,
		async: false,
		success: function(data) {
			//转换为string字符串 
			console.log(JSON.stringify(data));
			webServiceJson = data;
		},
		error: function(xhr, type, errorThrown) {
webServiceJson = "";
			mui.toast('服务器异常，请稍后重试！')
//			console.log(JSON.stringify(xhr));
//			console.log(type);
//			console.log(errorThrown);
			
		}
		
	});
	return webServiceJson;
	
}