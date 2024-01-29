package test;

import java.util.List;
import java.util.Scanner;

import dao.PersonDAO;
import model.Person;

public class Application {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		System.out.println("------Welcome-----");
		System.out.println("1 - Insert person");
		System.out.println("2 - Update person name");
		System.out.println("3 - Update person email");
		System.out.println("4 - Delete by id");
		System.out.println("5 - List all");
		System.out.println("6 - List by id");

		int options = input.nextInt();

		switch (options) {
		case 1:
			insert();
			break;
		case 2:
			updateName();
			break;
		case 3:
			updateEmail();
		case 4:
			deleteById();
			break;
		case 5:
			listAll();
			break;
		case 6:
			listById();
			break;
		default:
			break;
		}

	}

	public static void insert() {
		PersonDAO personDAO = new PersonDAO();

		System.out.println("Enter the name: ");
		String name = input.next();

		System.out.println("Enter the email: ");
		String email = input.next();

		System.out.println("Enter the age: ");
		int age = input.nextInt();

		personDAO.insert(new Person.PersonBuilder().setName(name).setEmail(email).setAge(age).build());
		menu();
	}

	private static void updateName() {
		PersonDAO personDAO = new PersonDAO();

		System.out.println("Enter the person id: ");
		int id = input.nextInt();

		System.out.println("Enter the new name: ");
		String newName = input.next();

		personDAO.updateName(new Person.PersonBuilder().setId(id).setName(newName).build());
		menu();
	}

	private static void updateEmail() {
		PersonDAO personDAO = new PersonDAO();

		System.out.print("Enter the person id: ");
		int id = input.nextInt();

		System.out.print("Enter the person email: ");
		String newEmail = input.next();

		personDAO.updateEmail(new Person.PersonBuilder().setId(id).setEmail(newEmail).build());
		menu();
	}

	private static void deleteById() {
		PersonDAO personDAO = new PersonDAO();

		System.out.print("Enter the id: ");
		int id = input.nextInt();

		personDAO.delete(id);
		menu();

	}

	private static void listAll() {
		PersonDAO personDAO = new PersonDAO();
		List<Person> persons = personDAO.listAll();

		for (Person person : persons) {
			System.out.println("ID: " + person.getId());
			System.out.println("Name: " + person.getName());
			System.out.println("Email: " + person.getEmail());
			System.out.println("Age: " + person.getAge());
			System.out.println("\n------");
		}
		menu();

	}

	private static void listById() {
		PersonDAO personDAO = new PersonDAO();

		System.out.print("Enter the id: ");
		int id = input.nextInt();

		Person person = personDAO.findById(id);

		if (person != null) {
			System.out.println("ID: " + person.getId());
			System.out.println("Name: " + person.getName());
			System.out.println("Email: " + person.getEmail());
			System.out.println("Age: " + person.getAge());
		} else {
			System.out.println("No person found with ID: " + id);
		}
		menu();

	}

}
