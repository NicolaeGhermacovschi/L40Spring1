package com.springwork.L39Spring.repository;

import com.springwork.L39Spring.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    String getEmployeeNameByID(int id);

    void saveEmployee(int id, String firstName, String lastName, int age, String address, int salary, int idCompany);
    List<Employee> getAllEmployee();
}
