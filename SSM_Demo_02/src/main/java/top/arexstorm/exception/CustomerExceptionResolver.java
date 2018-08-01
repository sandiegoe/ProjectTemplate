package top.arexstorm.exception;

import com.alibaba.fastjson.JSON;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import top.arexstorm.response.AppResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		AppResponse appResponse = new AppResponse();
		if (ex instanceof BizException) {
			resolveBizException(appResponse, ex);
		} else if (ex instanceof BindException) {
			resolveBindException(appResponse, ex);
		} else {
			resolveOtherException(appResponse, ex);
		}
		ex.printStackTrace();

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding("UtF-8");
		response.setHeader("Cache-Control", "no-cache,must-revalidate");
		try {
			response.getWriter().write(JSON.toJSONString(appResponse));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("与客户端通讯异常: " + e.getMessage() + "\t\t" + e);
		}

		return new ModelAndView();
	}

	private void resolveOtherException(AppResponse appResponse, Exception ex) {
		appResponse.setMessage("其它异常");
		appResponse.setData(ex.getMessage());
	}

	private void resolveBindException(AppResponse appResponse, Exception ex) {
		BindException bindException = (BindException) ex;
		List<FieldError> allErrors = bindException.getBindingResult().getFieldErrors();
		StringBuilder sb = new StringBuilder();
		for (FieldError error : allErrors) {
			sb.append(error.getObjectName()).append("对象的").append(error.getField())
					.append("字段").append(error.getDefaultMessage());
		}
		appResponse.setMessage("参数绑定异常");
		appResponse.setData(sb.toString());
	}

	private void resolveBizException(AppResponse appResponse, Exception ex) {
		BizException bizException = (BizException) ex;
		appResponse.setCode(bizException.getCode());
		appResponse.setMessage("业务异常");
		appResponse.setData(bizException.getMessage());
	}
}
