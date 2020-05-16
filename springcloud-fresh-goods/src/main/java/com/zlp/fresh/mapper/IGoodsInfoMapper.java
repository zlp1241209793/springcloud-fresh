package com.zlp.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.zlp.fresh.entity.GoodsInfo;

public interface IGoodsInfoMapper {
	/**
	 * 首页查询，查询每种商品类型的最新4条数据
	 * @return
	 */
	public List<GoodsInfo> finds();
	
	/**
	 * 根据商品类型分页查询
	 * @param map
	 * @return
	 */
	public List<GoodsInfo> findByType(Map<String, Object> map);
	
	/**
	 * 根据商品编号，查询商品信息
	 * @param gno
	 * @return
	 */
	public GoodsInfo findByGno(Integer gno);
	
	/**
	 * 获取总记录数的方法
	 * @param tno
	 * @return
	 */
	public int getTotal(Integer tno);
	
	/**
	 * 根据购物车编号修改商品库存的方法
	 * @param cno
	 * @return
	 */
	public int updateStore(String[] cno);
}
