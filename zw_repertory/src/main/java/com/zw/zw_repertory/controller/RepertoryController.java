package com.zw.zw_repertory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zw.zw_repertory.dto.RepertoryDto;
import com.zw.zw_repertory.pojo.RepertoryCount;
import com.zw.zw_repertory.service.RepertoryService;

/**
 * 
 * 类描述：库存表示层控制器
 * 作者： LiuJinrong  
 * 创建日期：2018年12月31日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Controller
@RequestMapping("repertory")
public class RepertoryController {
	
	// 注入库存Service
	@Autowired
	private RepertoryService repertoryService;
	
	/**
	 * 传递对象方式
	 * 方法描述: 库存列表+模糊查询+分页
	 * @param repertoryList 库存列表实体类
	 * @return json字符串
	 */
	@RequestMapping(value="repertorySelect", produces="application/json;charset=utf-8")
	@ResponseBody
	public String repertorySelect(RepertoryDto repertoryDto){
		
		// 创建json对象
		JSONObject json = new JSONObject();
		
		// 创建page结果集
		PageInfo<RepertoryDto> pageInfo = null;
		
		try {
			// 执行Service层查询方法,对page结果进行包装
			pageInfo = repertoryService.repertorySelect(repertoryDto);
			
			// 将结果集填充至json对象
			json.put("code", pageInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 将json对象响应至页面
		return json.toString();
	}
	
	
	
	
	
	
	/**
	 * 传递字符串方式
	 * 方法描述: 库存列表+模糊查询+分页
	 * @param repertoryList 库存列表实体类
	 * @return json字符串
	 */
	@RequestMapping(value="repertorySelect2", produces="application/json;charset=utf-8", consumes="application/json")
	@ResponseBody
	public String repertorySelect2(@RequestBody RepertoryDto repertoryDto){
		
		// 创建json对象
		JSONObject json = new JSONObject();
		
		// 创建page结果集
		PageInfo<RepertoryDto> pageInfo = null;
		
		try {
			// 执行Service层查询方法,对page结果进行包装
			pageInfo = repertoryService.repertorySelect(repertoryDto);
			
			// 将结果集填充至json对象
			json.put("code", pageInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 将json对象响应至页面
		return json.toString();
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * 方法描述: 添加商品
	 * @param repertoryList 填充商品实体类的List集合
	 * @return 影响行数
	 */
	@RequestMapping("repertoryAdd")
	@ResponseBody
	public String repertoryAdd(RepertoryCount repertoryCount){
		
		// 创建json对象
		JSONObject json = new JSONObject();
		
		// 创建影响行数
		int result = 0;
		try {
			// 执行Service层添加方法
			result = repertoryService.repertoryAdd(repertoryCount);
			
			// 判断是否执行成功
			if (result > 0) {
				// 将执行结果填充至json对象,执行成功
				json.put("code", 1);
			} else {
				// 执行失败
				json.put("code", 0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 将json对象响应至页面
		return json.toString();
	}

}














