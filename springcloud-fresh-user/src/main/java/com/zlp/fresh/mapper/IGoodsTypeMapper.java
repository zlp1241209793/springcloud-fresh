package com.zlp.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.zlp.fresh.entity.GoodsType;

public interface IGoodsTypeMapper {
	/**
	 * 查询商品种类信息
	 * @return
	 */
	public List<GoodsType> findAll();
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public String getCount();
	
	/**
	 * 分页查询
	 * @return
	 */
	public List<GoodsType> findByPage(Map<String, Object> map);
}
