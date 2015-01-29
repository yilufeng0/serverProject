function createXMLHTTP(){
	var xmlHttp=null;
	if (window.XMLHttpRequest) {
		xmlHttp= new XMLHttpRequest();	
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}		
	return xmlHttp;
}

function afterSubmit(){
	if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    if(xmlhttp.responseText()){		//成功登录，进行页面的跳转
    	
    }else{							//告知用户密码错误
    	
    }
    }
	var passwd= document.getElementById("passwd");
}
function getSubmit(){
	var passwd= document.getElementById("passwd");
	var xmlhttp=createXMLHTTP();
	xmlhttp.open("POST", "Regist", true);
	xmlhttp.onreadystatechange=afterSubmit();
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("UserPasswd"+passwd.value());
}