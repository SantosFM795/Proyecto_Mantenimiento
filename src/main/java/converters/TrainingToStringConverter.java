package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Training;

@Component
@Transactional
public class TrainingToStringConverter implements Converter<Training,String>{
	
	@Override
	public String convert(Training training) {
		String result;
		if (training == null)
			result = null;
		else
			result = String.valueOf(training.getId());
		return result;
	}


}
