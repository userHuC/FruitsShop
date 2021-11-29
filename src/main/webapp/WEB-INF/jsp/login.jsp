<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/11/10
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登入</title>
    <link type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" />
</head>
<body>
<div class="gin_a">
    <div class="gin_a1">
        <img src="${pageContext.request.contextPath}/resources/images/shuiguo.jpg" />
    </div>
    <div class="gin_a2">
        <div class="gin_a2a">
            <p style="font-size: 24px;font-weight: bold;text-align: center;padding-top: 19px;">会员登入</p>
        </div>
        <div class="gin_a2b">
            <form action="login" method="post">
                <div class="namepaw">
                    <label class="na">账号：</label><input class="inp" type="text" name="username" />
                </div>
                <div class="namepaw">
                    <label class="na">密码：</label><input class="inp" type="password" name="password" />
                </div>
                <div class="sub">
                    <input class="btu" type="submit" name="登入" value="登入" />
                </div>
            </form>

        </div>
        <div class="log">
            <label class="loga">没有账号？<a class="logb" href="toRegister">立即注册！</a></label>
        </div>
    </div>
</div>
</body>
</html>
