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
import com.zw.zw_repertory.pojo.RepertoryList;
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
	// produces 为了方便调试查看

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
	// produces 为了方便调试查看

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
	 * @Description: 根据商品id查询数据用于回显
	 * @author: LiuJinrong
	 * @date:   2019年1月6日 上午1:49:29    
	 * @param shopId 商品id
	 * @return RepertoryList对象
	 */
	// produces 为了方便调试查看

	@RequestMapping(value="repertorySelectById", produces="application/json;charset=utf-8")
	@ResponseBody
	public String repertorySelectById(String shopId){

		// 创建json对象
		JSONObject json = new JSONObject();

		// 创建RepertoryList对象
		RepertoryList repertoryList = null;

		try {
			// 执行Service层根据商品id查询数据
			repertoryList = repertoryService.repertorySelectById(shopId);

			// 将查询出对象填充json对象
			json.put("code", repertoryList);

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
	@RequestMapping("repertoryAddUpdate")
	@ResponseBody
	public String repertoryAddUpdate(RepertoryCount repertoryCount){

		// 创建json对象
		JSONObject json = new JSONObject();

		// 创建影响行数
		int result = 0;
		
		try {
			// 判断请求是否有值来进行添加/修改商品信息
			if (repertoryCount.getShopId() == null) {
				// 执行Service层添加商品方法
				result = repertoryService.repertoryAdd(repertoryCount);
			} else {
				// 执行Service层修改商品方法
				result = repertoryService.repertoryUpdate(repertoryCount);
			}
			
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





	/**
	 * 
	 * 方法描述: 删除单个商品
	 * @param shopId 商品id
	 * @return 影响行数
	 */
	@RequestMapping("repertoryDeleteById")
	@ResponseBody
	public String repertoryDeleteById(Integer shopId){

		// 创建json对象
		JSONObject json = new JSONObject();

		// 创建影响行数
		int result = 0;
		try {
			// 调用Service层的根据ids删除商品信息的方法
			result = repertoryService.repertoryDeleteById(shopId);

			// 判断影响行数
			if (result > 0) {
				// 将执行结果填充至json对象中
				json.put("code", result);
			} else {
				// 删除失败
				json.put("code", result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 将json对象响应至页面
		return json.toString();

	}




	/**
	 * 
	 * 方法描述: 根据id数组批量删除商品
	 * @param shopIds 填充商品ids的数组
	 * @return 影响行数
	 */
	@RequestMapping("repertoryDeleteByIds")
	@ResponseBody
	public String repertoryDeleteByIds(String[] shopIds){

		// 初始化json对象
		JSONObject json = new JSONObject();

		// 创建影响行数
		int result = 0;
		try {
			// 调用Service层根据id数组批量删除商品
			result = repertoryService.repertoryDeleteByIds(shopIds);

			// 判断执行是否成功
			if (result > 0) {
				// 将执行结果填充至json对象中
				json.put("code", 1);
			} else {
				// 批量删除失败
				json.put("code", 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 将json对象响应至页面
		return json.toString();
	}
	

}














