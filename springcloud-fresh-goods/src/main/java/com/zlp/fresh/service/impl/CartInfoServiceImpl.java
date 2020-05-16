package com.zlp.fresh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlp.fresh.entity.CartInfo;
import com.zlp.fresh.mapper.ICartInfoMapper;
import com.zlp.fresh.service.ICartInfoService;
import com.zlp.fresh.util.StringUtil;

@Service
public class CartInfoServiceImpl implements ICartInfoService {
	@Autowired
	private ICartInfoMapper cartInfoMapper;

	@Override
	public String add(CartInfo cartInfo) {
		if (StringUtil.checkNull(String.valueOf(cartInfo.getGno()), String.valueOf(cartInfo.getMno()), String.valueOf(cartInfo.getNum()))) {
			return "0";
		}
		String cno = UUID.randomUUID().toString().replace("-", "");
		cartInfo.setCno(cno);
		System.out.println(cartInfo);
		if (cartInfoMapper.add(cartInfo) > 0) {
			return cno;
		}
		return "0";
	}

	@Override
	public List<Map<String, Object>> findByMno(Integer mno) {
		return cartInfoMapper.findByMno(mno);
	}

	@Override
	public List<CartInfo> finds(Integer mno) {
		return cartInfoMapper.finds(mno);
	}

	@Override
	public List<CartInfo> findByCnos(String[] cnos) {
		return cartInfoMapper.findByCnos(cnos);
	}

	@Override
	public int delete(String[] cnos) {
		if (cnos == null || cnos.length <= 0) {
			return -1;
		}
		return cartInfoMapper.delete(cnos);
	}

	@Override
	public int deleteByCno(String cno) {
		if (StringUtil.checkNull(cno)) {
			return -1;
		}
		return cartInfoMapper.deleteByCno(cno);
	}

	@Override
	public int update(CartInfo cf) {
		return cartInfoMapper.update(cf);
	}
}
