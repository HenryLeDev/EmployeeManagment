package com.example.demo.Service;

import com.example.demo.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(Long Id);

 //   Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);




}
