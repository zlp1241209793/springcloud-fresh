package com.zlp.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.zlp.fresh.entity.OrderItemInfo;

public interface IOrderItemInfoMapper {
	/**
	 * 添加订单详情
	 * @param list
	 * @return
	 */
	public int addOrderItem(List<OrderItemInfo> list);

	/**
	 * 根据订单号修改订单详情状态
	 * @param list
	 * @return
	 */
	public int updateOrderItemStatus(Map<String, String> map);
}
