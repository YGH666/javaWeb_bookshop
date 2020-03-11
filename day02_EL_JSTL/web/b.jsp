<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/2
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key1","pageContext");
        request.setAttribute("key1","request");
        session.setAttribute("key1","session");
        application.setAttribute("key1","application");
    %>
    ${key1}<br>
    ${pageScope.key1}<br>
    ${requestScope.key1}<br>
    ${sessionScope.key1}<br>
    ${applicationScope.key1}<br>
</body>
</html>
