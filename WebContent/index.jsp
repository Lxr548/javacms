<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<title>陕西省物流学会会员申请</title>
<style type="text/css">
	body{text-align: center;}
	h3{color:#0faee0;margin-top: 30px;font-size: 20px;}
	a{color:#aa0bea;font-size: 15px;text-decoration: none;}
	input{height: 35px;width: 220px;border:0;border-radius: 5px;color: #FFF;position: absolute;margin-left:-110px; bottom: 25px;}
	#company{background-color:rgba(250,150,20,0.9);margin-left:-235px;}
	#company:hover{background-color:rgba(250,150,20,1);}
	#person{background-color:rgba(15,174,224,0.9);margin-left:15px;}
	#person:hover{background-color:rgba(15,174,224,1);}
</style>
</head>
<body>
	<h3>陕西省物流学会会员申请</h3>
	<a href="apply/progress.jsp">查看申请进度</a>
	<div><input id="company" type="button" value="企业注册" onclick="javascrtpt:window.location.href='apply/company_register.jsp'" />
	<input id="person" type="button" value="个人注册" onclick="javascrtpt:window.location.href='apply/person_register.jsp'" /></div>
</body>
</html>