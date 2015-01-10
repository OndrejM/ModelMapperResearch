package sk.mihalyi.research.modelMapper.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sk.mihalyi.research.modelMapper.util.helpers.Mutator;

public class Company {
	private long id;
	private String name;
	private String tradeRegNumber;
	/*
	 * tradeRegNumber to tradeNum
	 *  - does not match for Standard and Strict strategy
	 *  - does match for Loose strategy
	 * tradeRegNumber to regNum
	 *  - same as to tradeNum
	 * tradeRegNumber to regNumber
	 *  - does match for Standard strategy
	 *  - does not match for Strict strategy
	 */
	
	private String vatNumber;
	private Address mainAddress;
	private Address contactAddress;
	private List<Employee> employees = new ArrayList<>();
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTradeRegNumber() {
		return tradeRegNumber;
	}
	public String getVatNumber() {
		return vatNumber;
	}
	public Address getMainAddress() {
		return mainAddress;
	}
	public Address getContactAddress() {
		return contactAddress;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public static class CompanyBuilder {
		private Company item = new Company();
		public static CompanyBuilder with() {
			return new CompanyBuilder();
		}
		public CompanyBuilder id(long id) {
			item.id = id;
			return this;
		}
		public CompanyBuilder name(String name) {
			item.name = name;
			return this;
		}
		public CompanyBuilder tradeRegNumber(String tradeRegNumber) {
			item.tradeRegNumber = tradeRegNumber;
			return this;
		}
		public CompanyBuilder vatNumber(String vatNumber) {
			item.vatNumber = vatNumber;
			return this;
		}
		public CompanyBuilder mainAddress(String street, String city, String postalCode, String country) {
			item.mainAddress = new Address(street, city, postalCode, country);
			return this;
		}
		public CompanyBuilder mainAddress(Address mainAddress) {
			item.mainAddress = mainAddress;
			return this;
		}
		public CompanyBuilder contactAddress(String street, String city, String postalCode, String country) {
			item.contactAddress = new Address(street, city, postalCode, country);
			return this;
		}
		public CompanyBuilder contactAddress(Address contactAddress) {
			item.contactAddress = contactAddress;
			return this;
		}
		public CompanyBuilder employees(Collection<Employee> employees) {
			item.employees.addAll(employees);
			return this;
		}
		public CompanyBuilder employee(Employee employee) {
			item.employees.add(employee);
			return this;
		}
		public CompanyBuilder employee(String position, String firstName, String lastName, Gender gender) {
			item.employees.add(
					new Employee(position, 
							new Person(firstName, lastName, gender)));
			return this;
		}
		public Company build() {
			return item;
		}

	}
	
	public static class CompanyMutator extends Mutator<Company> {
		protected CompanyMutator(Company mutatedInstance) {
			super(mutatedInstance);
		}

		public static CompanyMutator mutate(Company c) {
			return new CompanyMutator(c);
		}
		
		public CompanyMutator changeIdTo(long id) {
			mutatedInstance.id = id;
			return this;
		}
		
	}
}
