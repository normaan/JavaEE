package com.jdm.jdmshop.dto;

import com.jdm.jdmshop.pojo.Category;

/**
 * 
 * @ClassName:  CategoryVo   
 * @Description: Category拓展展示类, 分类信息展示效果
 * @author: LiuJinrong
 * @date:   2019年1月8日 下午2:43:13
 */
public class CategoryVo extends Category {
	
	/**
	 * 上级分类名称
	 */
	private String pCateName;
	
	/**
	 * 二级分类图片路径
	 */
	private String catePpath;
	

	public String getpCateName() {
		return pCateName;
	}

	public void setpCateName(String pCateName) {
		this.pCateName = pCateName;
	}

	public String getPpath() {
		return catePpath;
	}

	public void setPpath(String ppath) {
		this.catePpath = ppath;
	}

}
