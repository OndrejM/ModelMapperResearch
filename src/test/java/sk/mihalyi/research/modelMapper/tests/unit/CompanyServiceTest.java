package sk.mihalyi.research.modelMapper.tests.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import sk.mihalyi.research.modelMapper.boundary.CompanyService;
import sk.mihalyi.research.modelMapper.boundary.dto.CompanyDTO;
import sk.mihalyi.research.modelMapper.model.Company;
import static sk.mihalyi.research.modelMapper.model.Gender.*;
import sk.mihalyi.research.modelMapper.tests.util.di.TestInjector;

public class CompanyServiceTest {

	@Test
	public void companyService_saves_company_and_retrieves_mapped_DTO() {
		CompanyService companyService = TestInjector.inject(CompanyService.class, this);
		Company companyModel = Company.CompanyBuilder.with()
				.name("Test Company")
				.mainAddress("Bratislavska 56", "Nitra", "94901", "SK")
				.contactAddress("Slovenska 46", "Praha", "15200", "CZ")
				.employee("CEO", "Pavel", "Novak", MALE)
				.employee("Secretary", "Ivana", "Palakyova", FEMALE)
				.tradeRegNumber("TRDREG01")
				.vatNumber("VAT784932")
				.build();
				
		long id = companyService.createCompany(companyModel);
		CompanyDTO companyDTO = companyService.findCompanyById(id).get();
		assertEquals("Name", "Test Company", companyDTO.getName());
		assertEquals("Trade num", "TRDREG01", companyDTO.getRegNum());
	}

}
