<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
    <!-- 食品管理 -->
            <div class="AccountManagement_c" id="ColumnManagement_c">
                <h3>食品管理 
                    <div class="amcl fr">
                        <input type="text" placeholder="食品名" class="fl" name="">
                        <div class="search fl"><img src="images/search.png"></div>
                    </div> 
                </h3>
                <div class="AM_ct text_center">
                    <div class="AM_ct_in">
                        <a href="foodadd.html"><div class="add_btn df_btn fl" id="add_column_btn">添加</div></a>
                    </div>
                </div>

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><input type="checkbox" name="newsId"><span>序号</span></label></li>
                        <li class="b20"><label>食品名称</label></li>
                         <li class="b20"><label>品牌</label></li>
                          <li class="b20"><label>类型</label></li>
                        <li class="b60"><label>操作</label></li>
                    </ul>
                    <div class="list_b_c">
                       

                            <ul class="list_b">
                                <li class="b20"><label><input type="checkbox" name=""><span>1</span></label></li>
                                <li class="b20"><label>良品铺子 手剥松子218g 坚果炒货 巴西松子</label></li>
                                 <li class="b20"><label>三只松鼠</label></li>
                                  <li class="b20"><label>休闲零食</label></li>
                                <li class="b60">
                            	<a href="foodedit.html"><div class="edit_btn df_btn fl text_center">编辑</div></a>
                        		<a href="ItemDeleteItem?newsId=${newsId}"><div class="delete_btn df_btn fl text_center">删除</div></a>
                        		</li>
                            </ul>
                      
                     
                       
                    </div>

                    <div class="pull_page">
                        <div class="fl pull_page_up">上一页</div>
                            <ul>
                                <li class="on">1</li>
                                <li>2</li>
                                <li>3</li>
                                <li>4</li>
                                <li class="pull_page_df_btn">…</li>
                                <li>12</li>
                            </ul>
                        <div class="fl pull_page_down">下一页</div>
                    </div>

                    
                </div>
            </div>


           

</body>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
</html>