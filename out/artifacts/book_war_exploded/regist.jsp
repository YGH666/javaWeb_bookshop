<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@include file="pages/commons/header.jsp"%>
    <script>
        $(function () {
            $("#code_img").click(function () {
                this.src = "${basePath}kaptcha.jpg?d="+new Date();
            });

            $("#username").blur(function () {
                let username = this.value;
                $.getJSON("userServlet","action=ajaxExistUsername&username="+username,function (data) {
                    console.log(data);
                    if (data.existUsername){
                        $("#errmsg").text("当前用户名已存在！");
                    }else {
                        $("#errmsg").text("当前用户名可用！");
                    }
                })
            });
        })
    </script>
</head>
<body>
<div style="width: 400px;height: 500px;border: 1px solid gray;left: 50%;top: 50%;position: absolute;transform: translate(-50%,-50%)">
    <form id="signup" class="layui-form" action="userServlet" method="post" style="position: relative;left: 50%;top: 50%;transform: translate(-50%,-50%)">
        <span  id="errmsg" style="color: red;position: relative;margin-left: 120px">
<%--            <%=request.getAttribute("msg")==null?"请输入注册相关信息":request.getAttribute("msg")%>--%>
            ${empty requestScope.msg?"请输入注册相关信息":requestScope.msg}
        </span>
        <input type="hidden" name="action" value="regist">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input id="username" type="text" lay-verify="username" name="username" required   placeholder="请输入账户" autocomplete="off" class="layui-input" value="${requestScope.username}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" lay-verify="pass" name="password" required  placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-inline">
                <input type="password" name="repassword" required lay-verify="required" placeholder="请再次输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="email" name="email" required lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input" value="${requestScope.email}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">验证码</label>
            <div class="layui-input-inline">
                <input type="text" name="code" required lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input"><br>
                <img id="code_img" src="kaptcha.jpg" width="100" height="28">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="signup">注册</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<%--<script src="static/layui/layui.js"></script>--%>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;
        form.verify({
            username: function(value, item){ //value：表单的值、item：表单的DOM对象
                if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                    return '用户名不能有特殊字符';
                }
                if(/(^\_)|(\__)|(\_+$)/.test(value)){
                    return '用户名首尾不能出现下划线\'_\'';
                }
                if(/^\d+\d+\d$/.test(value)){
                    return '用户名不能全为数字';
                }
            }

            //我们既支持上述函数式的方式，也支持下述数组的形式
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
        });
        //监听提交
        form.on('submit(signup)', function(data){
            if (data.field.password!=data.field.repassword){
                layer.msg("前后密码输入不一致！");
                document.getElementById("signup").reset();
                return false;
            }else {
                return true;
            }
        });

    });
</script>
</body>
</html>