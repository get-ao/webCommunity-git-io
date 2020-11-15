 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cn.student.Factory.*,cn.student.dao.*,cn.student.entity.*,cn.student.service.*,cn.student.util.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% response.setContentType("text/html; charset=utf-8"); 
	response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery-3.5.0.min.js"></script>
<script src="Layui/layui/layui.js"></script>
 <link rel="stylesheet" href="Layui/layui/css/layui.css" media="all">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>学生信息管理后台</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">学生信息管理后台</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">主页</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="image/3.jpg" class="layui-nav-img">
          贤心
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="login.jsp">退出登陆</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">学生信息</a>
          <dl class="layui-nav-child">
            <dd><a href="">查看信息</a></dd>
            <dd><a href="javascript:;">成绩统计</a></dd>
            <dd><a href="javascript:;">待开发</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">解决方案</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">列表一</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="">其他</a></li>
        <li class="layui-nav-item"><a href="">发布商品</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
<script type="text/html" id="toolbar">
  <div class="layui-btn-container">
   <button   type="button" class="layui-btn layui-btn-primary layui-btn-sm">
    <i lay-event="add"  class="layui-icon">&#xe654;</i><!-- 添加 -->
  </button>
	<button type="button" class="layui-btn layui-btn-primary layui-btn-sm">
    <i lay-event="Setdel" class="layui-icon">&#xe640;</i><!-- 批量删除 -->
  </button>
	<input class="text" lay-verify="number"  style="float:center;height:30px;width:157px; font-size:15px;" id="key" 
                      placeholder="请输入学号">
           <a  lay-filter="" style="left: 144px;">
                    <i lay-event="find" class="layui-icon layui-icon-search" style="padding:10px;"></i>
           </a>
  </div>
</script>
<!-- 分页数据 -->
<table class="layui-hide" id="student" lay-filter="student"></table>

  <script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs"  lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


    </div>
  </div>
</div>
<!-- 添加界面弹窗 -->
<div id="test"  style="display: none;">
	<form class="layui-form" action="Add" method="post" >
  <div class="layui-form-item">
    <label class="layui-form-label">请输入学号</label>
    <div class="layui-input-block">
      <input type="number" name="student_id" required  lay-verify="required"  autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">请输入姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name" required lay-verify="required"  autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">请输入年龄</label>
    <div class="layui-input-block">
      <input type="number" name="age" required lay-verify="required"  autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">请选择性别</label>
    <div class="layui-input-block">
      <input type="radio" name="sex" value="男" title="男">
      <input type="radio" name="sex" value="女" title="女" checked>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">请输入专业</label>
    <div class="layui-input-block">
      <input type="text" name="grade" required lay-verify="required"  autocomplete="off" class="layui-input">
    </div>
  </div>
</form>
</div>
<!-- 编辑界面弹窗 -->
<div id="edit"  style="display: none;">
	<form class="layui-form"  method="post" lay-filter="edit" >
  <div class="layui-form-item">
    <label class="layui-form-label">请输入学号</label>
    <div class="layui-input-block" lay-filter="layuiadmin-form-role" >
      <input type="number"   readonly="readonly"  name="student_id" required  lay-verify="required"  autocomplete="off" class="layui-input">(无法修改)
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">请输入姓名</label>
    <div class="layui-input-block" lay-filter="layuiadmin-form-role">
      <input type="text"  name="name" required lay-verify="required"  autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">请输入年龄</label>
    <div class="layui-input-block" lay-filter="layuiadmin-form-role">
      <input type="number"   name="age"  required lay-verify="required"  autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">请输入性别</label>
  <div class="layui-input-block" lay-filter="layuiadmin-form-role">
      <input type="text"   name="sex" required lay-verify="required"  autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">请输入专业</label>
    <div class="layui-input-block" lay-filter="layuiadmin-form-role">
      <input  type="text" name="grade" required lay-verify="required"  autocomplete="off" class="layui-input">
    </div>
  </div>
