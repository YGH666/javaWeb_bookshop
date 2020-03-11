<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/2
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/day02_jsp/">
</head>
<body>
    <h1>jsp九大内置对象</h1>
    1.request------请求对象<br>
    2.response------响应对象<br>
    3.pageContext-----jsp上下文对象<br>
    4.session-----会话对象<br>
    5.application-----ServletContext对象<br>
    6.config-------ServletConfig对象<br>
    7.out------jsp输出流对象<br>
    8.page-------指向当前jsp对象<br>
    9.exception------异常对象<br>

    <h2>jsp四大域对象</h2>
    <img src="img/review.png" width="749" height="247">
    <br>
    <%
        out.write(65);
//        write方法会查找对应的ASCII码的字符 65----A
        out.print(15);
    %>
</body>
</html>
