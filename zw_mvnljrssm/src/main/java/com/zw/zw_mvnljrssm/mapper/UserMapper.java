package com.zw.zw_mvnljrssm.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.zw.zw_mvnljrssm.dto.UserDto;
import com.zw.zw_mvnljrssm.pojo.User;

/**
 * 
 * 类描述：用户映射mapper接口
 * 作者： LiuJinrong  
 * 创建日期：2018年12月28日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public interface UserMapper extends Mapper<User> {

	/**
	 * 
	 * 方法描述: 用户列表+分页+模糊查询
	 * @param userDto
	 * @return
	 */
	List<User> userList(UserDto userDto);

	
	/**
	 * 
	 * 方法描述: 根据用户id数组批量删除用户
	 * @param ids 用户id数组
	 * @return 影响行数
	 */
	int userDeleteByIds(String[] ids);
	

}
