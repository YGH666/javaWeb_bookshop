<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/2
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--   <%!%>   声明脚本   --%>
    <%!
        private Integer id;
        private String name;
        private static Map<String,Object> map;

        static {
            map = new HashMap<>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key3","value3");
        }

        public int c(){
            return 2;
        }

        public static class A{
            private Integer id;
            private String abc;
        }
    %>

<%--   <%=%>   表达式脚本--%>
<%=12%><br>
<%=12.12%><br>
<%="我是杨国豪"%><br>
<%=map%><br>
<%=request.getParameter("username")%>

<%--    <%%>    代码脚本
        翻译到_jspService()方法中，所以在该方法中的对象都能使用
--%>
<%
    int i = 12;
    if (i == 12){
%>
    <h1>杨国豪牛逼！</h1>
<%
    }else {
%>
    <h1>asdasdasda</h1>
<%  }
%>

<table border="1px" cellpadding="0">
    <tr>
        <%
            for (int j = 0; j < 12; j++) {
        %>
        <td>第<%=j%>列</td>
        <%
            }
        %>
    </tr>
</table>



<%
    String username = request.getParameter("username");
    System.out.println("username = " + username);
%>
</body>
</html>
