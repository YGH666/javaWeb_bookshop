<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/5
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../commons/header.jsp"%>
<script type="text/javascript">
    $(function () {
        $("a.deleteClass").click(function () {
            return confirm("确定删除["+$(this).parent().parent().parent().find("td:first").text()+"]?")
        });

        $("#searchBtn").click(function () {
            var pageNo = $("#pg_input").val();
            if (pageNo > ${requestScope.page.pageTotal}){
                pageNo = ${requestScope.page.pageTotal};
            }else if (pageNo < 1) {
                pageNo = 1;
            }
            location.href = "<%=basePath%>${requestScope.page.url}&pageNo="+pageNo;
        })
    })
</script>
</head>
<style>
    *{
        margin: 0;
        border: 0;
        padding: 0;
        font-family: "Arial Rounded MT Bold";
    }

    html,body{
        width: 100%;
        height: 100%;
    }

    .header{
        padding-top: 30px;
        overflow: hidden;
        /*border: 1px solid black;*/
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
        /*color: #0000FF;*/
        text-decoration: none;
        cursor: pointer;
    }

    .main{
        width: 80%;
        height: 80%;
        position: relative;
        margin: auto;
        /*border: 1px solid black;*/
        /*overflow: scroll;*/
    }

    .layui-table th,td {
        text-align: center;
    }
    #page_nav{
        width: 80%;
        height: 10%;
        text-align: center;
        margin: auto;
        position: relative;
    }
</style>
<body>
<div class="header">
    <h1>图书管理系统</h1>
    <span><a href="#">图书管理</a></span>
    <span><a href="#">订单管理</a></span>
    <span><a href="#">返回商城</a></span>
</div>
<div class="main">
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
            <th>价格</th>
            <th>作者</th>
            <th>销量</th>
            <th>库存</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <C:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td>
                    <div class="layui-btn-container">
                        <a href="manager/bookServlet?action=getBook&id=${book.id}" class="layui-btn">修改</a>
                        <a href="manager/bookServlet?action=delete&id=${book.id}" class="layui-btn deleteClass">删除</a>
                    </div>
                </td>
            </tr>
        </C:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                    <a href="pages/manager/book_edit.jsp" class="layui-btn">添加图书</a>
            </td>
        </tr>
        </tfoot>
    </table>
    <%@include file="../commons/page_nav.jsp"%>
</div>
</body>
</html>
