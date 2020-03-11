<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/4
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
%>
<base href="<%=basePath%>">
<link rel="stylesheet" href="static/layui/css/layui.css">
<script src="static/layui/layui.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

