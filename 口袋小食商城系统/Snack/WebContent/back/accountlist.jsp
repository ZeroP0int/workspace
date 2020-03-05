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
			<div class="AccountManagement_c " id="AccountManagement_c">
                <h3>账户管理 
                </h3>

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><input type="checkbox" name=""><span>用户名</span></label></li>
                        <li class="b20"><label>密码</label></li>
                        <li class="b20"><label>角色</label></li>
                        <li class="b60"><label>操作</label></li>
                    </ul>
                    <div class="list_b_c">
                        
                      <c:forEach items="${requestScope.pageUtil.list}" var="user" varStatus="status"> 
                        <ul class="list_b">
                            <li class="b20"><label><input type="checkbox" name=""><span>${user.username}</span></label></li>
                            <li class="b20"><label>${user.password}</label></li>
                            <li class="b20"><label>123</label></li>
                            <li class="b60"> 
                            		<a href="accountedit.jsp" ><div class="edit_btn df_btn fl text_center">编辑</div></a>
                        			
                            </li>
                        </ul>
                       </c:forEach>
                       
                        
                   

                   
                    
              
            </div>
          <div class="pull_page">
                        <div class="fl pull_page_up"><a href="${pageContext.request.contextPath}/FindAccountByPageServlet?currentPage=1">首页</a></div>
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/FindAccountByPageServlet?currentPage=${requestScope.pageUtil.currentPage==1?1:requestScope.pageUtil.currentPage-1}">上一页</a></li>
                                <li><a href="${pageContext.request.contextPath}/FindAccountByPageServlet?currentPage=${requestScope.pageUtil.currentPage==requestScope.pageUtil.totalPage?requestScope.pageUtil.totalPage:requestScope.pageUtil.currentPage+1}">下一页</a></li>
                            </ul>
                        <div class="fl pull_page_down"><a href="${pageContext.request.contextPath}/FindAccountByPageServlet?currentPage=${requestScope.pageUtil.totalPage}">尾页</a></div>
       
                       	<div style="float: left;line-height: 65px;margin-left:30px">当前第${requestScope.pageUtil.currentPage}页/共${requestScope.pageUtil.totalPage}页</div>
                    </div>

                </div>
            </div>


   
    
</body>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
</html>