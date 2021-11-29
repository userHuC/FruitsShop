<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>水果商城</title>
<link href="${pageContext.request.contextPath}/resources/css/main1.css" rel="stylesheet" />
	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
	<div id="abc" class="sg1">
		<div class="a">
			<div class="a1" v-if="isTrue"><a class="a3" href="${pageContext.request.contextPath}/userCenter/message">个人中心</a>|<a class="a3" href="${pageContext.request.contextPath}/exitRegister">退出登入</a></div>
			<div class="a1" v-else><a class="a3" href="${pageContext.request.contextPath}/toRegister">注册</a>|<a class="a3" href="${pageContext.request.contextPath}/toLogin">登入</a></div>
			<div class="a2"><a class="a3" href="${pageContext.request.contextPath}/userCenter/order">我的订单</a>|<a class="a3" href="">我的收藏</a></div>
		</div>
	</div>
	<div class="sg2">
		<div class="b">
			<div class="b1"><img src="${pageContext.request.contextPath}/resources/images/shuiguo.jpg" ></div>
			<div class="b3"><a class="b4" href="${pageContext.request.contextPath}/goShopping">我的购物车</a></div>
			<div class="b2">
				<form action="${pageContext.request.contextPath}/vagueSelect" method="post">
					<div class="b5">
						<input style="width: 194px;height: 46px;" type="text" name="keyword" placeholder="请输入内容">
					</div>
					<div class="b6">
						<input style="width: 46px; height: 48px;" type="submit" value="查询">
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="sg3">
		<div class="c">
			<ul>
				<li class="c1"><a class="c2" href="${pageContext.request.contextPath}/homepage">首页</a></li>
				<li class="c1"><a class="c2" href="${pageContext.request.contextPath}/fruitsClass/瓜果类">瓜果类</a></li>
				<li class="c1"><a class="c2" href="${pageContext.request.contextPath}/fruitsClass/桃类">桃类</a></li>
				<li class="c1"><a class="c2" href="${pageContext.request.contextPath}/fruitsClass/橘类">橘类</a></li>
				<li class="c1"><a class="c2" href="${pageContext.request.contextPath}/fruitsClass/葡萄类">葡萄类</a></li>
			</ul>
		</div>
	</div>
	<div class="sh">
		<div class="sh1">
			<div class="sh2"><img src="${pageContext.request.contextPath}/resources/images/${fruits.site}"></div>
			<div class="sh3">
			<form action="${pageContext.request.contextPath}/toShopping" method="post">
				<p class="sh4">${fruits.explain}</p><br />
				<p>由果粒生鲜拼购店从 浙江金华市 发货, 并提供售后服务.</p><br />
				<input class="sh7" type="text" name="fruitsName" value="${fruits.fruitsName}" readonly="readonly"/>
				<p class="sh4" style="color: #ff0000;">价格：¥ ${fruits.price}</p><br />
				<input type="hidden" name="price" value="${fruits.price}"/>
				配送至：<select name="site">
							<option >长沙民政职业技术学院</option>
							<option >湖南省衡阳市泉溪镇</option>
						</select> 有货支持 优鲜赔 在线支付免运费<br /><br />
				选择种类：<input class="sh5" type="radio" name="lei" value="普通水果" checked/>普通水果<input class="sh5" type="radio" name="lei" value="超市精品水果" />超市精品水果
				<br /><br />
				<input class="sh6" type="submit" value="加入购物车" />
			</form>
			</div>
		</div>
	</div>
</body>
<script>
	var Vue = new Vue({
		el:'#abc',
		data:{
			isTrue:"${username}"
		}
	})
</script>
</html>