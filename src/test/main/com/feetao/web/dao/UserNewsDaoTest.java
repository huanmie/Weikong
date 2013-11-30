package com.feetao.web.dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.feetao.web.model.UserNewsDO;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:applicationContext.xml") 
public class UserNewsDaoTest {

	@Resource
	private UserNewsDao userNewsDao;
	
	@Test 
	 public void testGetOnlineList() { 
		ArrayList<UserNewsDO> list = userNewsDao.getOnlineList(10000L);
		System.out.println(list.size());
	 } 

}
