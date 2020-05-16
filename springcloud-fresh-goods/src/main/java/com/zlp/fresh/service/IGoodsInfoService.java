package com.zlp.fresh.service;

import java.util.List;
import java.util.Map;

import com.zlp.fresh.entity.GoodsInfo;

public interface IGoodsInfoService {
	/**
	 * 首页查询，查询每种类型商品的最新4条数据以及所有的商品类型信息
	 * @return
	 */
	public Map<String, Object> finds();
	
	/**
	 * 根据商品类型分页查询
	 * @param map
	 * @return
	 */
	public List<GoodsInfo> findByType(Map<String, Object> map);
	
	/**
	 * 第一次根据商品类型分页查询
	 * @param map
	 * @return
	 */
	public Map<String, Object> findByFirst(Map<String, Object> map);
	
	/**
	 * 根据商品编号，查询商品信息
	 * @param gno
	 * @return
	 */
	public GoodsInfo findByGno(Integer gno);
}
