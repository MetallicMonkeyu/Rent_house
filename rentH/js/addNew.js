(function() {
	var index = 1;
	var size = null;
	var imageIndexIdNum = 0;
	//var starIndex = 0;
	var addNew = {
		imageList: document.getElementById('image-list'),
	}
	addNew.files = [];
	addNew.uploader = null;  
	addNew.deviceInfo = null; 
	mui.plusReady(function() {
		//设备信息，无需修改
		addNew.deviceInfo = {
			appid: plus.runtime.appid, 
			imei: plus.device.imei, //设备标识
			images: addNew.files, //图片文件
			p: mui.os.android ? 'a' : 'i', //平台类型，i表示iOS平台，a表示Android平台。
			md: plus.device.model, //设备型号
			app_version: plus.runtime.version,
			plus_version: plus.runtime.innerVersion, //基座版本号
			os:  mui.os.version,
			net: ''+plus.networkinfo.getCurrentType()
		}
	});
	addNew.clearForm = function() {
		addNew.imageList.innerHTML = '';
		addNew.newPlaceholder();
		addNew.files = [];
		index = 0;
		size = 0;
		imageIndexIdNum = 0;
	//	starIndex = 0;
		//清除所有星标
//		mui('.icons i').each(function (index,element) {
//			if (element.classList.contains('mui-icon-star-filled')) {
//				element.classList.add('mui-icon-star')
//	  			element.classList.remove('mui-icon-star-filled')
//			}
//		})
	};
	addNew.getFileInputArray = function() {
		return [].slice.call(addNew.imageList.querySelectorAll('.file'));
	};
	addNew.addFile = function(path) {
		addNew.files.push({name:"images"+index,path:path,id:"img-"+index});
		index++;
	};
	/**
	 * 初始化图片域占位
	 */
	addNew.newPlaceholder = function() {
		var fileInputArray = addNew.getFileInputArray();
		//alert(fileInputArray)
		if (fileInputArray &&
			fileInputArray.length > 0 &&
			fileInputArray[fileInputArray.length - 1].parentNode.classList.contains('space')) {
			//alert
			return;
		};
		imageIndexIdNum++;
		var placeholder = document.createElement('div');
		
		placeholder.setAttribute('class', 'image-item space');
		var up = document.createElement("div");
		up.setAttribute('class','image-up')
		var pickPhoto = document.createElement('a');
		pickPhoto.href = "#pickPhoto";
		//删除图片
		var closeButton = document.createElement('div');
		closeButton.setAttribute('class', 'image-close');
		closeButton.innerHTML = 'X';
		closeButton.id = "img-"+index;
		//小X的点击事件
		closeButton.addEventListener('tap', function(event) {
			setTimeout(function() {
				for(var temp=0;temp<addNew.files.length;temp++){
					if(addNew.files[temp].id==closeButton.id){
						addNew.files.splice(temp,1);
					}
				}
				addNew.imageList.removeChild(placeholder);
			}, 0);
			return false;
		}, false);
		
		//
		var fileInput = document.createElement('div');
		fileInput.setAttribute('class', 'file');
		fileInput.setAttribute('id', 'image-' + imageIndexIdNum);
		
		placeholder.appendChild(pickPhoto);
		pickPhoto.appendChild(closeButton);
		pickPhoto.appendChild(up);
		pickPhoto.appendChild(fileInput);
		addNew.imageList.appendChild(placeholder);
	};
	addNew.newPlaceholder();
	//alert(addNew.files.length)
	pickPhoto.childNode.addEventListener('tap', function(event) {
			
			if (addNew.files.length>1){
				mui.toast("最多添加两张照片");
				return;
			}
			var self = this;
			var index = (this.id).substr(-1);
			
			plus.gallery.pick(function(e) {
//				console.log("event:"+e);
				var name = e.substr(e.lastIndexOf('/') + 1);
				console.log("name:"+name);
					
				plus.zip.compressImage({
					src: e,
					dst: '_doc/' + name,
					overwrite: true,
					quality: 50
				}, function(zip) {
					size += zip.size  
					console.log("filesize:"+zip.size+",totalsize:"+size);
					if (size > (10*1024*1024)) {
						return mui.toast('文件超大,请重新选择~');
					}
					if (!self.parentNode.classList.contains('space')) { //已有图片
						addNew.files.splice(index-1,1,{name:"images"+index,path:e});
					} else { //加号
						fileInputArray[fileInputArray.length - 1].parentNode.parentNode.classList.remove('space');
						addNew.addFile(zip.target);
						addNew.newPlaceholder();
					}
					fileInputArray[fileInputArray.length - 1].parentNode.previousElementSibling.classList.remove('image-up');
					fileInputArray[fileInputArray.length - 1].parentNode.parentNode.style.backgroundImage = 'url(' + zip.target + ')';
				}, function(zipe) {
					mui.toast('压缩失败！')
				});
				

				
			}, function(e) {
				mui.toast(e.message);
			},{});
		}, false);
	})()
