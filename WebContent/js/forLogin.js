/**
 * 此文档用于实现账户的验证机登录功能
 * @
 */

//创建连接
function createXMLHTTP(){
	var xmlHttp=null;
	if (window.XMLHttpRequest) {
		xmlHttp= new XMLHttpRequest();	
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}		
	return xmlHttp;
}

//执行提交后的操作
function afterSubmit(result){
    if(result == "1"){		//成功登录，进行页面的跳转    	
    	self.location="index.jsp";    	
    }else{							//告知用户密码错误
    	alert("用户名或密码错误!");
    }    
}

//锁屏后点击登陆
function getSubmit(){
	var passwd= document.getElementById("passwd");
	var xmlhttp=createXMLHTTP();
	xmlhttp.open("POST", "accountauth.jsp", true);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			var result=xmlhttp.responseText.replace(/[\r\n]/g,"");							
			afterSubmit(result);
		}
	};
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("passwd="+passwd.value);
}


//
function mainPaeSubmit(){
	var passwd= document.getElementById("passwd");
	var account = document.getElementById("account");
	if(passwd !="" && account !=""){
		var xmlhttp=createXMLHTTP();
		xmlhttp.open("POST", "accountauth.jsp", true);
		xmlhttp.onreadystatechange=function(){
			//alert(xmlhttp.readyState);
			if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
				var result=xmlhttp.responseText.replace(/[\r\n]/g,"");							
				afterSubmit(result);
			}
		};
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("passwd="+passwd.value+"&account="+account.value);
	}
}