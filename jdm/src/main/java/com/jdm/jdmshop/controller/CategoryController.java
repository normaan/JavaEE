package com.jdm.jdmshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.jdm.jdmshop.dto.CategoryDto;
import com.jdm.jdmshop.pojo.Category;
import com.jdm.jdmshop.service.CategoryService;
import com.jdm.jdmshop.utils.R;

/**
 * 
 * @ClassName:  CategoryController   
 * @Description: 商品种类控制层
 * @author: LiuJinrong
 * @date:   2019年2月11日 下午11:13:36
 */
@Controller
@RequestMapping("category")
public class CategoryController {
	
	/**
	 * 注入Service
	 */
	@Autowired
	private CategoryService categoryService;
	
	
	/**
	 * 
	 * @Description: 查询商品种类
	 * @author: LiuJinrong
	 * @date:   2019年2月11日 下午11:29:23    
	 * @param category
	 * @return
	 */
	@RequestMapping("select")
	@ResponseBody
	public R select(Category category) {
		
		// 初始化填充商品种类对象集合
		List<Category> categories = null;
		
		try {
			// 执行查询
			categories = categoryService.select(category);
			
		} catch (Exception e) {
			e.printStackTrace();
			// 异常响应至页面
			return R.error("服务器发生未知异常,请联系管理员");
		}
		
		// 判断查询是否成功
		if (categories != null) {
			return R.ok().put("categories", categories);
			
		} else {
			// 查询为空
			return R.error("不存在此分类");
		}
	}
	
	
	
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public R list(CategoryDto categoryDto) {
		
		// 创建填充分页对象
		PageInfo pageInfo = null;
		System.out.println();
		try {
			// 执行条件+分页查询分类列表方法
			pageInfo = categoryService.list(categoryDto);
			
		} catch (Exception e) {
			e.printStackTrace();
			// 异常响应至页面
			R.error("服务器发生未知异常,请联系管理员");
		}
		
		// 判断查询结果
		if (pageInfo != null) {
			return R.ok().put("page", pageInfo);
			
		} else {
			return R.error("不存在此分类");
		}
		
	}
	
	
	
	

}









