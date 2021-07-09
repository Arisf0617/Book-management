<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员主页</title>
</head>
<body>
<%
        Object uid = request.getAttribute("uid");
        if (uid != null && !"".equals(uid)) {
    %>
    <script type="text/javascript">
              alert("工号"+<%=request.getAttribute("uid")%>+'你好！'); //弹出对话框
    </script>
    <%
        }
    %>
当前用户：<%=uid %>     
   <div align="center" font-size="30px">
        <h1>管理员</h1>
        <div>
            <a  href="add user.jsp">添加用户信息</a>
        </div>
        <div>
            <a href="add book.jsp">添加新书信息</a>
        </div>
        <div>
            <a href="Servlet?method=list_admin">删除书目信息</a>
        </div>
        <div>
            <a href="Servlet?method=list_overtime&uid=<%=uid%>">打印催还书目</a>
        </div>
    </div>
</body>
</html>