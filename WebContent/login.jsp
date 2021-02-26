<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<style type="text/css">
	body{text-align: center;}
	h3{color:#0faee0;margin-top: 30px;font-size: 20px;line-height:160px;}
	input{height: 30px;width: 500px;border: 1px solid #999;border-radius: 5px;box-shadow:0px 1px 1px #CCC inset;}
	#butter{height: 34px;width: 504px;border: 1px solid #0faee0;box-shadow:0px 1px 1px #0faee0 inset;color: #FFF;background-color:rgba(15,174,224,0.8);}
	#butter:hover{background-color:rgba(15,174,224,1);}
</style>
</head>
<body>
	<h3>陕西物流学会会员后台管理</h3>
	<form action="LoginServlet" method="post">
		<p><input name="account" type="text" value="${account }" placeholder="  请输入账号" /></p>
		<p><input name="password" type="password" value="${password }" placeholder="  请输入密码" /><p>
		<p><input name="butter" type="submit" id="butter" value="登录" /><p>
		<p><font color="red">${error }</font></p>
	</form>
</body>
</html>