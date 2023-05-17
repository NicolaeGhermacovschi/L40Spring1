package com.springwork.L39Spring.repository;

import com.springwork.L39Spring.model.Employee;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
@Component
public class EmployeeRepositoryFile implements EmployeeRepository {
    @Override
    public String getEmployeeNameByID(int id) {
        System.out.println("Getting person from File...." + id);
        return null;
    }

    @Override
    public void saveEmployee(int id, String firstName, String lastName, int age, String address, int salary, int idCompany) {
        System.out.println("Saving person in File.. "
                + id + " " + firstName + " " + lastName + " " + age + " " + address + " " + salary + " " +  idCompany);
        try {
            File fileDB = new File("FileDB.txt");
            if(fileDB.exists()){
                if(fileDB.createNewFile()){
                    System.out.println("is creeted " + fileDB.getName());
                }
                System.out.println("FIle exist");

            }
            if(fileDB.exists()){
                FileWriter myWriterData = new FileWriter("FileDB.txt");
                myWriterData.write(id + " " + firstName + " " + lastName + " " + age + " " + address
                        + " " + salary + " " +  idCompany);

                myWriterData.close();

            } else {
                System.out.println("file not exist");
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Employee> getAllEmployee() {
        System.out.println("Getting all persons from File...");

        return null;
    }
}





























