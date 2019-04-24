package com.zw.service;

import com.zw.pojo.User;

/**
 * 
 * 类描述：用户业务逻辑接口
 * 作者： LiuJinrong  
 * 创建日期：2018年12月27日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public interface UserService {

	/**
	 * 
	 * 方法描述: 根据用户id查询用户信息
	 * @param id 用户id
	 * @return 用户实体类对象
	 */
	User selectById(int id);

}
