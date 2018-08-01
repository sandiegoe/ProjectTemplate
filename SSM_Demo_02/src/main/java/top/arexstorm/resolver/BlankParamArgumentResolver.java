package top.arexstorm.resolver;


import org.springframework.web.context.request.NativeWebRequest;
import top.arexstorm.annotation.ParamRequire;

import java.lang.annotation.Annotation;

public class BlankParamArgumentResolver extends BlankResolver {

	@Override
	protected Class<? extends Annotation> getAnnotation() {
		return ParamRequire.class;
	}

	@Override
	protected String[] getParamValues(NativeWebRequest request, String name) {
		return request.getParameterValues(name);
	}
}
