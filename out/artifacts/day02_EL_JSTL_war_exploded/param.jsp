<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/3
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
?pass=123456&name=123&hobby=java&hobby=cpp<br>

param.name=    ${param.name}<br>
param.pass=    ${param.pass}<br>
paramValues.hobby[0]=    ${paramValues.hobby[0]}<br>
paramValues.hobby[1]=    ${paramValues.hobby[1]}<br>
<hr>
${header}<br><br>
header["User-Agent"]=    ${header["User-Agent"]}<br>
<hr>
cookie.JSESSIONID.name=     ${cookie.JSESSIONID.name}<br>
cookie.JSESSIONID.value=     ${cookie.JSESSIONID.value}<br>
<hr>
initParam.name=  ${initParam.name}
</body>
</html>
