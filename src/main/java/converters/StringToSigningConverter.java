package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import domain.Signing;
import repositories.SigningRepository;

@Component
@Transactional
public class StringToSigningConverter implements Converter<String, Signing>{
	
	@Autowired 
	SigningRepository signingRepository;
	
	@Override 
	public Signing convert(String text) {
		Signing result;
		int id;
		
		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = signingRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}


}
