
function editItem(id){
	editcpimgdes(id);
	
}
function editcpimgdes(id){
	var desId ="des"+id;
	document.getElementById("modaldes").value=document.getElementById(desId).innerHTML;
	document.getElementById("submitid").innerHTML=id;
	$("#myModaldes").modal("toggle");
}

function suretodesc(){
	var tagid=document.getElementById("submitid").innerHTML;
	var desc=document.getElementById("modaldes").value;
	xmlhttp=createXMLHTTP();
	xmlhttp.open("POST","editItem.jsp?type=cpimg",true);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			var result = xmlhttp.responseText.replace(/[\r\n]/g,"");
			if(result=="1"){
				document.getElementById("des"+tagid).innerHTML=desc;
				$("#myModaldes").modal("toggle");
			}
		}
	};
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("id="+tagid+"&description="+desc);
	
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
