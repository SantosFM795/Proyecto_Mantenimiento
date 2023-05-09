package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import domain.Annotation;
import repositories.AnnotationRepository;

@Component
@Transactional
public class StringToAnnotationConverter implements Converter<String, Annotation>{
	
	@Autowired 
	AnnotationRepository annotationRepository;
	
	@Override 
	public Annotation convert(String text) {
		Annotation result;
		int id;
		
		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = annotationRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}


}
