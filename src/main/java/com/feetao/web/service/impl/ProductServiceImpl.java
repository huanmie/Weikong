package com.feetao.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import com.feetao.web.dao.ProductDao;
import com.feetao.web.model.ProductDO;
import com.feetao.web.service.ProductService;
import com.feetao.web.vo.ProductVO;

public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductDao productDao;

	@Override
	public List<ProductVO> getProductList(Long userId) {
		List<ProductDO> list = productDao.getProductList(userId);
		if(list != null && list.size() > 0) {
			ArrayList<ProductVO> result = new ArrayList<ProductVO>();
			for(int i = 0 ; i < list.size() ; i++) 
				result.add(convert(list.get(i)));
			return result;
		}
		return null;
	}
	
	@Override
	public List<ProductVO> getProductList(Long userId , List<Long> ids) {
		if(ids == null || ids.size() == 0) return null;
		List<ProductDO> list = productDao.getProductList(userId , ids);
		if(list != null && list.size() > 0) {
			ArrayList<ProductVO> result = new ArrayList<ProductVO>();
			for(int i = 0 ; i < list.size() ; i++) 
				result.add(convert(list.get(i)));
			return result;
		}
		return null;
	}
	
	private ProductVO convert(ProductDO pdo) {
		ProductVO product = new ProductVO();
		BeanUtils.copyProperties(pdo, product);
//		article.setLink(urlContainer.createPluginLink(article.getPlugin(), article.getId()));
		return product;
	}
}
