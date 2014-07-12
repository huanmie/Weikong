package com.feetao.web.service;

import java.util.List;

import com.feetao.web.vo.BannerVO;

public interface BannerService {

	public List<BannerVO> getBannerList(Long userId);
}
