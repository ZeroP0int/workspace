<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>账户余额</title>

		<link href="../css/admin.css" rel="stylesheet" type="text/css">
		<link href="../css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="../css/personal.css" rel="stylesheet" type="text/css">

		<script src="../js/jquery.min.js"  type="text/javascript"></script>
		<script src="../js/amazeui.js"  type="text/javascript"></script>	
		
	</head>

	<body>
		<iframe src="../header.jsp" width="100%" height="150px" frameborder="0"></iframe>

		<div class="nav-table">
			<div class="long-title"><span class="all-goods">全部分类</span></div>
			<div class="nav-cont">
				
				
			</div>
		</div>
		<b class="line"></b>

		<div class="center">
			<div class="col-main">
				<div class="main-wrap">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">账户余额</strong> / <small>Account&nbsp;Balance</small></div>
						</div>
						<hr/>	
						<div class="finance">
							<div class="financeText">
								<p>可用余额:<span>¥0.0</span></p>
								<a href="safety.jsp">安全中心：保护账户资产安全</a>
							</div>
							<div class="financeTip">
								<img src="../images/Balance.png" />
								<a href="walletlist.jsp">查看账户明细</a>
								<p>提示：余额是您在本商城的一个账户，如账户内有款项，下单时可以直接勾选使用，抵消部分总额，方便快捷安全高效。</p>
							</div>
						</div>
				</div>
				<!--底部-->
				<iframe src="../footer.jsp" width="100%" height="150px" frameborder="0" scrolling="no"></iframe>
			</div>

			<aside class="menu">
				<ul>
					<li class="person active">
						<a href="index.jsp"><i class="am-icon-user"></i>个人中心</a>
					</li>
					<li class="person">
						<p><i class="am-icon-newspaper-o"></i>个人资料</p>
						<ul>
							<li> <a href="information.jsp">个人信息</a></li>
							<li> <a href="safety.jsp">安全设置</a></li>
							<li> <a href="address.jsp">地址管理</a></li>
						</ul>
					</li>
					<li class="person">
						<p><i class="am-icon-balance-scale"></i>我的交易</p>
						<ul>
							<li><a href="order.jsp">订单管理</a></li>
							<li> <a href="change.jsp">退款售后</a></li>
							<li> <a href="comment.jsp">评价商品</a></li>
						</ul>
					</li>
					<li class="person">
						<p><i class="am-icon-dollar"></i>我的资产</p>
						<ul>
							<li> <a href="points.jsp">我的积分</a></li>
							<li> <a href="walletlist.jsp">账户余额</a></li>
							<li> <a href="bill.jsp">账单明细</a></li>
						</ul>
					</li>

					
						</ul>
					</li>
				</ul>

			</aside>
		</div>

	</body>

</html>