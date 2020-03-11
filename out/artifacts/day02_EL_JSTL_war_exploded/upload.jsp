<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/3
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/day02_EL_JSTL/uploadServlet" method="post" enctype="multipart/form-data">
        用户名:<input type="text" name="name"><br>
        头像:<input type="file" name="photo"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
