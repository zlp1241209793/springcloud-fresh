package com.zlp.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.zlp.fresh.entity.CartInfo;

public interface ICartInfoMapper {
	/**
	 * 加入购物车的方法
	 * @param cartInfo
	 * @return
	 */
	public int add(CartInfo cartInfo);
	
	/**
	 * 根据会员编号查询购物车信息
	 * @param mno
	 * @return
	 */
	public List<Map<String, Object>> findByMno(Integer mno);
	
	/**
	 * 根据会员编号查询购物车详细信息
	 * @param mno
	 * @return
	 */
	public List<CartInfo> finds(Integer mno);
	
	/**
	 * 根据购物车编号查询购物车详细信息
	 * @param cnos
	 * @return
	 */
	public List<CartInfo> findByCnos(String[] cnos);
	
	/**
	 * 同时删除多条购物车信息
	 * @param cnos
	 * @return
	 */
	public int delete(String[] cnos);
	
	/**
	 * 根据购物车编号删除购物车信息
	 * @param cno
	 * @return
	 */
	public int deleteByCno(String cno);
	
	/**
	 * 修改购物车信息，主要是修改数量
	 * @param cf
	 * @return
	 */
	public int update(CartInfo cf);
	
	/**
	 * 根据会员编号和商品编号修改
	 * @param cf
	 * @return
	 */
	public int updateByMnoAndGno(CartInfo cf);
}
