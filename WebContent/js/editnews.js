

var ue;  //用于存放编辑器
var Id;
function editItem(id){
	Id=id;
	ue=UE.getEditor('editcontent');	
	getcontent();
}

function getcontent(){
	var xmlhttp=createXMLHTTP();
	xmlhttp.open("POST","getcontent.jsp",true);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			var result = xmlhttp.responseText.replace(/[\r\n]/g,"");
			dispmodal(result);
		}
	};
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("id="+Id);
}

function dispmodal(content){
	document.getElementById("edittitle").innerHTML=document.getElementById("title"+Id).innerHTML;
	ue.setContent(content);
	document.getElementById("submitid").innerHTML=Id;
	$("#myModal").modal("toggle");
}

function suretopush(){
	var tagid=document.getElementById("submitid").innerHTML;
	var content= ue.getPlainTxt();
	
	xmlhttp=createXMLHTTP();
	xmlhttp.open("POST","editItem.jsp?type=news",true);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			var result = xmlhttp.responseText.replace(/[\r\n]/g,"");
			if(result=="1"){
				$("#myModal").modal("toggle");
			}
		}
	};
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("id="+tagid+"&content="+content);
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
