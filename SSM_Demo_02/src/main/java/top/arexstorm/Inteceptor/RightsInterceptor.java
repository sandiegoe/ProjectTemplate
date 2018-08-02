package top.arexstorm.Inteceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.arexstorm.annotation.IgnorerRights;
import top.arexstorm.exception.BizException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class RightsInterceptor implements HandlerInterceptor {

	private static List<String> whiteList;

	static {
		if (whiteList == null) {
			whiteList = new ArrayList<>();
			if (whiteList != null) {
				whiteList.add("configuration/ui");
				whiteList.add("swagger-resources");
				whiteList.add("v2/api-docs");
				whiteList.add("configuration/security");
			}
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		try {
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
			if (isInwhiteList(request.getRequestURI())) {
				System.out.println("white list ------  " + request.getRequestURI());
				return true;
			}
			String token = request.getParameter("token");
			if (StringUtils.isNotBlank(token)) { // token is not blank
				//对于token的进一步验证，或者 权限验证....
				return true;
				//throw BizException(3, "No Access...");
			}
			throw new BizException(4, "Go to login...");
		} catch (Exception e) {
			response.setHeader("Access-Control-Allow-Credentials", "true"); //解决跨域访问报错
			response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin")); //解决跨域访问报错
			throw e;
		}
	}

	private boolean isInwhiteList(String requestURI) {
		if (StringUtils.isBlank(requestURI)) {
			return false;
		}
		if (whiteList == null || whiteList.size() == 0) {
			return false;
		}
		for (String white : whiteList) {
			if (requestURI.toLowerCase().contains(white.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

}
