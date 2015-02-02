//用于动态调整页面主显示区的高度

function setContentHeight(id,ratio){
	var tagId=document.getElementById(id);
	var contentHeight = window.innerHeight*ratio;
	//alert(tagId);
	tagId.style.height=contentHeight+"px";
}