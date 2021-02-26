<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>陕西物流学会个人会员申请登记表</title>
</head>
<body>
	<h1>陕西物流学会个人会员申请登记表</h1>
	<form action="RegiterServet" method="post">
      <input type="text"  placeholder="请填写您的姓名（必填项）">
      <input type="text"  placeholder="请填写您的姓名（拼音大写，必填项）">
      <select>
      	<option>性别</option>
      	<option value="M">男</option>
      	<option value="F">女</option>
      </select>
      <select>
      	<option>文化程度</option>
      	<option value="1">初中及以下</option>
      	<option value="2">中专</option>
      	<option value="3">高中</option>
      	<option value="4">大专</option>
      	<option value="5">本科</option>
      	<option value="6">硕士</option>
		<option value="7">博士</option>
      </select>
      <input type="tel" placeholder="请填写您的手机号码（必填项）">
      <select>
      	<option>政治面貌</option>
      	<option value="1">群众</option>
      	<option value="2">中共党员</option>
      </select>    
      <input type="text" placeholder="请填写您的微信号">
      <input type="email" placeholder="请填写您的电子邮箱">
      <input type="tel" placeholder="请填写您的固定电话">
      <input type="text" placeholder="请填写您的工作单位">
      <input type="text" placeholder="请填写您在单位的职务">
      <input type="text"  placeholder="请填写您的家庭住址">
      <input type="text" placeholder="请填写您的身份证号">
	<p><input name="butter" type="submit" id="butter" value="提交申请" /><p>
	<p><font color="red">${error }</font></p>
  </form>
</body>
</html>