package sk.mihalyi.research.modelMapper.model;

public class Person {
	private String firstName;
	private String lastName;
	private Gender gender;
	public Person() {
	}
	Person(String firstName, String lastName, Gender gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Gender getGender() {
		return gender;
	}
}
