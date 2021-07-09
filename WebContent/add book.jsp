<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加新书信息</title>
</head>
<body>
<%
        Object message = request.getAttribute("message");

        if (message != null && !"".equals(message)) {
    %>
    <script type="text/javascript">
              alert("<%=request.getAttribute("message")%>"); //弹出对话框
    </script>
    <%
        }
    %>

<form action="Servlet?method=insert_book" method="post">

      <table id="addTable" class="table table-bordered  ">
      
      <tr class="text-center row">
                <td class="col-sm-2">
                图书编号
                </td>
                <td class="col-sm-4">
                    <input type="text" class="form-control"  name="id" id="id" >
                </td>
       </tr>         
                  
      
       <tr class="text-center row">
                <td class="col-sm-2">
                书名
                </td>
                <td class="col-sm-4">
                   	<input type="text" class="form-control"  name="name" id="name" >
                </td>
       </tr>           
                  

       <tr class="text-center row">
                <td class="col-sm-2">
                作者名
                </td>
                <td class="col-sm-4">
                   	<input type="text" class="form-control"  name="writer" id="writer" >
                </td>
       </tr>
       
       <tr class="text-center row">
                <td class="col-sm-2">
                出版社名
                </td>
                <td class="col-sm-4">
                   	<input type="text" class="form-control"  name="press" id="press" >
                </td>
       </tr>
       
       <tr class="text-center row">
                <td class="col-sm-2">
                可借阅数量
                </td>
                <td class="col-sm-4">
                   	<input type="text" class="form-control"  name="num" id="num" >
                </td>
       </tr> 
       
             
       
       </table>
            <input type="submit" value="添加" onclick="check()">         
</form> 
</body>
<script type="text/javascript">
        function check() //封装一个<body>中做成点击事件的函数
        {
        	if(document.getElementById('id').value=='') {
        		  alert('图书编号不能为空！');
        		  document.getElementById('id').focus();
        		  return false;
        	}
        	if(document.getElementById('name').value==''){
        		  alert('书名不能为空！');
      		      document.getElementById('name').focus();
      		      return false;
        	}
        	if(document.getElementById('writer').value=='') {
      		  	  alert('作者名不能为空！');
      		  	  document.getElementById('writer').focus();
      		  	  return false;
      		 }
        	else if(document.getElementById('press').value==''){
        		  alert('出版社名不能为空！');
        		  document.getElementById('press').focus();
        		  return false;
        	}
        	if(document.getElementById('num').value=='') {
      		  	  alert('借阅数量不能为空！');
      		  	  document.getElementById('num').focus();
      		  	  return false;
      		 }
        }
        
    </script>
</html>