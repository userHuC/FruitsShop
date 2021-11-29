<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人中心</title>
    <link href="${pageContext.request.contextPath}/resources/css/main1.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
<div id="abc">
    <div class="sg1">
        <div class="a">
            <div class="a1" v-if="isTrue"><a class="a3" href="${pageContext.request.contextPath}/userCenter/message">个人中心</a>|<a class="a3" href="${pageContext.request.contextPath}/exitRegister">退出登入</a></div>
            <div class="a1" v-else><a class="a3" href="${pageContext.request.contextPath}/toRegister">注册</a>|<a class="a3" href="${pageContext.request.contextPath}/toLogin">登入</a></div>

            <div class="a2"><a class="a3" href="${pageContext.request.contextPath}/userCenter/order">我的订单</a>|<a class="a3" href="">我的收藏</a></div>
        </div>
    </div>
    <div class="sg2">
        <div class="b">
            <div class="b1"><img src="${pageContext.request.contextPath}/resources/images/shuiguo.jpg" /></div>
            <div class="b3"><a class="b4" href="${pageContext.request.contextPath}/goShopping">我的购物车</a></div>
            <div class="b2">
                <div class="b5">
                    <input style="width: 194px;height: 46px;" type="text" name="" placeholder="请输入内容"/>
                </div>
                <div class="b6">
                    <img src="${pageContext.request.contextPath}/resources/images/search.png"/>
                </div>
            </div>
        </div>
    </div>
    <div class="sg3">
        <div class="c">
            <ul>
                <li class="c1"><a class="c2" href="${pageContext.request.contextPath}/userCenter/message">个人信息</a></li>
                <li class="c1"><a class="c2" href="${pageContext.request.contextPath}/userCenter/update">修改信息</a></li>
                <li class="c1"><a class="c2" href="${pageContext.request.contextPath}/userCenter/paw">修改密码</a></li>
                <li class="c1"><a class="c2" href="${pageContext.request.contextPath}/userCenter/order">订单中心</a></li>
            </ul>
        </div>
    </div>
    <div class="sg4">
        <div class="mes" v-if="type=='update'">
            <form action="${pageContext.request.contextPath}/updateUser" method="post">
                <p class="mes_b">用户名：<input class="inpt" style="border: none" type="text" name="username" value="${user.username}" disabled /></p>
                <p class="mes_b">电 &nbsp;&nbsp;话：<input class="inpt" type="text" name="phone" value="${user.phone}" /></p>
                <p class="mes_b">邮 &nbsp;&nbsp;箱：<input class="inpt" type="text" name="email" value="${user.email}" /></p>
                <p class="mes_b" style="padding-left: 40px;"><input class="inp" type="submit" value="修改" /></p>
            </form>
        </div>
        <div class="mes" v-else-if="type=='paw'" >
            <form action="${pageContext.request.contextPath}/updatePaw" method="post">
                <p class="mes_b"> 旧 密 码 ：<input type="password" name="paw"/></p>
                <p class="mes_b"> 新 密 码 ：<input type="password" name="password"></p>
                <p class="mes_b"><input class="inp" type="submit" value="修改" /></p>
            </form>
        </div>
        <div class="mes" v-else-if="type=='order'" >
            <table>
                <tr>
                    <td class="tdb">名称</td>
                    <td class="tdb">价格</td>
                    <td class="tdb">品质</td>
                    <td class="tdb1">地址</td>
                    <td class="tdb">状态</td>
                </tr>
                <c:forEach items="${orderFromList}" var="orderFrom">
                    <tr>
                        <td class="tdb">${orderFrom.fruitsName}</td>
                        <td class="tdb">${orderFrom.price}</td>
                        <td class="tdb">${orderFrom.lei}</td>
                        <td class="tdb1">${orderFrom.site}</td>
                        <td class="tdb">${orderFrom.state}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="mes" v-else >
            <p class="mes_a">用户名：${user.username}</p>
            <p class="mes_a">电话：${user.phone}</p>
            <p class="mes_a">密码：${user.email}</p>
        </div>
    </div>
</div>
</body>
<script>
    var Vue = new Vue({
        el:'#abc',
        data:{
            isTrue:"${user.username}",
            type: "${label}"
        }
    })
</script>
</html>