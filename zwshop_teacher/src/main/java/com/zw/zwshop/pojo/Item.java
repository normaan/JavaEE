package com.zw.zwshop.pojo;
/**
 * 
 * 类描述：商品表实体类
 * 作者：   
 * 创建日期：2019年1月5日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class Item {

	// 主键ID
	private Integer itemId;
	// 所属分类ID
	private Integer cateId;
	// 商品名
	private String itemTitle;
	// 单价
	private String price;
	// 主图(路径)
	private String itemImg;
	// 详细描述
	private Integer itemDesc;
	// 状态(默认0), 0:下架，1:上架
	private Integer status;
	// 商品条码
	private String barcode;
	// 库存, 默认值为0
	private Integer stock;
	// 销量, 默认值为0
	private Integer sale;
	// 推荐标识, 0:不是推荐商品(默认), 1:是
	private Integer isRecommend;
	// 创建人, 对应sys_user表的user_id
	private Integer owner;
	// 创建时间
	private String createTime;
	// 是否禁用, 0:禁用（默认值为0）, 1:禁用
	private Integer disabled;
	
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getCateId() {
		return cateId;
	}
	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getItemImg() {
		return itemImg;
	}
	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}
	public Integer getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(Integer itemDesc) {
		this.itemDesc = itemDesc;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
	}
	public Integer getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}
	public Integer getOwner() {
		return owner;
	}
	public void setOwner(Integer owner) {
		this.owner = owner;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getDisabled() {
		return disabled;
	}
	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}
	
}
