package sk.mihalyi.research.modelMapper.model;

public class Employee {
	private String position;
	private Person personalData;
	public Employee() {
	}
	Employee(String position, Person personalData) {
		this.position = position;
		this.personalData = personalData;
	}
	public String getPosition() {
		return position;
	}
	public Person getPersonalData() {
		return personalData;
	}
}
