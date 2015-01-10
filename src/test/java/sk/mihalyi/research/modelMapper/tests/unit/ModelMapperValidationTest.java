package sk.mihalyi.research.modelMapper.tests.unit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;

import sk.mihalyi.research.modelMapper.boundary.dto.CompanyDTO;
import sk.mihalyi.research.modelMapper.model.Company;
import sk.mihalyi.research.modelMapper.util.di.Injector;

public class ModelMapperValidationTest {

	@Test
	public void mapping_of_Company_to_CopmanyDTO_is_valid() {
		ModelMapper mapper = Injector.inject(ModelMapper.class, this);
		mapper.map(new Company(), CompanyDTO.class);
		try {
			mapper.validate();
		} catch (ValidationException e) {
			throw new AssertionError("Invalid mapping from Company to CompanyDTO", e);
		}
	}

}
