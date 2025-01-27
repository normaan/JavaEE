package com.jdm.jdmshop.service;

import java.util.List;

import com.jdm.jdmshop.pojo.Item;

/**
 * 
 * @ClassName:  ItemService   
 * @Description: 商品业务逻辑层接口 
 * @author: LiuJinrong
 * @date:   2019年2月10日 下午5:42:53
 */
public interface ItemService {

	
	/**
	 * 
	 * @Description: 查询商品
	 * @author: LiuJinrong
	 * @date:   2019年2月10日 下午5:46:44    
	 * @param item
	 * @return
	 */
	List<Item> Select(Item item);

	
	
	/**
	 * 
	 * @Description: 根据多个商品id查询多个商品
	 * @author: LiuJinrong
	 * @date:   2019年2月15日 下午11:51:49    
	 * @param itemIds
	 * @return
	 */
	List<Item> selectList(String[] itemIds);



	/**
	 * 
	 * @Description: 根据商品id查询单个商品
	 * @author: LiuJinrong
	 * @date:   2019年2月15日 下午11:51:49    
	 * @param itemId
	 * @return
	 */
	Item selectOne(Item item);
	

}
