package top.arexstorm.resolver;

import org.springframework.web.context.request.NativeWebRequest;
import top.arexstorm.annotation.HeaderRequire;

import java.lang.annotation.Annotation;

public class BlankHeaderArgumentResolver extends BlankResolver {
	@Override
	protected Class<? extends Annotation> getAnnotation() {
		return HeaderRequire.class;
	}

	@Override
	protected String[] getParamValues(NativeWebRequest request, String name) {
		return request.getHeaderValues(name);
	}
}
