package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import domain.Annotation;

@Component
@Transactional
public class AnnotationToStringConverter implements Converter<Annotation,String>{
	
	@Override
	public String convert(Annotation annotation) {
		String result;
		if (annotation == null)
			result = null;
		else
			result = String.valueOf(annotation.getId());
		return result;
	}


}
