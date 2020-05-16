package com.zlp.fresh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlp.fresh.entity.MenberInfo;
import com.zlp.fresh.mapper.IMenberInfoMapper;
import com.zlp.fresh.service.IMenberInfoService;
import com.zlp.fresh.util.StringUtil;

@Service
public class MenberInfoServiceImpl implements IMenberInfoService {
	@Autowired
	private IMenberInfoMapper menberInfoMapper;

	@Override
	public MenberInfo login(MenberInfo mInfo) {
		if (StringUtil.checkNull(mInfo.getNickName(), mInfo.getPwd())) {
			return null;
		}
		return menberInfoMapper.login(mInfo);
	}

	@Override
	public int reg(MenberInfo mInfo) {
		if (StringUtil.checkNull(mInfo.getNickName(), mInfo.getEmail(), mInfo.getPwd())) {
			return -1;
		}
		return menberInfoMapper.reg(mInfo);
	}
}
