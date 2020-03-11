<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/5
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../commons/header.jsp"%>
</head>
<style>
    *{
        margin: 0;
        border: 0;
        padding: 0;
        text-decoration: none;
        font-family: "Arial Rounded MT Bold";
    }

    html,body{
        width: 100%;
        height: 100%;
    }

    .header{
        padding-top: 30px;
        overflow: hidden;
        border: 1px solid black;
        width: 80%;
        height: 10%;
        margin: auto;
        position: relative;
        text-align: center;
    }

    .header span{
        float: right;

        margin-left: 20px;
        margin-right: 20px;
        font-size: 20px;
    }

    a{
        color: #0000FF;
        text-decoration: none;
    }

    .main{
        width: 80%;
        height: 80%;
        position: relative;
        margin: auto;
        border: 1px solid black;
        overflow: scroll;
    }

    .layui-table th,td {
        text-align: center;
    }
</style>
<body>
<div class="header">
    <h1>添加图书页面</h1>
    <span><a href="#">图书管理</a></span>
    <span><a href="#">订单管理</a></span>
    <span><a href="#">返回商城</a></span>
</div>
<div class="main">
    <form action="manager/bookServlet" method="get">
        <input type="hidden" name="action" value="${empty param.id ? "add" : "update"}">
        <input type="hidden" name="id" value="${param.id}">
        <table class="layui-table">
            <colgroup>
                <col width="300">
                <col width="100">
                <col width="150">
                <col width="100">
                <col width="100">
                <col width="200">
            </colgroup>
            <tr>
                <th>名称</th>
                <th>价格</th>
                <th>作者</th>
                <th>销量</th>
                <th>库存</th>
                <th>操作</th>
            </tr>
            <tr>
                <td><input type="text" name="name" placeholder="输入名称" value="${requestScope.book.name}"></td>
                <td><input type="text" name="price" placeholder="输入价格" value="${requestScope.book.price}"></td>
                <td><input type="text" name="author" placeholder="输入作者" value="${requestScope.book.author}"></td>
                <td><input type="text" name="sales" placeholder="输入销量" value="${requestScope.book.sales}"></td>
                <td><input type="text" name="stock" placeholder="输入库存" value="${requestScope.book.stock}"></td>
                <td><input type="submit" class="layui-btn" value="${empty param.id ? "添加" : "修改"}"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
<script src="static/layui/layui.js"></script>
</html>
