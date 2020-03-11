<%@ page import="java.util.ArrayList" %>
<%@ page import="yangguohao.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/2
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border-collapse: collapse;
        }

        tr,td,th{
            border: 1px solid red;
            text-align: center;
        }
    </style>
</head>
<body>
    <%
        ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("stuList");
    %>

    <table align="center" width="650">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>age</th>
            <th>phone</th>
        </tr>
    <% for (Student student : students) { %>
        <tr>
            <td><%=student.getId()%></td>
            <td><%=student.getName()%></td>
            <td><%=student.getAge()%></td>
            <td><%=student.getPhone()%></td>
        </tr>
    <% } %>
    </table>
</body>
</html>
