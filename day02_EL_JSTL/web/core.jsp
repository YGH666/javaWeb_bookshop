<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/3
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>c:set标签</h2>
保存到request域之前requestScope.test：${requestScope.test}<br>
c:set操作<c:set scope="request" var="test" value="testValue"></c:set><br>
保存到request域之后requestScope.test：${requestScope.test}<br>
<hr>
<h2>c:if标签</h2>
c:if test="requestScope.test!=null"<br>
<c:if test="${requestScope.test!=null}">
    <h1>test的值不为空</h1>
</c:if>
<hr>
c:choose c:when c:otherwise标签
<%
    request.setAttribute("height","170");
%>
<c:choose>
    <c:when test="${requestScope.height > 180}">
        <h2>大于180</h2>
    </c:when>
    <c:when test="${requestScope.height > 170}">
        <h2>大于170</h2>
    </c:when>
    <c:otherwise>
        <h2>剩下的小于等于170</h2>
    </c:otherwise>
</c:choose>
<hr>




</body>
</html>
