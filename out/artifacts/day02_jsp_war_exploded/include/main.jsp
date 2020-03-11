<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/2
  Time: 15:57
  To change this template use File | Settings | File Templates.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br>
    主题信息<br>
<%--
    静态包含
    适合于代码重用,原理是
    1.不会翻译被包含的jsp页面
    2.就是简单的拷贝
    <%@include file="/include/footer.jsp"%>
--%>

    <%--
        动态包含
        1.会被翻译成java代码
        2.会使用如下代码调用被包含的jsp页面执行输出
        JspRuntimeLibrary.include(request,response,"/include/footer.jsp",out,false);
    --%>
    <jsp:include page="/include/footer.jsp">
        <jsp:param name="username" value="yangguohao"/>
    </jsp:include>

<%--    请求转发--%>
<%--    <jsp:forward page="/include/footer.jsp"></jsp:forward>--%>

</body>
</html>
