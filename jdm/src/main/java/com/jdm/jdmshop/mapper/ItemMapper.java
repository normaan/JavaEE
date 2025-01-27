package com.jdm.jdmshop.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.jdm.jdmshop.pojo.Item;

/**
 * 
 * @ClassName:  ItemMapper   
 * @Description: 商品表实体类 
 * @author: LiuJinrong
 * @date:   2019年2月10日 下午5:32:20
 */
public interface ItemMapper extends Mapper<Item> {

	
	/**
	 * 
	 * @Description: 根据多个商品id查询多个商品
	 * @author: LiuJinrong
	 * @date:   2019年2月15日 下午11:52:44    
	 * @param itemIds
	 * @return
	 */
	List<Item> selectList(String[] itemIds);

}
