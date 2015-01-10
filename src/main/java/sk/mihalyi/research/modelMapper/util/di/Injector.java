package sk.mihalyi.research.modelMapper.util.di;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import sk.mihalyi.research.modelMapper.boundary.CompanyService;
import sk.mihalyi.research.modelMapper.util.exceptions.Defect;

public class Injector {

	@SuppressWarnings("unchecked")
	public static <T> T inject(Class<T> ofClass, Object receiver) {
		Object result = null;
		if (ModelMapper.class.equals(ofClass)) {
			ModelMapper mapper = new ModelMapper();
			//mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			result = mapper;
		} else if (CompanyService.class.equals(ofClass)) {
			result = new CompanyService();
		} else {
			throw new Defect();
		}
		return (T)result;
	}
	
}
