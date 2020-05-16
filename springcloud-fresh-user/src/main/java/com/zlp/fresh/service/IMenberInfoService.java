package com.zlp.fresh.service;

import com.zlp.fresh.entity.MenberInfo;

public interface IMenberInfoService {
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
