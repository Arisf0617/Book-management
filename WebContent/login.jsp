	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
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
<form name="user" action="LoginServlet" method="post" onsubmit="return check()">
      <table id="addTable" class="table table-bordered" align="center">                 
      
       <tr class="text-center row">
                <td class="col-sm-2">
                    学号/工号     
                </td>
                <td class="col-sm-4">
                   	<input type="number" class="form-control"  name="uid" id="uid" >
                </td>
       </tr>           
                 
       <tr class="text-center row">
                <td class="col-sm-2">              
                  	密码
                </td>
                <td class="col-sm-4">
                  <input type="password" class="form-control"  name="password" id="password">
                </td>
       </tr>
       
       <tr class="text-center row">
                <td class="col-sm-2">
                  	验证码
                  	
                </td>
                <td class="col-sm-4">
                  <input type="text" placeholder="输入验证码" name="ValiImage" id="ValiImage" /><!-- 输入验证码文本 -->
                </td>
       </tr>
       
      <tr class="text-center row">
      			<td class="col-sm-2">
                </td>
                <td class="col-sm-4">
                  <img src="VerifyCode" onclick="changeValiImage(this)"><!-- 验证码图片 -->
                </td>
       </tr>
		
       <tr class="text-center row">
                <td>
                  登陆身份
                </td>
                <td colspan="3">
                  <select class="form-control" id="identity" name="identity">
                    <option value="读者">读者</option>
                    <option value="管理员">管理员</option>
                  </select>
                </td>
       </tr>
       
       
        <tr class="text-center row" align="center">
                <td colspan="3">
					<input type="submit" value="登录" >   
                </td>
       </tr>      
       </table>

</form>
<script type="text/javascript">

		function check(){
			if(user.uid.value==""||user.uid.value==null){
				alert("学号/工号为空!");
				return false;
			}
			if(user.password.value==""||user.password.value==null){
				alert("密码为空！");
				return false;
			}
			
		}	
		function changeValiImage(img){
				img.src = "VerifyCode?time=" + new Date().getTime();
		}
	
</script>
</body>
</html>