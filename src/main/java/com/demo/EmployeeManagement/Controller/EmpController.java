package com.demo.EmployeeManagement.Controller;

import com.demo.EmployeeManagement.Model.Employee;
import com.demo.EmployeeManagement.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public String index(Model m) {
        List<Employee>emp=empService.getAllEmp();
        m.addAttribute("emp",emp);
        return "index";
    }
    @GetMapping("/addemp")
    public String addemp() {
        return "add_emp";
    }
    @PostMapping("/register")
    public String addEmp(@ModelAttribute Employee emp, HttpSession session){
        System.out.println(emp);
        empService.addemp(emp);
        session.setAttribute("msg", "Employee added successfully");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        Employee emp= empService.getEmpById(id);
        m.addAttribute("emp",emp);
        return "edit";
    }
    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee emp, HttpSession session){
       empService.addemp(emp);
       session.setAttribute("msg","Employee updated successfully");
       return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, HttpSession session) {
        empService.deleteEmpById(id);
        session.setAttribute("msg","Employee deleted successfully");
        return "redirect:/";
    }
}
