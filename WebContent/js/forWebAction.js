/**
 * 此文件用于完成与删除相关的功能
 * @param id
 */


function dispImg (id) {
    var imgTag = document.getElementById("modalImg");
    imgTag.src= "" ;    //此处添加获取图片的地址并在此处将图片ID传给后台
     $("#myModal").modal("toggle");
  }

function afterDelItem(){
	//完成条目删除后的表格刷新     同时将表格中的序号根据重新生成
	var trs=document.getElementsByTagName("tbody")[0].getElementsByTagName("tr");
	var  cells= null;
	for(var i=0;i<trs.length;i=i+1){
		trs.getElementsByTagName("td")[0].innerHTML=i+1;
	}
}

function deleteItem(id){
	var xmlHttp = createXMLHTTP();
	xmlhttp.open("POST", "Regist", true);
	xmlhttp.onreadystatechange=afterDelItem(id);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("itemID"+id);
}

function createXMLHTTP(){
	var xmlHttp=null;
	if (window.XMLHttpRequest) {
		xmlHttp= new XMLHttpRequest();	
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}		
	return xmlHttp;
}