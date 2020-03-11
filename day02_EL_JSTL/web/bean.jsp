<%@ page import="yangguohao.pojo.Person" %>
<%@ page import="com.sun.org.apache.xpath.internal.operations.String" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/2
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();
    person.setId(12);
    person.setPhones(new java.lang.String[]{"123123123","1222222","44444444"});
    ArrayList<java.lang.String> cities = new ArrayList<>();
    cities.add("上海");
    cities.add("北京");
    cities.add("四川");
    cities.add("重庆");
    cities.add("广西");
    person.setCities(cities);
    HashMap<java.lang.String, Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    map.put("key4","value4");
    Set<java.lang.String> keys = map.keySet();
    for (java.lang.String key : keys) {
        System.out.println(map.get(key));
    }

    person.setMap(map);

    pageContext.setAttribute("person",person);
%>

输出person:<br>
class.field  并不是找class里的field属性值，而是调用getField()方法:  ${person.test}<br>
${ person.id }<br>
${ person.phones[0] }<br>
${ person.cities }<br>
${ person.map.key1 }<br>
<br>
<h1>EL的11个隐含对象</h1><br>
<img src="image/EL.png" width="769" height="380">
</body>
</html>
