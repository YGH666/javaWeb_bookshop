<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/3
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext</title>
</head>
<body>
<%
    pageContext.setAttribute("req",request);
%>
<%--    1.协议：${pageContext.request.scheme}<br>--%>
<%--    2.服务器ip：${pageContext.request.serverName}<br>--%>
<%--    3.服务器端口：${pageContext.request.serverPort}<br>--%>
<%--    4.获取工程路径：${pageContext.request.contextPath}<br>--%>
<%--    5.获取请求方法：${pageContext.request.method}<br>--%>
<%--    6.获取客户端ip地址：${pageContext.request.remoteHost}<br>--%>
    1.协议：${req.scheme}<br>
    2.服务器ip：${req.serverName}<br>
    3.服务器端口：${req.serverPort}<br>
    4.获取工程路径：${req.contextPath}<br>
    5.获取请求方法：${req.method}<br>
    6.获取客户端ip地址：${req.remoteHost}<br>
    7.获取会话id编号：${pageContext.session.id}<br>
</body>
</html>
