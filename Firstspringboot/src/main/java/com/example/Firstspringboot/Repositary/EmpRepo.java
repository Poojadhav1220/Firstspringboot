package com.example.Firstspringboot.Repositary;


import com.example.Firstspringboot.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource
public interface EmpRepo extends JpaRepository<Employee,Long> {

    List<Employee> findByName(String name);
    List<Employee> findByDesignation(String desi);

    List<Employee> findBySalary(Double sal);
    List<Employee> findByNameStartsWith(String name);
    List<Employee> findByNameEndsWith(String name);
    List<Employee> findBySalaryGreaterThan(Double sal);
}
