package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import domain.Training;
import repositories.TrainingRepository;

@Component
@Transactional
public class StringToTrainingConverter implements Converter<String, Training>{
	
	@Autowired 
	TrainingRepository trainingRepository;
	
	@Override 
	public Training convert(String text) {
		Training result;
		int id;
		
		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = trainingRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}


}
