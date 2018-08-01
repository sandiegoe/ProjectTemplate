package top.arexstorm.Inteceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.arexstorm.annotation.IgnorerRights;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RightsInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("start url " + request.getRequestURI() + " ...");
		if (!(handler instanceof HandlerMethod)) { // 非handlerMethod 直接放行
			System.out.println("ignore option url... " + request.getRequestURI());
			System.out.println("ignore option method ... " + handler);
			return true;
		}
		HandlerMethod method = (HandlerMethod) handler;
		if (method.getMethodAnnotation(IgnorerRights.class) != null){ // 免登陆接口
			System.out.println("do not need option url... " + request.getRequestURI());
			return true;
		}
		String token = request.getParameter("token");
		if (StringUtils.isBlank(token)) {
			System.out.println("token is blank....");
			return false;
		}
		//对于token的进一步验证，或者 权限验证....

		return true;
	}

}
