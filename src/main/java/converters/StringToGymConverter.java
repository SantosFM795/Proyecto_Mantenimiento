package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import domain.Gym;
import repositories.GymRepository;

@Component
@Transactional
public class StringToGymConverter implements Converter<String, Gym>{
	
	@Autowired 
	GymRepository gymRepository;
	
	@Override 
	public Gym convert(String text) {
		Gym result;
		int id;
		
		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = gymRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}


}
