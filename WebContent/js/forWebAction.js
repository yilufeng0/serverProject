/**
 * 此文件用于完成与删除相关的功能
 * 
 */



//用于记录所加载的页面的页码
 var pageNum = 1;


//使用模态框显示图片
function dispImg (id) {
    var imgTag = document.getElementById("modalImg");
     imgTag.src = "exhibition.jsp?id="+id;    //此处添加获取图片的地址并在此处将图片ID传给后台
     $("#myModal").modal("toggle");
  }
//创建新帐户
function createNewAcc(){
	var account= document.getElementById("account").value;
	var passwd= document.getElementById("passwd").value;
	var repasswd= document.getElementById("renewpasswd").value;
	var type=document.getElementById("acctype").value;
	if(passwd!="" && repasswd!="" && passwd ==repasswd && account !=""){
		var xmlhttp = createXMLHTTP();
		xmlhttp.open("POST","createuser.jsp",true);
		xmlhttp.onreadystatechange=doresultaccount;
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("account="+account+"&passwd="+passwd+"&type="+type);
	}else{ //弹出警告
		
	}
}


//完成更改后的提交
function editsubmit(){
	
}

//删除对应条目后的序号重新编排
function afterDelItem(){
	//完成条目删除后的表格刷新     同时将表格中的序号根据重新生成
	var trs=document.getElementsByTagName("tbody")[0].getElementsByTagName("tr");
	for(var i=0;i<trs.length;i=i+1){
		trs[i].getElementsByTagName("td")[0].innerHTML=i+1;
	}
}

//删除特定的序号的条目
function deletedItem(id){
	var tagid=document.getElementById(id);
	tagid.remove();
}



//使用ajax进行远程服务器条目删除请求，并对返回的结果进行处理
function deleteItem(id,type){
	
	var xmlhttp = createXMLHTTP();
	var ID=String(id);
	xmlhttp.open("POST", "deleteItem.jsp?type="+type, true);
	xmlhttp.onreadystatechange=function(){	
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			var result=xmlhttp.responseText.replace(/[\r\n]/g,"");
			if(result == "1"){				
				deletedItem(ID);
				afterDelItem();
			}else { //提示删除错误
				
			}
			
		}
	};
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("id="+ID);
}



//异步加载列表

function loadlist(loadType,acctype){
	var xmlhttp=createXMLHTTP();
	xmlhttp.open("GET","loadlist.jsp?loadType="+loadType+"&pageNum="+pageNum+"&type="+acctype,true);
	//xmlhttp.open("GET","downloadTest.jsp");
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			var result=xmlhttp.responseText.replace(/[\r\n]/g, "");
			if(result != "0"){
				pageNum = pageNum+1;
				appendele(result);
				afterDelItem();
				loaddisp(0);
			}else{
				loaddisp(2);
			}
		}
	};
	xmlhttp.send();
	loaddisp(1);
}

//服务器端反馈操作
function loaddisp(id){
	var tagstartload=document.getElementById("startload");
	var tagloading=document.getElementById("loading");
	var tagloaded= document.getElementById("allloaded");
	
	tagstartload.style.display="none";
	tagloading.style.display="none";
	tagloaded.style.display="none";
	
	switch(id){
	case 0:
		tagstartload.style.display="";
		break;
	case 1:
		tagloading.style.display="";
		break;
	case 2:
		tagloaded.style.display="";
		break;
		
	}
}

//将获取的列表进行显示
function appendele(eles){
	$(eles).insertBefore("#endpos");
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