</form>
</div>
<script>
layui.use(['element','form','jquery','layer','table'], function(){
	  var element = layui.element;
	  var form = layui.form;
	  var $ = layui.jquery;
	  var layer = layui.layer;
	  var table = layui.table;
  //table渲染
  	table.render({
  	  elem: '#student'
  	    ,url: 'page' //数据接口
  	    ,page: true //开启分页
  	    ,totalRow:true//开启合计行
  	  	,toolbar: "#toolbar"
  	    ,cols: [[ //表头
  	    	 	{type: 'checkbox', fixed: 'left'}
  			,{field:'id', title:'ID', width:80, fixed: 'left', sort: true}
  			,{field:'student_id', title:'学号', width:120}
  			,{field:'name', title:'姓名', width:120 }
  			,{field:'age', title:'年龄', width:120 }
  			,{field:'sex', title:'性别', width:120 }
  			,{field:'grade', title:'班级', width:120 }
  			,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:160}
  
  	    ]]
  		,response:{
  			statusCode:200	//重新规定状态码
  		}
  		,parseData: function(res){//将原始数据解析成table组件规范的数据
  			return{
  			"code":res.status,//状态码
  			"msg":res.message,//提示文本
  			"count":res.datasize,//数据长度
  			"data":res.row.item//数据列表
  		};
  		}
  	});
  //表头监听事件
  	table.on('toolbar(student)',function(obj){
  		var list=new Array();
  		var checkStatus = table.checkStatus(obj.config.id)
  	    ,data = checkStatus.data; //获取选中的数据
  		for(var i = 0; i<data.length;i++){
  			list.push(data[i].student_id);
  		}
  		if(obj.event === "Setdel"){
  		//	console.log(list);
  			layer.confirm("确定删除选中数据嘛？",function(index){
  	 			//ajax请求
  	 			$.ajax({
  	 				url:"allDel",
  	 				type:"post",
  	 				data:{list:list.toString()},
  	 				dataType:"text",
  	 				success: function (data) {
  						layer.msg("删除成功",{icon:6});
  						 table.reload('student',{});
  					},
  					error:function(data){
  						layer.msg("删除失败",{icon:5});
  					}
  	 			})
  	 		});
  		}
  		else if(obj.event === "add"){//添加事件
  			layer.open({
				  title: '添加学生数据',
				  content: $("#test").html(),
				  scrollbar: false,
				  anim: 3,
				  area:"auto",
				  btn:['添加','关闭'],
				  btnAlign:'c',
				  success: function (layero, index) { // 成功弹出后回调
					//添加form标识
					layero.addClass('layui-form')
					//将保存按钮改成提交按钮
					layero.find('.layui-layer-btn0').attr({
						'lay-filter':'addRole',
						'lay-submit':''
					})
					//表单重载
	                  form.render();
	              }, 
	             yes : function(index, layero) { // 确认按钮回调函数
	                // 监听提交按钮
	                form.on('submit(addRole)', function(data) {
	                //	console.log(data.field.student_id);
	                	$.ajax({
		 				url:"Add",
		 				type:"post",
		 				data:{"student_id":data.field.student_id,
		 					  "name":data.field.name,
		 					  "age":data.field.age,
		 					  "sex":data.field.sex,
		 					  "grade":data.field.grade
		 				},
		 				dataType:"text",
		 				success: function (data) {
		 					table.reload('student',{});
							layer.alert("添加成功",{icon:6});
						},
						error:function(data){
							layer.msg("添加失败",{icon:5});
					}
				 })
	          });
	        },
		});
  		}
  		else if(obj.event === "find"){//查找数据
  		//	console.log($("#key").val());
  			table.reload('student',{
					url:"find",
					 page: {//page参数是指重新刷新后从第几页开始
				          curr: 1 //重新从第 1 页开始
				        },
				    where:{//后台发送的数据
				    	key:$("#key").val()
				    }
				},'data');//data是默认值
  		}
  	})
  //监听行单击事件
 	table.on('tool(student)',function(obj){
 		var data = obj.data; //获取当前行数据
 		var layEvent = obj.event; //获取lay-event对应的值
 		var tr = obj.tr; //获取当前行tr的dom对象
 		if(layEvent==="del"){
 		layer.confirm("确定删除嘛？",function(index){
 			//ajax请求
 			$.ajax({
 				url:"del",
 				type:"post",
 				data:{"student_id":data.student_id},
 				dataType:"text",
 				success: function (data) {
					layer.msg("删除成功",{icon:6});
					obj.del();
					layer.close(index);
				},
				error:function(data){
					layer.msg("删除失败",{icon:5});
				}
 			})
 		});
 		}
 		else if (layEvent==="edit") {
 			//编辑事件
 				layer.open({
 					  title: '编辑学生信息',
 					  content: $("#edit").html(),
 					  scrollbar: false,
 					  anim: 3,
 					  area:"auto",
 					  btn:['保存','关闭'],
 					  success: function (layero, index) { // 成功弹出后回调
 						//添加form标识
 						layero.addClass('layui-form')
 						//将保存按钮改成提交按钮
 						layero.find('.layui-layer-btn0').attr({
 							'lay-filter':'editRole',
 							'lay-submit':''
 						})
 						//表单重载
 		                  form.render();
 		              }, 
 		             yes : function(index, layero) { // 确认按钮回调函数
 		                // 监听提交按钮
 		                form.on('submit(editRole)', function(data) {
 		                	//console.log(data.field);
 		                	$.ajax({
			 				url:"edit",
			 				type:"post",
			 				data:{"student_id":data.field.student_id,
			 					  "name":data.field.name,
			 					  "age":data.field.age,
			 					  "sex":data.field.sex,
			 					  "grade":data.field.grade
			 				},
			 				dataType:"text",
			 				success: function (data) {
			 					table.reload('student',{});
								layer.msg("修改成功",{icon:6});
							},
							error:function(data){
								layer.msg("编辑失败",{icon:5});
						}
 					 })
 		          });
 		        },
 			}); 
 				 form.val('edit',{
 					 //填充表格
 					 "student_id" : data.student_id
 					 ,"name": data.name
 					 ,"age" : data.age
 					 ,"sex" : data.sex
 					 ,"grade" : data.grade
 				 })
		}
 	});
   
      
});
</script>
</body>

</html>