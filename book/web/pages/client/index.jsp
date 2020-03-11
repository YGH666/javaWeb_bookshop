<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/6
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/header.jsp"%>
<html>
<head>
    <title>Title</title>
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
        header a{
            float: right;
            margin-right: 20px ;
        }
        header span{
            float: right;
            margin-right: 20px ;
        }
        .showInfo{
            width: 30%;
            height: 75%;
            border: 1px solid black;
            float: left;
            margin: 100px 15px;
        }
        main{
            width: 80%;
            height: 80%;
            position: relative;
            margin: auto;
            text-align: center;
            border: 1px solid black;
        }

        #page_nav{
            width: 80%;
            height: 10%;
            text-align: center;
            position: absolute;
            left: 50%;
            transform: translate(-50%,0);
            bottom: 5px;
        }

        footer{
            width: 80%;
            height: 10%;
            position: relative;
            margin: auto;
            text-align: center;
            border: 1px solid black;
        }

        main #search input{
            width: 50px;
            text-align: center;
        }

        #search{
            text-align: center;
            position: absolute;
            left: 50%;
            transform: translate(-50%,0);
        }

        #showCart{
            text-align: center;
            position: absolute;
            left: 50%;
            top: 5%;
            transform: translate(-50%,0);
        }
    </style>
    <script>
        $(function () {
            $(".addToCart").click(function () {
                if (${empty sessionScope.user.username}){
                    alert("请先登录!")
                }else {
                    let bookid = $(this).attr("bookId");
                    // location.href = "cartServlet?action=addItem&id="+bookid;
                    $.getJSON("cartServlet","action=ajaxAddItem&id="+bookid,function (data) {
                        $("#totalCount").text("您的购物车中有"+data.totalCount+"件商品");
                        $("#lastName").text("您刚刚将《"+data.lastName+"》加入到了购物车");
                    })
                }
            });

            $("#logout").click(function () {
                return confirm("你确定注销当前账号吗？")
            });
        })
    </script>
</head>
<body>
<header>
    <h1>欢迎来到首页</h1>
    <C:if test="${empty sessionScope.user.username}">
        <a href="login.jsp">登录</a>
    </C:if>
    <C:if test="${not empty sessionScope.user.username}">
        <span style="color: red">${sessionScope.user.username}</span>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a id="logout" href="userServlet?action=logout">注销</a>
        <C:if test="${sessionScope.isRoot == 'yes'}">
            <a href="pages/manager/manager_menu.jsp">管理</a>
        </C:if>
    </C:if>

</header>
<main>
    <div id="search">
        <form method="get" action="client/bookServlet">
            <input type="hidden" name="action" value="pageByPrice">
            价格:<input type="text" name="min" value="${param.min}">元-
            <input type="text" name="max" value="${param.max}">元
            <input type="submit" value="查询">
        </form>
    </div>
    <div id="showCart">
        <C:if test="${empty sessionScope.cart.items}">
            <span  id="totalCount"></span><br>
            <span  id="lastName" style="color: red">当前购物车为空</span>
        </C:if>

<%--        <C:if test="${not empty sessionScope.cart.items}">--%>
<%--            您的购物车中有<span id="totalCount"></span>件商品<br>--%>
<%--            您刚刚将《<span id="lastName" style="color: red"></span>》加入到了购物车--%>
<%--        </C:if>--%>
    </div>
    <C:forEach var="book" items="${requestScope.page.items}">
        <div class="showInfo">
            <img src="${book.imgPath}" width="100%" height="75%">
            <div>书名：${book.name}</div>
            <div>作者：${book.author}</div>
            <div>价格：${book.price}</div>
            <div>销量：${book.sales}</div>
            <div>库存: ${book.stock}</div>
            <input bookId="${book.id}" class="addToCart" type="button" value="加入购物车">
        </div>
    </C:forEach>
    <%@include file="../commons/page_nav.jsp"%>
</main>
</body>
</html>
