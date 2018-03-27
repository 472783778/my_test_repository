<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EasyUi>>>>datagrid</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-1.8.3.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/datagrid/crud.js"></script>
  </head>
  
  <body>
  
  <!-- 用户列表界面 -->
	<table id="dg" title="用户列表" class="easyui-datagrid" style="width:550px;height:250px"
		url="${pageContext.request.contextPath }/queryUserList.action"
		toolbar="#toolbar"
		rownumbers="true" fitColumns="true" singleSelect="true">
	<thead>
		<tr>
			<th field="username">用户名字</th>
			<th field="birthday">生日</th>
			<th field="sex">性别</th>
			<th field="address">地址</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
	<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
	<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
</div>

<!-- 用户新增界面 -->

<div id="dlg-add" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
	<div class="ftitle">用户信息页面</div>
	<form id="fm-add" method="post">
		<div class="fitem">
			<label>用户名称:</label>
			<input name="username" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>出生日期:</label>
			<input name="birthday" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>用户性别:</label>
			<input name="sex">
		</div>
		<div class="fitem">
			<label>居住地址:</label>
			<input name="address" class="easyui-validatebox">
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg-add').dialog('close')">取消</a>
</div>

<!-- 用户编辑界面 -->

<div id="dlg-edit" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
	<div class="ftitle">用户信息页面</div>
	<form id="fm-edit" method="post">
		<div class="fitem">
			<input name="id" type="hidden">
		</div>
		<div class="fitem">
			<label>用户名称:</label>
			<input name="username" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>出生日期:</label>
			<input name="birthday" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>用户性别:</label>
			<input name="sex">
		</div>
		<div class="fitem">
			<label>居住地址:</label>
			<input name="address" class="easyui-validatebox">
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="updateUser()">修改</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg-edit').dialog('close')">取消</a>
</div>

  </body>
</html>
