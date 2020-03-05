<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<!-- 食品管理 -->
            <div class="AccountManagement_c" id="NewsManagement_c">
                <h3>食品管理 
                   
                </h3>
                <div class="list" id="release_news">
                    <ul class="list_h">
                        <li class="b80"><label>添加食品</label></li>
                    </ul>
                    <div class="list_b_c" id="release_news_in">
                        <div class="release_news">
                            <div class="news_title">
                                <label class="text_center">名字</label>
                                <input type="text" placeholder="填写食品名" name="">
                            </div>
                            <br>
                            <div class="news_title">
                                <label class="text_center">单价</label>
                                <input type="text" placeholder="填写单价" name="">
                            </div>
                             
                             <div class="column_name">
                                <label class="text_center">口味</label>
                                <input type="checkbox" >麻辣 &nbsp; &nbsp;<input type="checkbox" >番茄
                            </div>
                            <div class="column_name">
                                <label class="text_center">类型</label>
                                <select class="column_name_release">
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                </select>
                            </div>
                            <div class="column_name">
                                <label class="text_center">品牌</label>
                                <select class="column_name_release">
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                    <option></option>
                                </select>
                            </div>
                            <br>
                            <div class="news_title">
                                <label class="text_center">图片</label>
                                <input type="file" placeholder="选择图片" name="">
                            </div>
                           
                            <div class="release_news_ok_btn text_center">保存</div>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>