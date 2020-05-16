package com.zlp.fresh.mapper;

import java.util.List;

import com.zlp.fresh.entity.AdminInfo;


public interface IAdminInfoMapper {
	/**
	 * 管理员登录
	 * @return
	 */
	public AdminInfo login(AdminInfo af);
	
	/**
	 * 查询所有管理员
	 * @return
	 */
	public List<AdminInfo> findAll();
	
	/**
	 * 重置管理员密码
	 * @param aid
	 * @return
	 */
	public int resetPwd(String aid);
	
	/**
	 * 添加管理员
	 * @param ad
	 * @return
	 */
	public int add(AdminInfo ad);
	
	/**
	 * 查询该账号是否存在
	 * @return
	 */
	public List<AdminInfo> checkAdmin(AdminInfo ad);
}
