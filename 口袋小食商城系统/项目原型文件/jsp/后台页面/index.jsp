<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>口袋小食管理平台</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="css/main.css" rel="stylesheet">
</head>
<body>

    <div class="header">
        <div class="header_in">
            <img src="img/ss.ico">
            <font id="wz">口袋小食管理平台</font>
            <div class="quit text_center">安全退出</div>
        </div>
    </div>

    <div class="content ">
        <div class="user">
            <div class="user_status fl text_center">当前用户： <span>管理员001</span></div>
            <div class="user_location fl">当前： 首页-<span>用户管理</span>  </div>
        </div>
        <div class="nav_side text_center fl">
            <div class="nav UserManagement active">用户管理</div>
            <div class="nav KindManagement">类型管理</div>
            <div class="nav BrandManagement">品牌管理</div>
            <div class="nav FoodManagement">食品管理</div>
            <div class="nav OrdersManagement">订单管理</div>
            <div class="nav AccountManagement">账户管理</div>
        </div>

        <div class="main_fx">
            <div class="AccountManagement_c_iframe">
                <iframe id="MainFrame" src="userlist.html"></iframe>
            </div>
        </div>
    </div>

</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/main.js"></script>

</html>
