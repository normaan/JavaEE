package com.zw.zw_mvnljrssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zw.zw_mvnljrssm.dto.UserDto;
import com.zw.zw_mvnljrssm.mapper.UserMapper;
import com.zw.zw_mvnljrssm.pojo.User;
import com.zw.zw_mvnljrssm.service.UserService;
/**
 * 
 * 类描述：用户业务逻辑层实现类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月28日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * 用户列表+分页+模糊查询
	 */
	@Override
	public PageInfo userList(UserDto userDto) {
		// 通用mapper分页拦截器
		PageHelper.startPage(userDto.getPageNum(), userDto.getPageSize());
		
		// 执行查询用户列表
		List<User> users = userMapper.userList(userDto);
		
		// 对Page结果进行包装
		PageInfo<User> pageInfo = new PageInfo<>(users);
		
		return pageInfo;
	}

	
	/**
	 * 根据用户id删除单条用户
	 */
	@Override
	public int userDeleteById(int id) {
		
		return userMapper.deleteByPrimaryKey(id);
	}


	/**
	 * 添加单条用户
	 */
	@Override
	public int userAdd(User user) {
		
		return userMapper.insertSelective(user);
	}


	/**
	 * 根据id查询用户信息的回显
	 */
	@Override
	public User selectUserByIdUpdateBackShow(int id) {
		
		return userMapper.selectByPrimaryKey(id);
	}


	/**
	 * 修改单条用户
	 */
	@Override
	public int userUpdate(User user) {
		
		return userMapper.updateByPrimaryKeySelective(user);
	}


	/**
	 * 根据用户id数组批量删除用户
	 */
	@Override
	public int userDeleteByIds(String[] ids) {
		
		return userMapper.userDeleteByIds(ids);
	}

}
