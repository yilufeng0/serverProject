
function editItem(id){
	editaccount(id);
}

function editaccount(id){
	document.getElementById("submitid").innerHTML=id;
	$("#myModal").modal("toggle");
}


//生成ajax连接
function createXMLHTTP(){
	var xmlHttp=null;
	if (window.XMLHttpRequest) {
		xmlHttp= new XMLHttpRequest();	
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}		
	return xmlHttp;
}


function suretofix(){
	var tagid=document.getElementById("submitid").innerHTML;
	var oripass=document.getElementById("oripasswd").value;
	var newpass=document.getElementById("newpasswd").value;
	var renewpass=document.getElementById("renewpasswd").value;
	if(newpass!="" && newpass !="" && newpass ==renewpass){	
		xmlhttp=createXMLHTTP();
		xmlhttp.open("POST","editItem.jsp?type=account",true);
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
				var result = xmlhttp.responseText.replace(/[\r\n]/g,"");
				if(result=="1"){				
					$("#myModaldes").modal("toggle");
				}
			}
		};
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("id="+tagid+"&passwd"+oripass+"&renewpasswd"+newpass);		
	}	
	
}

