<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/2
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table cellpadding="0" style="width: 650px;margin: auto">
    <%
        for (int i = 1; i <= 9; i++) {
            out.print("<tr>");
            for (int j = 1; j <= i; j++) {
    %>
    <td><%=i + "X" + j + "=" + i*j + "   "%></td>
    <%
            }
            out.print("<tr/>");
        }
    %>
</table>
</body>
</html>
