<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/8
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../commons/header.jsp"%>
    <script>
        $(function () {
            $(".deleteItem").click(function () {
               return  confirm("确定删除["+$(this).parent().parent().find("td:first").text()+"]吗？")
            });

            $("#clearCart").click(function () {
                return confirm("确定清空购物车吗？")
            });

            $("#logout").click(function () {
                return confirm("你确定注销当前账号吗？")
            });

            $(".updateCount").change(function () {
                var name = $(this).parent().parent().find("td:first").text();
                var count = this.value;
                var id = $(this).attr("bookId");
                if (count == ""){
                    alert("请输入正确的数量！");
                    this.value = this.defaultValue;
                }else {
                    if (confirm("你确定要将["+name+"]修改数量为:"+count+"吗？")) {
                        location.href = "cartServlet?action=updateCount&count="+count+"&id="+id;
                    }else {
                        this.value = this.defaultValue;
                    }
                }

            });
        })
    </script>
<style>
    a{
        text-decoration: none;
    }

    html,body{
        width: 100%;
        height: 100%;
        margin: 0;
        border: 0;
        padding: 0;
        font-family: "Arial Rounded MT Bold";
    }

    header{
        width: 80%;
        height: 10%;
        position: relative;
        margin: auto;
        /*text-align: center;*/
        border: 1px solid black;
        line-height: 100px;
    }
    header h1{
        font-size: 30px;
        position: absolute;
        left: 50%;
        transform: translate(-50%,0);
    }
    #header a{
        float: right;
        margin-right: 20px ;
    }
    #header span{
        float: right;
        margin-right: 20px ;
    }

    main{
        width: 80%;
        height: 80%;
        position: relative;
        margin: auto;
        text-align: center;
    }

    footer{
        width: 80%;
        height: 10%;
        position: relative;
        margin: auto;
        text-align: center;
        font-size: 18px;
    }

    footer span{
        color: red;
        font-size: 20px;
    }
    footer a{
        color: blue;
    }

    .layui-table th,td {
        text-align: center;
    }
</style>
</head>
<body>
<header id="header">
    <h1>欢迎来到购物车</h1>
    <C:if test="${empty sessionScope.user.username}">
        <a href="login.jsp">登录</a>
    </C:if>
    <C:if test="${not empty sessionScope.user.username}">
        <span style="color: red">${sessionScope.user.username}</span>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a id="logout" href="userServlet?action=logout">注销</a>
        <a href="index.jsp">首页</a>
        <C:if test="${sessionScope.isRoot == 'yes'}">
            <a href="pages/manager/manager_menu.jsp">管理</a>
        </C:if>
    </C:if>
</header>
<main>
    <table class="layui-table">
        <colgroup>
            <col width="300">
            <col width="100">
            <col width="150">
            <col width="100">
            <col width="100">
            <col width="200">
        </colgroup>
        <thead>
        <tr>
            <th>名称</th>
            <th>数量</th>
            <th>单价</th>
            <th>金额</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <C:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5">亲，当前购物车为空，快去<a href="index.jsp" style="color: red">首页商城</a>逛逛吧！</td>
            </tr>
        </C:if>
        <C:if test="${not empty sessionScope.cart.items}">
            <C:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td><input bookId="${entry.value.id}" class="updateCount" style="width: 40px;text-align: center" type="text" value="${entry.value.count}"></td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
            </C:forEach>
        </C:if>
        </tbody>
    </table>
</main>
<footer>
    <C:if test="${not empty sessionScope.cart.items}">
        购物车中共有<span>${sessionScope.cart.totalCount}</span>件商品
        总金额<span>${sessionScope.cart.totalPrice}</span>元
        <a id="clearCart" href="cartServlet?action=clear">清空购物车</a>
        <a href="orderServlet?action=createOrder">去结账</a>
    </C:if>
</footer>
</body>
</html>
