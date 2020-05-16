package com.zlp.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.zlp.fresh.entity.OrderInfo;

public interface IOrderInfoMapper {
	/**
	 * 添加订单
	 * @param orderInfo
	 * @return
	 */
	public int addOrder(OrderInfo orderInfo);

	/**
	 * 根据订单号修改订单状态
	 * @param orderInfo
	 * @return
	 */
	public int updateOrderStatus(Map<String, String> map);
	
	/**
	 * 根据用户编号查询订单
	 * @param mno
	 * @return
	 */
	public List<OrderInfo> findOrderByMno(String mno);
	
	/**
	 * 根据用户编号查询订单数量
	 * @param mno
	 * @return
	 */
	public int getCount(String mno);
	
	/**
	 * 查询今日营业额
	 * @return
	 */
	public List<Map<String, Object>> findToday();
	
	/**
	 * 查询本月营业额
	 * @return
	 */
	public List<Map<String, Object>> findMonth();
	
	/**
	 * 查询本年每季度营业额
	 * @return
	 */
	public List<Map<String, Object>> findQuarter();
	
	/**
	 * 查询本年度每月营业额
	 * @return
	 */
	public List<Map<String, Object>> findYear();
	
	/**
	 * 查询指定年份内营业额
	 * @return
	 */
	public List<Map<String, Object>> findAnnual(Map<String, Object> map);
	
	/**
	 * 查询订单中含有的所有年份
	 * @return
	 */
	public List<Map<String, Object>> findAllYear();
	
	/**
	 * 根据商品统计月营业额
	 * @return
	 */
	public List<Map<String, Object>> findMonthByGno(String gno);
}
