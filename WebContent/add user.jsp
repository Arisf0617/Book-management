<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加读者信息</title>
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

<form action="Servlet?method=insert_user" method="post">

      <table id="addTable" class="table table-bordered  ">
      
      <tr class="text-center row">
                <td class="col-sm-2">
                账号
                </td>
                <td class="col-sm-4">
                    <input type="text" class="form-control"  name="uid" id="uid" >
                </td>
       </tr>         
                  
      
       <tr class="text-center row">
                <td class="col-sm-2">
                姓名
                </td>
                <td class="col-sm-4">
                   	<input type="text" class="form-control"  name="name" id="name" >
                </td>
       </tr>
       
       <tr class="text-center row">
                <td class="col-sm-2">
                密码
                </td>
                <td class="col-sm-4">
                    <input type="text" class="form-control"  name="password" id="password" >
                </td>
       </tr>           
                  
			  <tr>
                <td class="col-sm-2">
                  性别
                </td>
                <td class="col-sm-4">
                          <input type="radio"  name="sex" id="sex" value="男">男
                          <input type="radio"  name="sex" id="sex" value="女">女
                </td>
              </tr>


       <tr class="text-center row">
                <td class="col-sm-2">
                所在学院
                </td>
                <td class="col-sm-4">
                   	<input type="text" class="form-control"  name="college" id="college" >
                </td>
       </tr> 
       
		<tr class="text-center row">
                <td>
                  身份
                </td>
                <td colspan="3">
                  <select class="form-control" id="identity" name="identity">
                    <option value="读者">读者</option>
                    <option value="管理员">管理员</option>
                  </select>
                </td>
              </tr>
       
      
       </table>
            <input type="submit" value="添加" onclick="check()">         
</form> 
</body>
<script type="text/javascript">
        function check() //封装一个<body>中做成点击事件的函数
        {
        	if(document.getElementById('uid').value=='') {
        		  alert('账号不能为空！');
        		  document.getElementById('uid').focus();
        		  return false;
        	}
        	if(document.getElementById('password').value==''){
      		  	  alert('密码不能为空！');
    		      document.getElementById('password').focus();
    		      return false;
      		}
        	if(document.getElementById('name').value==''){
        		  alert('姓名不能为空！');
      		      document.getElementById('name').focus();
      		      return false;
        	}
        	if(document.getElementById('college').value==''){
        		  alert('所在学院不能为空！');
        		  document.getElementById('college').focus();
        		  return false;
        	}
        	if(document.getElementById('sex').value==''){
      		  alert('性别不能为空！');
      		  document.getElementById('sex').focus();
      		  return false;
      	}
        }
        
    </script>
</html>