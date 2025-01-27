package com.zw.zw_mvnljrssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zw.zw_mvnljrssm.dto.UserDto;
import com.zw.zw_mvnljrssm.pojo.User;
import com.zw.zw_mvnljrssm.service.UserService;

/**
 * 
 * 类描述：用户控制层
 * 作者： LiuJinrong  
 * 创建日期：2018年12月28日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * 方法描述: 用户列表+分页+模糊查询
	 * @param userDto 用户拓展实体类对象
	 * @return page结果
	 */
	@RequestMapping(value="userList", produces="application/json;charset=utf-8")
	@ResponseBody
	public String userList(UserDto userDto){
		// 创建json对象
		JSONObject json = new JSONObject();
		
		// 对page结果进行包装
		PageInfo<UserDto> pageInfo = null;
		try {
			// 执行Service层查询方法
			pageInfo = userService.userList(userDto);
			
			// 将结果填充至json对象
			json.put("code", pageInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 响应json字符串
		return json.toString();
	}
	
	
	/**
	 * 
	 * 方法描述: 根据用户id删除单条用户
	 * @param id 用户id
	 * @return 影响行数
	 */
	@RequestMapping("userDeleteById")
	@ResponseBody
	public String userDeleteById(int id){
		// 创建json对象
		JSONObject json = new JSONObject();
		// 定义结果变量
		int result = 0;
		try {
			// 执行Service层根据用户id删除单条用户
			result = userService.userDeleteById(id);
			// 将影响行数填充至json对象
			json.put("code", result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 将json对象响应至ajax
		return json.toString();
	}
	
	
	
	/**
	 * 
	 * 方法描述: 根据id查询用户信息的回显
	 * @param id 用户id
	 * @return 用户实体类对象
	 */
	@RequestMapping(value="selectUserByIdUpdateBackShow", produces="application/json;charset=utf-8")
	@ResponseBody
	public String selectUserByIdUpdateBackShow(@RequestParam(required=false, defaultValue="-1") int id){
		// 创建json对象
		JSONObject json = new JSONObject();
		// 创建用户实体类对象
		User user = null;
		try {
			// 判断页面请求是否存在id值
			if (id > 0) {
				// 执行Service层根据id查询用户信息的回显方法
				user = userService.selectUserByIdUpdateBackShow(id);
				// 将包用户实体类对象填充至json对象
				json.put("code", user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 将json对象响应至ajax
		return json.toString();
	}
	
	
	
	/**
	 * 
	 * 方法描述: 添加/修改单条用户
	 * @param user 用户实体类对象
	 * @return 影响行数
	 */
	@RequestMapping("userAddUpdate")
	@ResponseBody
	public String userAddUpdate(HttpServletRequest request){
		// 创建json对象
		JSONObject json = new JSONObject();
		// 定义影响行数变量
		int result = 0;
		try {
			// 获取请求的map信息
			Map<String, String[]> products = request.getParameterMap();
			// 封装对象数据
			User user = new User();
			// 使用BeanUtils填充数据
			BeanUtils.populate(user, products);
			
			// 初始化创建与修改时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = format.format(new Date());
			// 将时间封装到对象中
			user.setCreateDate(date);
			user.setUpdateDate(date);
			
			// 根据用户发出是否存在id值来判断添加/修改功能
			if (user.getId() > 0) {
				// 执行Service层修改单条用户
				result = userService.userUpdate(user);
			} else {
				// 执行Service层添加单条用户
				result = userService.userAdd(user);
			}
			
			// 判断是否执行成功
			if (result > 0) {
				// 将影响行数填充至json对象
				json.put("code", 1);
			} else {
				// 失败
				json.put("code", 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 将json对象响应至ajax
		return json.toString();
	}
	
	
	
	/**
	 * 
	 * 方法描述: 根据用户id数组批量删除用户
	 * @param ids 用户id数组
	 * @return 影响行数
	 */
	@RequestMapping("userDeleteByIds")
	@ResponseBody
	public String userDeleteByIds(String ids){
		// 创建json对象
		JSONObject json = new JSONObject();
		// 定义影响行数变量
		int result = 0;
		try {
			// 将用户id数组按逗号分隔为字符数组
			String[] split = ids.split(",");
			// 执行Service层根据用户id数组批量删除用户
			result = userService.userDeleteByIds(split);
			// 判断是否执行成功
			if (result > 0) {
				// 将执行结果填充至json对象
				json.put("code", 1);
			} else {
				// 删除失败
				json.put("code", 0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 将json对象响应至页面
		return json.toString();
	}
	

}







