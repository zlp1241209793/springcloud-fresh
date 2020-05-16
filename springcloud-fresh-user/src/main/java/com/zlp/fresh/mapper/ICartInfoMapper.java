package com.zlp.fresh.mapper;

import java.util.List;

import com.zlp.fresh.entity.CartInfo;

public interface ICartInfoMapper {
	/**
	 * 加入购物车的方法
	 * @param cartInfo
	 * @return
	 */
	public int add(CartInfo cartInfo);
	
	/**
	 * 查找购物车中该商品是否已经存在
	 * @param cartInfo
	 * @return
	 */
	public CartInfo search(CartInfo cartInfo);

	/**
	 * 修改商品数量
	 * @param cartInfo
	 * @return
	 */
	public int updateNum(CartInfo cartInfo);
	
	/**
	 * 通过用户编号查询用户的购物车
	 * @param cartInfo
	 * @return
	 */
	public List<CartInfo> findByMno(CartInfo cartInfo);
	
	/**
	 * 通过购物车编号查询用户的购物车
	 * @param cartInfo
	 * @return
	 */
	public List<CartInfo> findByCno(List<String> list);
	
	/**
	 * 通过购物车编号删除购物车商品
	 * @param cartInfo
	 * @return
	 */
	public int delGoods(List<String> list);
}
