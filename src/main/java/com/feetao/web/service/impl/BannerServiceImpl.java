package com.feetao.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.feetao.web.dao.BannerDao;
import com.feetao.web.model.BannerDO;
import com.feetao.web.service.BannerService;
import com.feetao.web.utils.Convert;
import com.feetao.web.vo.BannerVO;

public class BannerServiceImpl implements BannerService {

	@Resource
	private BannerDao bannerDao;
	
	@Override
	public List<BannerVO> getBannerList(Long userId) {
		List<BannerDO> list = bannerDao.getBannerList(userId);
		if(list != null && list.size() > 0) {
			ArrayList<BannerVO> result = new ArrayList<BannerVO>();
			for(int i = 0 ; i < list.size() ; i++) 
				result.add(Convert.convert(BannerVO.class , list.get(i)));
			return result;
		}
		return null;
	}

}
