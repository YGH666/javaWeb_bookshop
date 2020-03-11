<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/4
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 style="margin: auto">恭喜<span>${sessionScope.user.username}</span> 登陆成功！</h1>
    <a href="pages/manager/manager_menu.jsp">管理</a>
</body>
</html>
