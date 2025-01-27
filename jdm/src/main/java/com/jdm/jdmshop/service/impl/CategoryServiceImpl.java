package com.jdm.jdmshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jdm.jdmshop.dto.CategoryDto;
import com.jdm.jdmshop.dto.CategoryVo;
import com.jdm.jdmshop.mapper.CategoryMapper;
import com.jdm.jdmshop.pojo.Category;
import com.jdm.jdmshop.service.CategoryService;

/**
 * 
 * @ClassName:  CategoryServiceImpl   
 * @Description: 商品种类业务逻辑层实现类 
 * @author: LiuJinrong
 * @date:   2019年2月11日 下午11:30:53
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	/**
	 * 注入Mapper
	 */
	@Autowired
	private CategoryMapper categoryMapper;

	
	/**
	 * 查询商品种类
	 */
	@Override
	public List<Category> select(Category category) {

		return categoryMapper.select(category);
	}


	
	/**
	 * 条件+分页查询分类列表
	 */
	@Override
	public PageInfo list(CategoryDto categoryDto) {
		
		PageHelper.startPage(categoryDto.getPage(), categoryDto.getLimit());
		
		List<CategoryVo> list = categoryMapper.selectPage(categoryDto);
		
		PageInfo<CategoryVo> pageInfo = new PageInfo<>(list); 
		
		return pageInfo;
	}

}









