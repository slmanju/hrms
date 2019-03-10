package com.slmanju.hrms;

import com.slmanju.hrms.employee.model.JobPosition;
import com.slmanju.hrms.employee.model.Role;
import com.slmanju.hrms.employee.service.EmployeeService;
import com.slmanju.hrms.employee.view.EmployeeView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HrmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);
    }

    @Bean
    CommandLineRunner init(EmployeeService employeeService) {
        return args -> {
            employeeService.findAll().forEach(employeeView -> employeeService.delete(employeeView.getId()));

            employeeService.save(EmployeeView.builder()
                    .firstName("Manjula")
                    .lastName("Jayawardana")
                    .email("manjulajayawardana@gmail.com")
                    .jobPosition(JobPosition.ATL)
                    .role(Role.DEVELOPER)
                    .build());

            employeeService.save(EmployeeView.builder()
                    .firstName("Sandareka")
                    .lastName("Jayarathne")
                    .email("sadak@gmail.com")
                    .jobPosition(JobPosition.MANAGER)
                    .role(Role.MANAGER)
                    .build());
        };
    }

}
