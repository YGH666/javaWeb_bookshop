<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="yangguohao.pojo.Studentt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/3
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach begin="1" end="10" var="i">
        第${i}行<br>
    </c:forEach>
<hr>
<%
    request.setAttribute("arr",new String[]{"123123","232323","333333"});
%>
    <table border="1" cellspacing="0">
        <tr>
            <th>电话号码</th>
        </tr>
        <c:forEach items="${requestScope.arr}" var="item">
            <tr>
                <td>${item}</td>
            </tr>
        </c:forEach>
    </table>
<hr>
<%
    HashMap<String, Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    map.put("key4","value4");
    request.setAttribute("map",map);
//    for (Map.Entry<String, Object> entry : map.entrySet()) {
//        System.out.println(entry.getKey()+entry.getValue());
//    }
%>
<c:forEach var="i" items="${requestScope.map}">
    <h1>${i.key}=${i.value}</h1>
</c:forEach>

<hr>
<%
    List<Studentt> studentList = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
        studentList.add(new Studentt(i,"username-"+i,"pass-"+i,18+i,"phone-"+i));
    }
    request.setAttribute("stus",studentList);
%>
    <table cellspacing="0" border="1" style="text-align: center">
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
    <c:forEach var="stu" items="${requestScope.stus}" begin="0" end="10" step="2">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.username}</td>
            <td>${stu.password}</td>
            <td>${stu.age}</td>
            <td>${stu.phone}</td>
            <td><button>删除</button>  <button>修改</button></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
