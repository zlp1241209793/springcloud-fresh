package com.zlp.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.zlp.fresh.entity.GoodsInfo;

public interface IGoodsInfoMapper {
	
	/**
	 * 修改商品图片
	 * @return
	 */
	public int updatePic(Map<String, String> map);
	
	/**
	 * 添加商品
	 * @param goodsInfo
	 * @return
	 */
	public int addGood(GoodsInfo goodsInfo);
	
	/**
	 * 通过tno查询该类商品的数量
	 * @param tno
	 * @return
	 */
	public String getCount(String tno);
	
	/**
	 * 通过tno分页查询
	 * @param map
	 * @return
	 */
	public List<GoodsInfo> findByPage(Map<String, Object> map);
	
	/**
	 * 查询所有商品
	 * @return
	 */
	public List<GoodsInfo> findAll();
	
	/**
	 * 根据商品ID查询商品详情
	 * @return
	 */
	public GoodsInfo findByGno(String gno);
	
	/**
	 * 修改商品库存
	 * @param map
	 * @return
	 */
	public int updateBalance(List<Map<String, String>> list);
	
	/**
	 * 根据商品类型查询商品
	 * @param tno
	 * @return
	 */
	public List<GoodsInfo> findByTno(String tno);
	
	/**
	 * 查询所有商品(创建索引用)
	 * @return
	 */
	public List<Map<String, Object>> findAllGoods();
}
