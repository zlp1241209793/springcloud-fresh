package com.zlp.fresh.mapper;

import com.zlp.fresh.entity.MenberInfo;

public interface IMenberInfoMapper {
	/**
	 * 会员登录
	 * @param mInfo
	 * @return
	 */
	public MenberInfo login(MenberInfo mInfo);
	
	/**
	 * 会员注册
	 * @param mInfo
	 * @return
	 */
	public int reg(MenberInfo mInfo);
}
