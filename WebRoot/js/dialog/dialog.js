var curPath=window.document.location.href;  
var pathName=window.document.location.pathname;  
var pos=curPath.indexOf(pathName);  
//获取主机地址，如： http://localhost:8080  
var localhostPaht=window.document.location.href.substring(0,pos); 
//获取带"/"的项目名，如：/ssm_demo
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 

//新增用户
function newUser(){
	$('#dlg-add').dialog('open').dialog('setTitle','新增用户');
	$('#fm-add').form('clear');
}

//编辑用户
function editUser(){
	var row = $('#dg').datagrid('getSelected');
//	alert(row.id);
	if (row){
		$('#dlg-edit').dialog('open').dialog('setTitle','编辑用户');
		$('#fm-edit').form('load',row);
	}
}

//保存用户
function saveUser(){
	var url = localhostPaht + projectName + "/saveUser.action";
	$('#fm-add').form('submit',{
		url: url,
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(result){
			var result = eval('('+result+')');
			if (result.errorMsg){
				$.messager.show({
					title: 'success',
					msg: result.errorMsg
				});
			} else {
				$('#dlg-add').dialog('close');		// close the dialog
				$('#dg').datagrid('reload');	// reload the user data
			}
		}
	});
}

//修改用户
function updateUser(){
	var url = localhostPaht + projectName + "/updateUser.action";
	$('#fm-edit').form('submit',{
		url: url,
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(result){
			var result = eval('('+result+')');
			if (result.errorMsg){
				$.messager.show({
					title: 'success',
					msg: result.errorMsg
				});
			} else {
				$('#dlg-edit').dialog('close');		// close the dialog
				$('#dg').datagrid('reload');	// reload the user data
			}
		}
	});
}

//删除用户
function destroyUser(){
	var row = $('#dg').datagrid('getSelected');
//	var url = localhostPaht + projectName + "/deleteUser.action";
	if (row){
		$.messager.confirm('Confirm','你确定要删除这条信息吗',function(r){
			if (r){
				$.post("deleteUser.action",{id:row.id},function(result){
					if (result.success){
						$('#dg').datagrid('reload');	// reload the user data
					} else {
						$.messager.show({	// show error message
							title: 'Error',
							msg: result.errorMsg
						});
					}
				},'json');
			}
		});
	}
}