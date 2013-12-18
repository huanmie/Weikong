package com.feetao.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.feetao.web.constants.Constants;
import com.feetao.web.service.MemberService;
import com.feetao.web.support.RequestContextHolder;
import com.feetao.web.support.RequestData;
import com.feetao.web.support.UrlContainer;

public class PrepareUtilsInterceptor implements HandlerInterceptor {

	@Resource
	private MemberService memberService;
	
	@Resource
	private UrlContainer urlContainer;

	@Resource
	private RequestContextHolder requestContextHolder;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String cookieValue = request.getParameter(Constants.COOKIEKEY);
		boolean iscoming = false;
		if(StringUtils.isBlank(cookieValue)) {
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(Constants.COOKIEKEY.equals(cookie.getName())) {
						cookieValue = cookie.getValue();
						break;
					}
				}
			}
		} else {
			iscoming = true;
			response.addCookie(new Cookie(Constants.COOKIEKEY , cookieValue));
		}
		RequestData data = urlContainer.parserCookie(cookieValue);
		//TODO 需要一个错误跳转地址
		if(data == null) return false;
		
		requestContextHolder.set(data);
		if(iscoming) 
			memberService.enterMember(data.getOpenId(), data.getUserId());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if(modelAndView != null)
			modelAndView.addObject("urlUtil"	, urlContainer.getUrls());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		requestContextHolder.remove();
	}
}
