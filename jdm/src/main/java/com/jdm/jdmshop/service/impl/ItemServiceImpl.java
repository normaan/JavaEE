package com.jdm.jdmshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdm.jdmshop.mapper.ItemMapper;
import com.jdm.jdmshop.pojo.Item;
import com.jdm.jdmshop.service.ItemService;

/**
 * 
 * @ClassName:  ItemServiceImpl   
 * @Description: 商品物业逻辑层实现类 
 * @author: LiuJinrong
 * @date:   2019年2月10日 下午5:47:42
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	/**
	 * 注入Mapper
	 */
	@Autowired
	private ItemMapper ItemMapper;

	
	/**
	 * 查询商品
	 */
	@Override
	public List<Item> Select(Item item) {

		return ItemMapper.select(item);
	}


	/**
	 * 根据多个商品id查询多个商品
	 */
	@Override
	public List<Item> selectList(String[] itemIds) {

		return ItemMapper.selectList(itemIds);
	}


	/**
	 * 根据商品id查询单个商品
	 */
	@Override
	public Item selectOne(Item item) {

		return ItemMapper.selectOne(item);
	}
	

}






