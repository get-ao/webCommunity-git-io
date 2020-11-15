<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/js/jquery-3.5.0.main.js"></script>
<script src="Layui/layui/layui.js"></script>
 <link rel="stylesheet" href="Layui/layui/css/layui.css" media="all">
 <link rel="stylesheet" href="css/login.css">
<title>Login</title>
</head>
<body style="background-image: url('image/d3.jpg');background-repeat: no-repeat;background-size: cover;">
	<div class="login">
	<form  class="layui-form" action="login" method="post">
	<h1>登&nbsp;陆&nbsp;界&nbsp;面</h1>
	<br>
	 <i class="layui-icon layui-icon-username myIcon" style="font-size: 30px;"></i>
	 <label style="font-size: 20px;" class="layui-form-label">账&nbsp;号</label>
    <div class="layui-input-inline">
      <input style="font-size: 20px;" type="text" name="user" required  lay-verify="required" placeholder="请输入学号" autocomplete="off" class="layui-input">
    </div>
    <br>
    <br>
     <i class="layui-icon layui-icon-password" style="font-size: 30px;"></i>
    <label style="font-size: 20px;" class="layui-form-label">密&nbsp;码</label>
    <div class="layui-input-inline">
      <input style="font-size: 20px;" type="password" name="password" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
    <br>
     <div  class="layui-form-item">
    <div  class="layui-input-block">
      <input type="radio" name="kind" value="学生" title="学生" checked>
      <input type="radio" name="kind" value="老师" title="老师" >
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
	</form>
	</div>
</body>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
});
</script>
</html>