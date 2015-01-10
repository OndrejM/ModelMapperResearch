package sk.mihalyi.research.modelMapper.boundary;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import sk.mihalyi.research.modelMapper.boundary.dto.CompanyDTO;
import sk.mihalyi.research.modelMapper.model.Company;
import sk.mihalyi.research.modelMapper.model.Company.CompanyMutator;
import sk.mihalyi.research.modelMapper.util.di.Injector;

public class CompanyService {
	private ModelMapper dtoMapper = Injector.inject(ModelMapper.class, this);
	private Map<Long, Company> companyStorage = new HashMap<>();
	private long nextId = 1;
	public long createCompany(Company c) {
		long id = nextId++;
		CompanyMutator.mutate(c).changeIdTo(id);
		companyStorage.put(id, c);
		return id;
	}
	
	public Optional<CompanyDTO> findCompanyById(long id) {
		Company c = companyStorage.get(id);
		if (c != null) {
			return Optional.of(modelToDTO(c));
		} else {
			return Optional.empty();
		}
	}

	private CompanyDTO modelToDTO(Company c) {
		Company cMock = Company.CompanyBuilder.with()
				.name("Test Company")
				.tradeRegNumber("TRDREG01")
				.build();
		return dtoMapper.map(cMock, CompanyDTO.class);
	}
}
