<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jspsmart.upload.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MultiUpload-Index</title>
<script type="text/javascript">
function addFile(){
    var myTB = document.getElementById("myTB");
    var rowNum = myTB.rows.length; //有多少个<tr>
    var newRow = myTB.insertRow(rowNum);
    var cells_0 = newRow.insertCell(0);
    cells_0.innerHTML = "上传文件：";
    var cells_1 = newRow.insertCell(1);
    cells_1.innerHTML = "<input type='file' name='nfile' id='a'>";  
//    var file = document.getElementById("a");
//    file.name = "file1"
//    alert(file.name);
    var cells_2 = newRow.insertCell(2);
    cells_2.innerHTML = "<input type='text' name='ncomment'>";  
   }
</script>
</head>
<body>
 <form method="post" action="AddNewsServlet" enctype="multipart/form-data">
  <table id="myTB">
  <tr>
   <td>上传文件：</td>
   <td><input type="file" name="nfile" id="a"></td>
   <td><input type="text" name="comment1"></td>
  </tr>
  
  <tr>
   <td>上传文件：</td>
   <td><input type="file" name="nfile" id="a"></td>
   <td><input type="text" name="comment2"></td>
  </tr>
  
  <tr>
   <td>上传文件：</td>
   <td><input type="file" name="nfile" id="a"></td>
   <td><input type="text" name="comment3"></td>
  </tr>

  </table>
  <input type="button" value="添加文件" onclick="addFile()"><br>
  <input type="submit" value="上传">
 </form>
</body>
</html>