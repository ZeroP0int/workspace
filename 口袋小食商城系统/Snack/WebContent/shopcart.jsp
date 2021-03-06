 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>购物车</title>

		<link href="css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="css/demo.css" rel="stylesheet" type="text/css" />
		<link href="css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="css/optstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="js/jquery.js"></script>

	</head>

	<body>

					<iframe src="header.jsp" width="100%" height="120px" frameborder="0" scrolling="no" onclick="javascript:checkT_F()"></iframe>

			<!--购物车 -->
			<div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div id="J_SelectAll1" class="select-all J_SelectAll">

								</div>
							</div>
							<div class="th th-item">
								<div class="td-inner">商品信息</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">单价</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">数量</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">金额</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>

					<tr class="item-list">
						<div class="bundle  bundle-last ">
							<div class="bundle-hd">
								<div class="bd-promos">
									<span class="list-change theme-login">编辑</span>
								</div>
							</div>
							<div class="clear"></div>
							<div class="bundle-main">
								
						  <c:forEach items="${requestScope.cartVolist}" var="cv" varStatus="status">		
	                      <ul class="item-content clearfix">
									<li class="td td-chk">
										<div class="cart-checkbox ">
											<input onclick="getTotalMoney(${status.index })" class="check" id="check${status.index }" name="items" 
											value="${cv.quantity*cv.promotional_price}" type="checkbox">
											<input type="hidden" value="${cv.cart_id }">
										</div>
									</li>
									<li class="td td-item">
										<div class="item-pic">
											<a href="#" target="_blank" class="J_MakePoint" data-point="tbcart.8.12">
												<img src="/img/${cv.img }" width="80" height="80"  class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
											<div class="item-basic-info">
												<a href="#" target="_blank" class="item-title J_MakePoint" data-point="tbcart.8.11">${cv.cname }</a>
											</div>
										
											<div class="item-props">
												<span class="sku-line">口味：${cv.fname }</span>
											</div>
											
										</div>
									</li>
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="price-original">78.00</em>
												</div>
												<div class="price-line">
													<em class="J_Price price-now" tabindex="0">${cv.promotional_price}</em>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl">
													<input class="min am-btn" name="" type="button" value="-" />
													<input class="text_box" name="" type="text" value="${cv.quantity}" style="width:30px;" />
													<input class="add am-btn" name="" type="button" value="+" />
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
											<em tabindex="0" class="J_ItemSum number">${cv.quantity*cv.promotional_price}</em>
										</div>
									</li>
									<li class="td td-op">
										<div class="td-inner">
											<a href="javascript:deletecart()" data-point-url="#" class="delete">
                                                                               删除</a>
										</div>
									</li>
								</ul>	
							</c:forEach>	
								
													
							</div>
						</div>
					</tr>
					<div class="clear"></div>
				</div>
				
				<div class="clear"></div>

				<div class="float-bar-wrapper">
					<div id="J_SelectAll2" class="select-all J_SelectAll">
					
						<div class="cart-checkbox">
						  
							<input id="all" name="allCK" type="checkbox" class="check" onclick="javascript:allCheck()">
						
							<label for="J_SelectAllCbx2"></label>
								
						</div>
					
						<span>全选</span>
					</div>
						
					<div class="operations">
						<a href="DeleteAllCartServlet" hidefocus="true" class="deleteAll">清空购物车</a>
					</div>
					
					<div class="float-bar-right">
						<div class="amount-sum">
							<span class="txt">已选商品</span>
							<em id="J_SelectedItemsCount">0</em><span class="txt">件</span>
							<div class="arrow-box">
								<span class="selected-items-arrow"></span>
								 <span class="arrow"></span>
							</div>
						</div>
						<div class="price-sum">
							<span class="txt">合计:</span>
							<strong class="price">¥<em id="J_Total">0.00</em></strong>
						</div>
						<div class="btn-area">
							<a href="javascript:js()" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
								<span>结&nbsp;算</span></a>
						</div>
					</div>

				</div>

				

			</div>

                       <script type="text/javascript">
								var totalMoney=0;
								function getTotalMoney(index){
									if($("#check"+index).attr("checked")=="checked"){
									totalMoney=parseFloat(totalMoney)+parseFloat($("#check"+index).val());
									}else{
									totalMoney=parseFloat(totalMoney)-parseFloat($("#check"+index).val());
									}
								
									$("#J_Total").html(totalMoney);
									$("#J_SelectedItemsCount").html($("[name='items']:checked").length);
								}
								function js(){
								var totalMoney=$("#J_Total").html();
								var cartId="";
								$.each($("[name='items']:checked"),function(){
								cartId=cartId+$(this).next().val()+",";
								})
								if(totalMoney!=0){
									location.href="PayServlet?totalMoney="+totalMoney+"&cartId="+cartId;
								}
								else{
									alert("请选择商品后结算......");
								}
								}
								function deletecart(){
									var cartId="";
									$.each($("[name='items']:checked"),function(){
									cartId=cartId+$(this).next().val()+"";
									})
									
									location.href="DeleteCartServlet?cartId="+cartId;
								}
								
								function allCheck(){
								    var obj=document.getElementsByTagName("input");
								   
								    if(document.getElementById("all").checked==true){
								        for(var i=0;i<obj.length;i++){
								            obj[i].checked=true;
								        }
								    }else{
								        for(var i=0;i<obj.length;i++){
								            obj[i].checked=false;
								        }
								    }
								   
										$("#J_SelectedItemsCount").html($("[name='items']:checked").length);
								}
								function checkT_F(){
								    var obj=document.getElementsByTagName("input");
								    var j=0;
								    for(var i=0;i<obj.length;i++){
								        if(obj[i].id!='all'){    //如果是复选框
								            if(obj[i].checked==true){    //并且为选中
								                j++;
								            }
								        }
								    }
								    if(j==(obj.length-1)){    //如果复选框选中的数量等于（复选框总和减去全选这个选框的数量）
								        document.getElementById("all").checked=true; //全选被激活
								    }else{
								        document.getElementById("all").checked=false;    //取消全选
								    }
								}
								</script>
			<!--操作页面-->

			<div class="theme-popover-mask"></div>

			<div class="theme-popover">
				<div class="theme-span"></div>
				<div class="theme-poptit h-title">
					<a href="javascript:;" title="关闭" class="close">×</a>
				</div>
				<div class="theme-popbod dform">
					<form class="theme-signin" name="loginform" action="" method="post">

						<div class="theme-signin-left">

							<li class="theme-options">
								<div class="cart-title">颜色：</div>
								<ul>
									<li class="sku-line selected">12#川南玛瑙<i></i></li>
									<li class="sku-line">10#蜜橘色+17#樱花粉<i></i></li>
								</ul>
							</li>
							<li class="theme-options">
								<div class="cart-title">包装：</div>
								<ul>
									<li class="sku-line selected">包装：裸装<i></i></li>
									<li class="sku-line">两支手袋装（送彩带）<i></i></li>
								</ul>
							</li>
							<div class="theme-options">
								<div class="cart-title number">数量</div>
								<dd>
									<input class="min am-btn am-btn-default" name="" type="button" value="-" />
									<input class="text_box" name="" type="text" value="1" style="width:30px;" />
									<input class="add am-btn am-btn-default" name="" type="button" value="+" />
									<span  class="tb-hidden">库存<span class="stock">1000</span>件</span>
								</dd>

							</div>
							<div class="clear"></div>
							<div class="btn-op">
								<div class="btn am-btn am-btn-warning">确认</div>
								<div class="btn close am-btn am-btn-warning">取消</div>
							</div>

						</div>
						<div class="theme-signin-right">
							<div class="img-info">
								<img src="images/kouhong.jpg_80x80.jpg" />
							</div>
							<div class="text-info">
								<span class="J_Price price-now">¥39.00</span>
								<span id="Stock" class="tb-hidden">库存<span class="stock">1000</span>件</span>
							</div>
						</div>

					</form>
				</div>
			</div>
		
        
        			<iframe src="footer.jsp" width="100%" height="150px" frameborder="0" scrolling="no"></iframe>
	</body>

</html>