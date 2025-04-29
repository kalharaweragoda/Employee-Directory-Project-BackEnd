package edu.icet.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;
import edu.icet.repository.EmployeeRepository;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    final EmployeeRepository repository;

    @Override
    public void addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employee.getName());
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setDepartment(employee.getDepartment());
        employeeEntity.setCreatedAt(employee.getCreatedAt());
        employeeEntity.setUpdatedAt(employee.getUpdatedAt());
        repository.save(employeeEntity);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        List<EmployeeEntity> allEntityList = repository.findAll();
        allEntityList.forEach(entity -> {
            employeeList.add(new ObjectMapper().convertValue(entity, Employee.class));
        });

        return employeeList;

    }

    @Override
    public void deleteEmployeeById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (repository.findById(employee.getId()).isPresent()) {
            repository.save(new ObjectMapper().convertValue(employee, EmployeeEntity.class));
        }
    }

}
