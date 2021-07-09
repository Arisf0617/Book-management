<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询</title>
</head>
<body>
<%
        Object uid = request.getAttribute("uid");
    %>
当前用户：<%=uid%>  
    <div align="center">
        <h1 >信息列表</h1>
        <h3>当前时间：<input  id="sysDate" style="font-size:18.72px;color:red;width: 320px;text-align: center;"></h3>
          <h1> 
        <form action="SearchServlet" method="post">
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
                    <td><a href="Servlet?method=borrow&id=${item.id}&name=${item.name}&writer=${item.writer}&press=${item.press}&num=${item.num}&uid=<%=uid%> " 
                    onclick="next()">订阅</a></td>
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
		var d = new Date();
		d.setMonth(d.getMonth()+3);
		d=d.toLocaleString();


		function next(){
			alert('订阅成功！还书日期为'+d);
		}
		
	

</script>
</html>