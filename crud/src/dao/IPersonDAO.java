package dao;

import java.util.List;

import model.Person;

public interface IPersonDAO {
	
	Person insert(Person person);
	Person updateName(Person person);
	Person updateEmail(Person person);
	void delete (int id);
	List<Person> listAll();
	Person findById(int id);
	
}
