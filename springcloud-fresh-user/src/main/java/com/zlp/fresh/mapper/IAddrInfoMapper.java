package com.zlp.fresh.mapper;

import java.util.List;

import com.zlp.fresh.entity.AddrInfo;

public interface IAddrInfoMapper {
	/**
	 * 添加收货地址
	 * @param addrInfo
	 * @return
	 */
	public int addAddr(AddrInfo addrInfo);
	
	/**
	 * 通过用户id查找用户的收货地址
	 * @param mno
	 * @return
	 */
	public List<AddrInfo> findAddrByMno(String mno);
	
	/**
	 * 设置用户默认收货地址
	 * @param ano
	 * @return
	 */
	public int setFlag(AddrInfo addrInfo);
}
