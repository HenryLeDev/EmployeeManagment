package com.example.demo.Repository;

import com.example.demo.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> , PagingAndSortingRepository<Employee, Long>{
  //  List<Employee> findEmployeeByFirstNameDesc();

}
