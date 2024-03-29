package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import domain.Trainer;
import repositories.TrainerRepository;

@Component
@Transactional
public class StringToTrainerConverter implements Converter<String, Trainer>{
	
	@Autowired 
	TrainerRepository trainerRepository;
	
	@Override 
	public Trainer convert(String text) {
		Trainer result;
		int id;
		
		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = trainerRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}


}
