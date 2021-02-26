<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员列表</title>
</head>
<body>
  <h3 class="text-center">陕西物流学会会员列表</h3>
  <table border="1">
  	<tr>
        <th>类型</th>
        <th>名称</th>
        <th>申请时间</th>
        <th>证书</th>
        <th>状态</th>
        <th>操作</th>
      </tr>
      <tr>
        <td>个人会员</td>
        <td></td>
        <td>${u.creat_date }</td>
        <td>${u.resumes }</td>
        <td>${u.date_status }</td>
        <td><a href="">审批</a></td>
      </tr>
  </table>

</body>
</html>