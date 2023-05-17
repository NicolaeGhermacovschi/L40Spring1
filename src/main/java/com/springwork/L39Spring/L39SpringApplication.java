package com.springwork.L39Spring;

import com.springwork.L39Spring.repository.EmployeeRepository;
import com.springwork.L39Spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L39SpringApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(L39SpringApplication.class, args);
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.saveEmployee(70, "Anton", "Anton", 58, "Chisinau", 2000, 9);
        employeeRepository.saveEmployee(71, "Anton", "Anton", 58, "Chisinau", 2000, 9);
        employeeRepository.saveEmployee(73, "Anton", "Anton", 58, "Chisinau", 2000, 9);


//        System.out.println(employeeRepository.getAllEmployee());

        System.out.println( employeeRepository.getEmployeeNameByID(55));
        System.out.println( employeeRepository.getEmployeeNameByID(56));
//        System.out.println( employeeRepository.getEmployeeNameByID(6));

//        System.out.println(employeeService.AllEmpl());
//        System.out.println(employeeService.AllEmpl());
    }
}
