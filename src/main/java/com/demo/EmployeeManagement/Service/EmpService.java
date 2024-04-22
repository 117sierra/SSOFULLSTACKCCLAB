package com.demo.EmployeeManagement.Service;

import com.demo.EmployeeManagement.Model.Employee;
import com.demo.EmployeeManagement.Repository.EmpRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo empRepo;

    public void addemp(Employee employee){
        empRepo.save(employee);
    }
    public List<Employee> getAllEmp(){
        return empRepo.findAll();
    }
    public Employee getEmpById(int id){
        Optional<Employee>e = empRepo.findById(id);
        return e.orElse(null);
    }
    public void deleteEmpById(int id){
        empRepo.deleteById(id);
    }
}
