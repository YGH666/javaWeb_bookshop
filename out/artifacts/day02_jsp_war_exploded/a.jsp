<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/2
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page import="" %>--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="utf-8"
         autoFlush="true"
         buffer="8kb"
         errorPage="/error500.jsp"
         language="java" %>
<%--errorpage表示页面错误后自动跳转的路径--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是jsp页面
    <%
        int a = 5 / 0;
    %>
</body>
</html>
