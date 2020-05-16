package com.zlp.fresh.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlp.fresh.entity.MenberInfo;
import com.zlp.fresh.service.ICartInfoService;
import com.zlp.fresh.util.ResponseUtil;

@RestController
@RequestMapping("/member")
public class MenberInfoController {
	@Autowired
	private ICartInfoService cartInfoService;
	
	/**
	 * 检验用户有没有登录
	 * @param session
	 * @return
	 */
	@RequestMapping("/check")
	public Map<String, Object> checkLogin(HttpSession session) {
		Object object = session.getAttribute("loginMember");
		if (object == null) {
			return ResponseUtil.responseMap(500, null, null);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member", object);
		MenberInfo mf = (MenberInfo) object;
		map.put("carts", cartInfoService.findByMno(mf.getMno()));
		
		return ResponseUtil.responseMap(200, null, map);
	}
}
