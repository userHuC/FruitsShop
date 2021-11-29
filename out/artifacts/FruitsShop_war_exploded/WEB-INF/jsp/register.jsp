<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/11/11
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" />
</head>

<body>
<div class="reg">
    <div class="gin_a1">
        <img src="${pageContext.request.contextPath}/resources/images/shuiguo.jpg" />
    </div>
    <div class="rega">
        <div class="gin_a2a">
            <p style="font-size: 24px;font-weight: bold;text-align: center;padding-top: 19px;">会员注册</p>
        </div>
        <div class="regb">
            <form action="register" method="post">
                <div class="namepaw">
                    <label class="na">账号：</label><input class="inp" type="text" name="username" />
                </div>
                <div class="namepaw">
                    <label class="na">密码：</label><input class="inp" type="password" name="password" />
                </div>
                <div class="namepaw">
                    <label class="na">电话：</label><input class="inp" type="text" name="phone" />
                </div>
                <div class="namepaw">
                    <label class="na">邮箱：</label><input class="inp" type="text" name="email" />
                </div>
                <div class="sub">
                    <input class="btu" type="submit" name="立即注册" value="立即注册" />
                </div>
            </form>

        </div>
        <div class="log">
            <label class="loga">已有账号？<a class="logb" href="toLogin">立即登入！</a></label>
        </div>
    </div>
</div>
</body>
</html>
