<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/2
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    页脚信息<br>
    <%
        for (int i = 0; i < 10; i++){
    %>
    这是第<%=i%>行页脚<br>
    <%
        }
    %>
    维护信息<%=request.getParameter("username")%>
</body>
</html>
