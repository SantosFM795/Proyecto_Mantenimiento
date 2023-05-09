package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import domain.Manager;
import repositories.ManagerRepository;

@Component
@Transactional
public class StringToManagerConverter implements Converter<String, Manager>{
	
	@Autowired 
	ManagerRepository managerRepository;
	
	@Override 
	public Manager convert(String text) {
		Manager result;
		int id;
		
		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = managerRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}


}
