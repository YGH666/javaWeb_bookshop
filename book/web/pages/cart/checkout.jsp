<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/9
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../commons/header.jsp"%>
</head>
<body>
<div style="position: absolute;left: 50%;top: 50%;transform: translate(-50%,-50%);text-align: center">
    <h1>您的订单已结算,订单号为<span>${sessionScope.orderId}</span></h1>
</div>
</body>
</html>
