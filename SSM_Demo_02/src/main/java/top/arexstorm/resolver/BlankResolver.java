package top.arexstorm.resolver;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import top.arexstorm.exception.BizException;

import java.lang.annotation.Annotation;

public abstract class BlankResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(getAnnotation());
	}

	protected abstract Class<? extends Annotation> getAnnotation();


	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		if (binderFactory == null) {
			return null;
		}
		String name = parameter.getParameterName();
		return resolveName(name, webRequest, parameter.getParameterType());
	}

	private Object resolveName(String name, NativeWebRequest request, Class<?> c) throws Exception {
		String param = null;
		String[] paramValues = getParamValues(request, name);
		if (paramValues != null) {
			if (paramValues.length == 1) {
				param = paramValues[0];
			} else {
				throw new BizException(1, "Multiple param not support");
			}
		}
		if (StringUtils.isBlank(param)) {
			throw new BizException(2, "blank " + name + " error");
		}
		return c.getConstructor(new Class[]{String.class}).newInstance(new String[]{param});
	}

	protected abstract String[] getParamValues(NativeWebRequest request, String name);
}
