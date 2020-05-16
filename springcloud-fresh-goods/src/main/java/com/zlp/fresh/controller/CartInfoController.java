package com.zlp.fresh.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlp.fresh.entity.CartInfo;
import com.zlp.fresh.entity.MenberInfo;
import com.zlp.fresh.service.ICartInfoService;

@RestController
@RequestMapping("/cart")
public class CartInfoController {
	@Autowired
	private ICartInfoService cartInfoService;
	
	private MenberInfo getMenberInfo(HttpSession session) {
		Object object = session.getAttribute("loginMember");
		if (object == null) { // 说明没有登录
			return null;
		}
		return (MenberInfo) object;
	}
	
	@RequestMapping("/getInfo")
	public List<Map<String, Object>> getInfo(HttpSession session) {
		MenberInfo mf = this.getMenberInfo(session);
		if (mf == null) { // 说明没有登录 
			return Collections.emptyList();
		}
		return cartInfoService.findByMno(mf.getMno()); // 根据会员编号查询购物车信息
	}
	
	@RequestMapping("/update")
	public int update(CartInfo cf) {
		cf.setNum(1);
		return cartInfoService.update(cf);
	}
	
	@RequestMapping("/updates")
	public int updates(CartInfo cf) {
		return cartInfoService.update(cf);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/add")
	public String add(HttpSession session, CartInfo cf) {
		String cno = cartInfoService.add(cf);
		if (!"0".equals(cno)) { // 说明加入购物车成功
			Object obj = session.getAttribute("cartInfos");
			if (obj != null) {
				List<Map<String, Object>> list = (List<Map<String, Object>>) obj;
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("cno", cno);
				map.put("gno", cf.getGno());
				list.add(map);
			}
		}
		return cno;
	}
	
	@RequestMapping("/finds")
	public List<CartInfo> finds(HttpSession session) {
		MenberInfo mf = this.getMenberInfo(session);
		if (mf == null) { // 说明没有登录
			return null;
		}
		return cartInfoService.finds(mf.getMno());
	}
	
	@RequestMapping("/del")
	public int del(String cno, HttpSession session) {
		return cartInfoService.deleteByCno(cno);
	}
	
	@RequestMapping("/findByCnos")
	public List<CartInfo> findByCnos(String cnos) {
		return cartInfoService.findByCnos(cnos.split(","));
	}
}
