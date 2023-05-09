package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Activity;

@Component
@Transactional
public class CreditCardToStringConverter implements Converter<Activity,String>{
	
	@Override
	public String convert(Activity exam) {
		String result;
		if (exam == null)
			result = null;
		else
			result = String.valueOf(exam.getId());
		return result;
	}


}
