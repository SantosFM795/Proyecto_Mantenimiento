package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import domain.SocialMedia;
import repositories.SocialMediaRepository;

@Component
@Transactional
public class StringToSocialMediaConverter implements Converter<String, SocialMedia>{
	
	@Autowired 
	SocialMediaRepository socialMediaRepository;
	
	@Override 
	public SocialMedia convert(String text) {
		SocialMedia result;
		int id;
		
		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = socialMediaRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}


}
