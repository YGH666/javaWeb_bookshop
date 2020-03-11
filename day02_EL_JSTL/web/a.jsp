<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/2
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key","value");
    %>
    表达式脚本输出key的方式：<%=request.getAttribute("key")%><br>
    EL表达式输出key的方式：${key}
</body>
</html>
