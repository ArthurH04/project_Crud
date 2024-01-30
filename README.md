# Intro
This is a simple CRUD application that creates a person entry in a MySQL database. This project is part of my studies to understand and implement CRUD operations.

# How to use

1. [Install](https://www.mysql.com/downloads/) MySQL
2. [Download](https://dev.mysql.com/downloads/connector/j/) JDBC driver for MySQL
3. Create a table in mySQL using the following command:
```markdown
CREATE TABLE IF NOT EXISTS person (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(60) NOT NULL,
email VARCHAR(60) NOT NULL,
age VARCHAR(3) NOT NULL
);
```

4. Create a 'connection.properties' file with the following details: 
```markdown
db.url=jdbc:mysql://localhost:port/your_database_name
db.user=your_username
db.password=your_password
```
5. Go to application.java and run!
