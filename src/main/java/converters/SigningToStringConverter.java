package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import domain.Signing;

@Component
@Transactional
public class SigningToStringConverter implements Converter<Signing,String>{
	
	@Override
	public String convert(Signing signing) {
		String result;
		if (signing == null)
			result = null;
		else
			result = String.valueOf(signing.getId());
		return result;
	}


}
