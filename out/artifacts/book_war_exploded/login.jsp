<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@include file="pages/commons/header.jsp"%>
    <style>
        body,html{
            width:100%;
            height: 100%;
        }
    </style>
</head>
<body>

<div style="width: 400px;height: 200px;left: 50%;top:50%;position: relative;transform: translate(-50%,-50%);border: 1px solid gray;">
    <form id="login" class="layui-form" action="userServlet" method="post" style="margin-top: 10px;margin-left: 0px">
        <span  style="color: red;margin-left:120px;">
<%--            <%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>--%>
            ${ empty requestScope.msg?"请输入用户名和密码":requestScope.msg }
        </span>
        <input type="hidden" name="action" value="login">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input" value="${requestScope.username}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="login">登录</button>
                <button class="layui-btn layui-btn-primary" id="signup_btn">注册</button>
            </div>
        </div>
    </form>

</div>
<script>
    let showSignup = document.getElementById("signup_btn");

    showSignup.onclick=function () {
        window.location.href="regist.jsp"
    }

</script>

<script src="static/layui/layui.js"></script>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(login)', function(data){
            layer.msg(JSON.stringify(data.field));
            return true;
        });
    });
</script>
</body>
</html>