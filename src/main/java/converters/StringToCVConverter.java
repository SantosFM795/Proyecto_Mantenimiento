package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import domain.CV;
import repositories.CVRepository;

@Component
@Transactional
public class StringToCVConverter implements Converter<String, CV>{
	
	@Autowired 
	CVRepository cvRepository;
	
	@Override 
	public CV convert(String text) {
		CV result;
		int id;
		
		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = cvRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}


}
