package com.zw.zwshop.service;

import com.github.pagehelper.PageInfo;
import com.zw.zwshop.dto.SysUserDto;
import com.zw.zwshop.pojo.SysUser;

/**   
 * @ClassName:  SysUserService   
 * @Description:TODO 管理员的服务
 * @author: lilong
 * @date:   2019年1月5日 下午4:43:51       
 */  
public interface SysUserService {

	/**     
	 * @Description:TODO 添加管理员
	 * @author: lilong
	 * @date:   2019年1月5日 下午4:54:40    
	 * @param user      
	 */  
	int add(SysUser user) throws RuntimeException;

	/**     
	 * @Description:TODO 分页+条件查询
	 * @author: lilong
	 * @date:   2019年1月7日 上午10:32:37    
	 * @param sysUserDto
	 * @return      
	 */  
	PageInfo select(SysUserDto sysUserDto);

	/**     
	 * @Description:TODO 批量删除
	 * @author: lilong
	 * @date:   2019年1月7日 下午2:20:07    
	 * @param ids
	 * @return      
	 */  
	int delete(String[] ids);

	/**     
	 * @Description:TODO 登录
	 * @author: lilong
	 * @date:   2019年1月7日 下午3:19:14    
	 * @param sysUser
	 * @return      
	 */  
	SysUser login(SysUser sysUser);

}
