<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
               <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除</title>
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

    <div align="center">
        <h1 >信息列表</h1>
          <h1> 
        <form action="searchServlet_admin" method="post">
        <select name="cxfs">
  <option  id="cxfs"value ="1">书名</option>
  <option  id="cxfs" value ="2">作者名</option>
</select>
            <input type="text" id="value" name="value" placeholder="请输入条件">
            <input type="submit" id="select" name="select" value="查询" />
      </form>
        
        </h1>
        <table >
            <tr>
                <td>图书编号</td>
                <td>书名</td>
                <td>作者名</td>
                <td>出版社名称</td>
                <td>可借阅数量</td>
                <td align="center" colspan="2">操作</td>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.writer}</td>
                    <td>${item.press}</td>
                    <td>${item.num}</td>
                    <td><a href="Servlet?method=delete_book&id=${item.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>