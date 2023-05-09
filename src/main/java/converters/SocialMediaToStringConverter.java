package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import domain.SocialMedia;

@Component
@Transactional
public class SocialMediaToStringConverter implements Converter<SocialMedia,String>{
	
	@Override
	public String convert(SocialMedia socialMedia) {
		String result;
		if (socialMedia == null)
			result = null;
		else
			result = String.valueOf(socialMedia.getId());
		return result;
	}


}
