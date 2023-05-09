package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import domain.CV;

@Component
@Transactional
public class CVToStringConverter implements Converter<CV,String>{
	
	@Override
	public String convert(CV cv) {
		String result;
		if (cv == null)
			result = null;
		else
			result = String.valueOf(cv.getId());
		return result;
	}


}
