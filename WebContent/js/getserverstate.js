/**
 * 此文件用于完成与服务器状态相关的功能
 * @param id
 */



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


function getserverstate(){
	var xmlhttp=createXMLHTTP();
	xmlhttp.open("Get", "getserverinfo.jsp", true);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			var jresult=JSON.parse(xmlhttp.responseText.replace(/[\r\n]/g,""));
			updatememstate(parseFloat(jresult.memRatio));
			updatediskstate(jresult.diskAll,parseFloat(jresult.diskRation));
		}
	};
	xmlhttp.send(null);
	
}

function timer(){
	setInterval("getserverstate()",1000);
}




function updatediskstate(diskall,diskratio){
	 document.getElementById("diskall").innerHTML=diskall;
	 document.getElementById("diskratio").innerHTML=(diskratio);
	 var doughnutData = [
	                      {
	                        value: diskratio,
	                        color:"#68dff0"
	                      },
	                      {
	                        value : 100-diskratio,
	                        color : "#444c57"
	                      }
	                    ];
	 var conf={animation : false};
	 var myDoughnut = new Chart(document.getElementById("serverstatus02").getContext("2d")).Doughnut(doughnutData,conf);
}

function updatememstate(memratio){
	
	document.getElementById("memstatetitle").innerHTML=memratio;
	var doughnutData = [
                        {

                          value: memratio,
                          color:"#68dff0",
                          animation : false
                        },
                        {
                          value : 100-memratio,
                          color : "#fdfdfd",
                      	animation : false
                        }
                      ];
	var conf = {animation : false};
    var myDoughnut = new Chart(document.getElementById("serverstatus01").getContext("2d")).Doughnut(doughnutData,conf);
}
