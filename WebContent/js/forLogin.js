
var xmlhttp=null;
var passwd=null;
function createXMLHTTP(){	
	if (window.XMLHttpRequest) {
		xmlhttp= new XMLHttpRequest();	
	}else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}		
	return xmlhttp;
}

function afterSubmit(){
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
    {
		var result=xmlhttp.responseText;
	    if(result == 1){		//成功登录，进行页面的跳转
	    	window.location.href="index.jsp";
	    }else{							//告知用户密码错误
	    	
	    }
    }
//	var passwd= document.getElementById("passwd");
}
function getSubmit(){
	passwd= document.getElementById("passwd");
	createXMLHTTP();
	xmlhttp.open("POST", "LoginAction.jsp", true);
	xmlhttp.onreadystatechange=afterSubmit;
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("passwd"+passwd.value);
}


function mainPaeSubmit(){
	passwd= document.getElementById("passwd");
	var account = document.getElementById("account");
	createXMLHTTP();
	xmlhttp.open("POST", "LoginAction.jsp", true);
	xmlhttp.onreadystatechange=afterSubmit;
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("passwd"+passwd.value+"&account="+account.value);
}