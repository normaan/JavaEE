package com.zw.zwshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zw.zwshop.dto.SysUserDto;
import com.zw.zwshop.mapper.SysUserMapper;
import com.zw.zwshop.pojo.SysUser;
import com.zw.zwshop.service.SysUserService;
import com.zw.zwshop.utils.MD5Util;
import com.zw.zwshop.utils.ToolUtil;

@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public int add(SysUser user) throws RuntimeException {
		user.setCreateTime(ToolUtil.getCurrentTime());
		/*String pwd = MD5Util.md5Password(user.getPassword()) ;//加密后的密码
		user.setPassword(pwd);*/
		return sysUserMapper.insertSelective(user);
	}

	@Override
	public PageInfo select(SysUserDto sysUserDto) {
		PageHelper.startPage(sysUserDto.getPage(), sysUserDto.getLimit());
		List<SysUser> list = sysUserMapper.selectPage(sysUserDto);
		PageInfo<SysUser> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public int delete(String[] ids) {
		return sysUserMapper.deleteBatch(ids);
	}

	@Override
	public SysUser login(SysUser sysUser) {
		return sysUserMapper.selectOne(sysUser);
	}
	
	
}
