package com.feetao.web.service;

import java.util.List;

import com.feetao.web.vo.ItemVO;

public interface ItemService {

	public List<ItemVO> getItemList(Long userId);
}
