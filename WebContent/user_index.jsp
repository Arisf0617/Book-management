<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
               <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>读者功能页</title>
</head>
<body>
<%
        Object uid = request.getAttribute("uid");
        if (uid != null && !"".equals(uid)) {
    %>
    <script type="text/javascript">
              alert("欢迎您！读者"+<%=request.getAttribute("uid")%>); //弹出对话框
    </script>
    <%
        }
    %>
当前用户：<%=uid %>    
    <div align="center" font-size="30px">
        <h1>读者</h1>
        <div>
            <a  href="Servlet?method=list&uid=<%=uid%>">浏览图书信息</a>
        </div>
        <div>
            <a href="Servlet?method=list&uid=<%=uid%>">查询图书信息</a>
        </div>
        <div>
            <a href="Servlet?method=list&uid=<%=uid%>">借阅图书</a>
        </div>
        <div>
            <a href="Servlet?method=Mylist&uid=<%=uid%>">浏览催还书目</a>
        </div>
        <div>
            <a href="Servlet?method=Mylist&uid=<%=uid%>">归还图书</a>
        </div>
    </div>
</body>
</html>