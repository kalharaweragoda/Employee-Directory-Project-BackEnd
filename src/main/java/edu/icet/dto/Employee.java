package edu.icet.dto;

import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor
public class Employee {
    final EmployeeService service;

    @PostMapping("add-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }
}
