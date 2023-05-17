package com.springwork.L39Spring.repository;

import com.springwork.L39Spring.model.Employee;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmployeeRepositoryDB implements EmployeeRepository {
    private static String URL = "jdbc:postgresql://localhost:5432/L39DB";
    private static String user = "postgres";
    private static String password = "admin";

    @Override
    public String getEmployeeNameByID(int id) {
        System.out.println("Getting person from DB...." + id);
        try (Connection conn = DriverManager.getConnection(URL, user, password);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Employee WHERE  employee_id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                return firstName + " " + lastName;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    @Override
    public void saveEmployee(int id, String firstName, String lastName, int age, String address,
                           int salary, int idCompany) {
        System.out.println("Saving person in Database...");
        try (Connection conn = DriverManager.getConnection(URL, user, password)){
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Employee(employee_id, first_name, last_name, age, adress, salary, company_id) VALUES(?,?,?,?,?,?,?);");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2,firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5,address);
            preparedStatement.setInt(6, salary);
            preparedStatement.setInt(7, idCompany);

            preparedStatement.execute();
            preparedStatement.close();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        System.out.println("Getting all persons from Database...");
        ArrayList<Employee> employeeArrayList = new ArrayList<>();


        try (Connection conn = DriverManager.getConnection(URL, user, password);
             Statement statement = conn.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT * FROM employee;");

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt(1));
                emp.setFirstName(rs.getString(2));
                emp.setLastName(rs.getString(3));
                emp.setAge(rs.getInt(4));
                emp.setAddress(rs.getString(5));
                emp.setSalary(rs.getInt(6));
                emp.setIdCompany(rs.getInt(7));
                employeeArrayList.add(emp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return employeeArrayList;

    }

}
