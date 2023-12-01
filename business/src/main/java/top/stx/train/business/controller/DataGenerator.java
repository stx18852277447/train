package top.stx.train.business.controller;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

public class DataGenerator {

    public static void main(String[] args) {
        int numberOfStudents = 100000;

        try (Connection connection = DatabaseConnector.getConnection()) {
            for (int i = 0; i < numberOfStudents; i++) {
                Student student = generateFakeStudent();
                insertStudentIntoDatabase(connection, student);
            }
            System.out.println("Data generation completed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Student generateFakeStudent() {
        Faker faker = new Faker(Locale.CHINA);
        Student student = new Student();
        student.setName(faker.name().fullName());
        student.setAge(faker.number().numberBetween(18, 25));
        student.setPhoneNumber(faker.phoneNumber().cellPhone());
        student.setEmail(faker.internet().emailAddress());
        student.setSchool(faker.university().name());
        return student;
    }

    private static void insertStudentIntoDatabase(Connection connection, Student student) throws SQLException {
        String sql = "INSERT INTO student (name, age, phone_number, email, school) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getPhoneNumber());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getSchool());

            preparedStatement.executeUpdate();
        }
    }
}
