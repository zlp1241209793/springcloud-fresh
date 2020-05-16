package com.zlp.fresh.mapper;

import java.util.List;

import com.zlp.fresh.entity.GoodsInfo;

public interface IGoodsTypeMapper {
	/**
	 * 查询所有商品类型信息
	 * @return
	 */
	public List<GoodsInfo> finds();
}
