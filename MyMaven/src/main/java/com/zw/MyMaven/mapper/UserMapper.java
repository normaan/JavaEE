package com.zw.MyMaven.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.zw.MyMaven.dto.UserDto;
import com.zw.MyMaven.pojo.User;

/**
 * 
 * 接口描述：mapper接口
 * 作者： LiuJinrong  
 * 创建日期：2018年12月27日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */

// 通用mapper继承Mapper<T>接口

public interface UserMapper extends Mapper<User> {

	/**
	 * 
	 * 方法描述: 根据用户id查询用户信息
	 * @param id 用户id
	 * @return 用户实体类对象
	 */
	User selectById(int id);

	
	/**
	 * 
	 * 方法描述: 条件查询
	 * @param userDto
	 * @return List<User>
	 */
	List<User> selectPage(UserDto userDto);

}
