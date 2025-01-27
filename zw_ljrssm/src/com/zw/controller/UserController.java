package com.zw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zw.pojo.User;
import com.zw.service.UserService;

/**
 * 
 * 类描述：用户表示层控制器
 * 作者： LiuJinrong  
 * 创建日期：2018年12月27日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Controller
@RequestMapping("user")
public class UserController {

	// 注入用户业务逻辑层
	@Autowired
	private UserService userSerivce;

	/**
	 * 
	 * 方法描述:用户列表
	 */
	@RequestMapping("userList")
	@ResponseBody
	public String userList(){
		// 创建json对象
		JSONObject json = new JSONObject();
		// 创建填充User对象的List集合
		List<User> list = null;
		try {
			// 调用Service层用户列表方法
			list = userSerivce.userList();
			// 将结果赋值给json对象
			json.put("code", list);
			// 响应至页面
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toJSONString();
	}

}





