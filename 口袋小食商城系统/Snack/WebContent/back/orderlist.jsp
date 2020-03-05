<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/back/css/main.css" rel="stylesheet">
</head>
<body>
    <!-- 订单管理 -->
            <div class="AccountManagement_c" id="ColumnManagement_c">
                <h3>订单管理 
                  
                </h3>
               

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><input type="checkbox" name="newsId"><span>序号</span></label></li>
                        <li class="b20"><label>订单编号</label></li>
                         <li class="b20"><label>食品名称</label></li>
                          <li class="b20"><label>数量</label></li>
                           <li class="b20"><label>订单状态</label></li>
                        <li class="b60"><label>操作</label></li>
                    </ul>
                    <div class="list_b_c">
                       
                         <c:forEach items="${requestScope.pageUtil.list}" var="orders" varStatus="status">
                            <ul class="list_b">
                                <li class="b20"><label><input type="checkbox" name=""><span>${status.index+1}</span></label></li>
                                <li class="b20"><label>${orders.oid}</label></li>
                                 <li class="b20"><label>乐事</label></li>
                                  <li class="b20"><label>4</label></li>
                                   <li class="b20"><label>代发货</label></li>
                                <li class="b60">
                            	<a href="orderedit.jsp"><div class="edit_btn df_btn fl text_center">编辑</div></a>
                        		<a href="ItemDeleteItem?newsId=${newsId}"><div class="delete_btn df_btn fl text_center">删除</div></a>
                        		</li>
                            </ul>
                      </c:forEach>
                     
                       
                    </div>

                    <div class="pull_page">
                        <div class="fl pull_page_up"><a href="${pageContext.request.contextPath}/FindOrdersByPageServlet?currentPage=1">首页</a></div>
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/FindOrdersByPageServlet?currentPage=${requestScope.pageUtil.currentPage==1?1:requestScope.pageUtil.currentPage-1}">上一页</a></li>
                                <li><a href="${pageContext.request.contextPath}/FindOrdersByPageServlet?currentPage=${requestScope.pageUtil.currentPage==requestScope.pageUtil.totalPage?requestScope.pageUtil.totalPage:requestScope.pageUtil.currentPage+1}">下一页</a></li>
                            </ul>
                        <div class="fl pull_page_down"><a href="${pageContext.request.contextPath}/FindOrdersByPageServlet?currentPage=${requestScope.pageUtil.totalPage}">尾页</a></div>
       
                       	<div style="float: left;line-height: 65px;margin-left:30px">当前第${requestScope.pageUtil.currentPage}页/共${requestScope.pageUtil.totalPage}页</div>
                    </div>

                </div>
            </div>




</body>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
</html>