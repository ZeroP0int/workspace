<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
	<form action="UploadServlet" method="post" enctype="multipart/form-data">
		<input type="file" name="file"><br>
		<input type="text" name="name"><br>
		<select name="brand_id">
			<option value="1">��ֻ����</option>
			<option value="2">�ٲ�ζ</option>
		</select>
		
		<br>
		<input type="submit" value="�ϴ�"><br>
	</form>
	
	<!-- ��ʾ���ش������ϴ���ͼƬ -->
	<img  src="/img/sp01.jpg">
		
</body>
</html>