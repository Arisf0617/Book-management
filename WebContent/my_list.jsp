<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的借阅</title>
</head>
<body>
<%
        Object uid = request.getAttribute("uid");
    %>

当前用户：<%=uid%> 
<div align="center">
        <h1 >我的借阅</h1>
        <h3>当前时间：<input  id="sysDate" style="font-size:18.72px;color:red;width: 320px;text-align: center;"></h3>

        <table >
            <tr>
                <td>图书编号</td>
                <td>书名</td>
                <td>作者名</td>
                <td>出版社名称</td>
                <td>还书日期</td>
                <td align="center" colspan="2">操作</td>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.writer}</td>
                    <td>${item.press}</td>
                    <td>${item.date}</td>
                    <td><a href="Servlet?method=return_book&id=${item.id}&uid=<%=uid%>" 
                    >还书</a></td>
                </tr>
            </c:forEach>
        </table>
    </div> 

</body>
<script type="text/javascript">

		/*---------- 动态获取系统当前日期方法start ------*/
		setInterval(
				"document.getElementById('sysDate').value=new Date().toLocaleString()+'  星期'+'日一二三四五六'.charAt(new Date().getDay());",
				1000);
		setInterval(
				"document.getElementById('sysSysDate').value=new Date().toLocaleString();",
				1000);
 
		/*---------- 动态获取系统当前日期方法end ------*/

</script>
</html>