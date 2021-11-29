<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理员</title>
    <link href="${pageContext.request.contextPath}/resources/css/main1.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
    <div id="abc" >
        <div class="sg1">
            <div class="a">
                <div class="a1" v-if="isTrue"><a class="a3" href="${pageContext.request.contextPath}/userCenter/message">个人中心</a>|<a class="a3" href="${pageContext.request.contextPath}/exitRegister">退出登入</a></div>
                <div class="a1" v-else><a class="a3" href="${pageContext.request.contextPath}/toRegister">注册</a>|<a class="a3" href="${pageContext.request.contextPath}/toLogin">登入</a></div>

                <div class="a2"><a class="a3" href="${pageContext.request.contextPath}/order">我的订单</a>|<a class="a3" href="">我的收藏</a></div>
            </div>
        </div>
        <div class="sg2">
            <div class="b">
                <div class="b1"><img src="${pageContext.request.contextPath}/resources/images/shuiguo.jpg" /></div>
                <div class="b3"><a class="b4" href="">我的购物车</a></div>
                <div class="b2">
                    <form action="" method="post">
                        <form action="" method="post">
                            <div class="b5">
                                <input style="width: 194px;height: 46px;" type="text" name="keyword" placeholder="请输入内容">
                            </div>
                            <div class="b6">
                                <input style="width: 46px; height: 48px;" type="submit" value="查询">
                            </div>
                        </form>
                    </form>
                </div>
            </div>
        </div>
        <div class="sg3">
            <div class="c">
                <ul>
                    <li class="c1"><a class="c2" href="${pageContext.request.contextPath}/allUser">用户管理</a></li>
                    <li class="c1"><a class="c2" href="${pageContext.request.contextPath}/manageFruits">水果信息</a></li>
                    <li class="c1"><a class="c2" href="${pageContext.request.contextPath}/skipFruits">添加水果</a></li>
                    <li class="c1"><a class="c2" href="${pageContext.request.contextPath}/allOrder">订单中心</a></li>
                </ul>
            </div>
        </div>
        <div v-if="type=='manageFruits'">
            <div class="m"><p class="m1">水果管理</p></div>
            <div class="k">
                <div class="k1">
                    <table border="1" cellspacing="0" style="margin: 0 auto">
                        <tr>
                            <td class="k2">水果名</td>
                            <td class="k2">价格</td>
                            <td class="k2">描述</td>
                            <td class="k2">种类</td>
                            <td class="k2">操作</td>
                        </tr>
                        <c:forEach items="${fruitsList}" var="fruits">
                            <tr>
                                <td class="k2">${fruits.fruitsName}</td>
                                <td class="k2">${fruits.price}</td>
                                <td class="k2">${fruits.explain}</td>
                                <td class="k2">${fruits.fruitsClass}</td>
                                <td class="k2"><a href="${pageContext.request.contextPath}/removeFruits/${fruits.fruitsName}"><input class="k3" type="button" value="删除"></a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <div v-else-if="type=='order'">
            <div class="m"><p class="m1">订单中心</p></div>
            <div class="k">
                <div class="k1">
                    <table border="1" cellspacing="0" style="margin: 0 auto">
                        <tr>
                            <td class="k2">水果名</td>
                            <td class="k2">价格</td>
                            <td class="k2">品质</td>
                            <td class="k2">地址</td>
                            <td class="k2">状态</td>
                            <td class="k2">用户</td>
                        </tr>
                        <c:forEach items="${orderFromList}" var="orderFrom">
                            <tr>
                                <td class="k2">${orderFrom.fruitsName}</td>
                                <td class="k2">${orderFrom.price}</td>
                                <td class="k2">${orderFrom.lei}</td>
                                <td class="k2">${orderFrom.site}</td>
                                <td class="k2">${orderFrom.state}</td>
                                <td class="k2">${orderFrom.username}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <div class="mes" v-else-if="type=='add'">
            <form action="${pageContext.request.contextPath}/addFruits" method="post" enctype="multipart/form-data">
                <p class="mes_b">水果名：<input class="inpt" type="text" name="fruitsName"/></p>
                <p class="mes_b">价 &nbsp;&nbsp;格：<input class="inpt" type="text" name="price"  /></p>
                <p class="mes_b">描 &nbsp;&nbsp;述：<input class="inpt" type="text" name="explain" /></p>
                <p class="mes_b">种 &nbsp;&nbsp;类：<select class="inpt" name="fruitsClass">
                                                        <option >葡萄类</option>
                                                        <option >瓜果类</option>
                                                        <option >橘类</option>
                                                        <option >桃类</option>
                                                    </select></p>
                <p class="mes_b">图 &nbsp;&nbsp;片：<input class="inpt" type="file" name="photo" /></p>
                <p class="mes_b" style="padding-left: 40px;"><input class="inp" type="submit" value="添加水果" /></p>
            </form>
        </div>
        <div v-else>
            <div class="m"><p class="m1">用户管理</p></div>
            <div class="k">
                <div class="k1">
                    <table border="1" cellspacing="0" style="margin: 0 auto">
                        <tr>
                            <td class="k2">用户名</td>
                            <td class="k2">电话</td>
                            <td class="k2">邮箱</td>
                            <td class="k2">操作</td>
                        </tr>
                        <c:forEach items="${userList}" var="user">
                            <tr>
                                <td class="k2">${user.username}</td>
                                <td class="k2">${user.phone}</td>
                                <td class="k2">${user.email}</td>
                                <td class="k2"><a href="${pageContext.request.contextPath}/deleteUser/${user.username}"><input class="k3" type="button" value="删除"></a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
    var Vue = new Vue({
        el:'#abc',
        data:{
            isTrue:"${username}",
            type:"${label}"
        }
    })
</script>
</html>