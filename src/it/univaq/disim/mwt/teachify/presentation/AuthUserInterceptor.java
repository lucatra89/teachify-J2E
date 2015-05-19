package it.univaq.disim.mwt.teachify.presentation;

import it.univaq.disim.mwt.teachify.common.spring.Utility;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

public class AuthUserInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object handler, Exception arg3) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object handler, ModelAndView arg3) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			VerifyUser vu = handlerMethod.getMethod().getAnnotation(VerifyUser.class);

			return (vu == null) || verifyUser(request, response, vu);
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	private static boolean verifyUser(HttpServletRequest request, HttpServletResponse response, VerifyUser vu) {
		Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		long id = Long.parseLong(pathVariables.get(vu.pathVariable()));
		if (id != Utility.getUser().getId()) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		} else {
			return true;
		}

	}

}
