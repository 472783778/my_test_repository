package com.jxliu.ssm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxliu.ssm.pojo.User;
import com.jxliu.ssm.service.UserService;
import com.jxliu.ssm.util.EasyuiResult;
import com.jxliu.ssm.util.JsonResult;
import com.jxliu.ssm.util.JsonUtil;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/queryUserList")
	@ResponseBody
	public String queryUserList(){
		EasyuiResult er = new EasyuiResult();
		List<User> userList = userService.queryUserList();
		int total = userService.queryUserListCount();
		er.setRows(userList);
		er.setTotal(total);
		return JsonUtil.objToJson(er);
	}
	
	@RequestMapping("/saveUser")
	@ResponseBody
	public JsonResult saveUser(User user){
		JsonResult result = new JsonResult();
		userService.saveUser(user);
		return result;
	}
	
	@RequestMapping("/updateUser.action")
	@ResponseBody
	public JsonResult updateUser(User user){
		JsonResult result = new JsonResult();
		userService.updateUser(user);
		return result;
	}
	
	@RequestMapping("/deleteUser.action")
	@ResponseBody
	public JsonResult deleteUser(Integer id){
		JsonResult result = new JsonResult();
		userService.deleteUser(id);
		result.setSuccess(true);
		return result;
	}
}
