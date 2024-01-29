package model;

public class Person {

	private String name;
	private String email;
	private int age;
	private int id;

	private Person(int id, String name, String email, int age) {
	    this.id = id;
	    this.name = name;
	    this.email = email;
	    this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public static class PersonBuilder {
		private String name;
		private String email;
		private int age;
		private int id;
		
		public PersonBuilder setId(int id) {
			this.id = id;
			return this;
		}

		public PersonBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public PersonBuilder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public PersonBuilder setAge(int age) {
			this.age = age;
			return this;
		}
		
		 public Person build() {
	            return new Person(id, name, email, age);
	        }
	}
}
