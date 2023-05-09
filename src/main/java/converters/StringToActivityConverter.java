package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import domain.Activity;
import repositories.ActivityRepository;

@Component
@Transactional
public class StringToActivityConverter implements Converter<String, Activity>{
	
	@Autowired 
	ActivityRepository activityRepository;
	
	@Override 
	public Activity convert(String text) {
		Activity result;
		int id;
		
		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = activityRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}


}
