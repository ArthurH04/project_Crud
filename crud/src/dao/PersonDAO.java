package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infra.ConnectionFactory;
import model.Person;

public class PersonDAO implements IPersonDAO {

	public Person insert(Person person) {

		Connection connection = ConnectionFactory.getConnection();

		String sql = "INSERT INTO person (name, email, age) VALUES (?, ?, ?)";

		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, person.getName());
			pStatement.setString(2, person.getEmail());
			pStatement.setInt(3, person.getAge());

			pStatement.executeUpdate();

			System.out.println("------Person inserted with success!------");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return person;
	}

	public Person updateName(Person person) {
		Connection connection = ConnectionFactory.getConnection();

		String sql = "UPDATE person SET name = ? WHERE id = ?";

		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, person.getName());
			pStatement.setInt(2, person.getId());

			pStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person;
	}

	public Person updateEmail(Person person) {
		Connection connection = ConnectionFactory.getConnection();

		String sql = "UPDATE person SET email = ? WHERE id = ?";

		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, person.getEmail());
			pStatement.setInt(2, person.getId());

			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person;
	}

	public void delete(int id) {
		Connection connection = ConnectionFactory.getConnection();

		String sql = "DELETE FROM person WHERE id = ?";

		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);

			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Person> listAll() {
		List<Person> persons = new ArrayList<>();

		Connection connection = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM person";

		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				int age = resultSet.getInt("age");

				  Person person = new Person.PersonBuilder()
					        .setId(id)
					        .setName(name)
					        .setEmail(email)
					        .setAge(age)
					        .build();
				persons.add(person);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return persons;
	}

	public Person findById(int id) {
		Connection connection = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM person WHERE id = ? ";
		
		Person person = null;
		try {
			PreparedStatement pStatement;
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);

			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				int idResult = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				int age = resultSet.getInt("age");

				 person = new Person.PersonBuilder()
				        .setId(idResult)
				        .setName(name)
				        .setEmail(email)
				        .setAge(age)
				        .build();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}

}
