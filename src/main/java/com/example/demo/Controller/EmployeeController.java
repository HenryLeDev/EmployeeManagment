package com.example.demo.Controller;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;



@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;




    //handler methode to handle list students and return mode and view
 @GetMapping("/employees")
    public String listStudents(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }



    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

      @GetMapping("/employees/{id}/{name}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model){
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "update_employee";
    }

    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee){
        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setId(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeService.updateEmployee(existingEmployee);
        return "redirect:/employees";
    }


    @GetMapping("/employees/{id}")
    public String changeVacationStatus(@PathVariable Long id) {
        Employee existingEmployee = employeeService.getEmployeeById(id);

        if(existingEmployee.isOnVacation() == true) {
            existingEmployee.setOnVacation(false);
        } else {
            existingEmployee.setOnVacation(true);
        }
        employeeService.saveEmployee(existingEmployee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/vacation")
    public String showEmployeesOnVacation(Model model) {
         List<Employee> onVacation = new ArrayList<>();

        for(Employee employee: employeeService.getAllEmployees()) {
            if(employee.isOnVacation()) {
                onVacation.add(employee);
            }
        }
        model.addAttribute("employees", onVacation);
        return "employees";
    }

    @GetMapping("/employees/sortByFirstName")
    public String sortByFirstName(Model model) {
        List<Employee> sort = new ArrayList<>();

        

        model.addAttribute("employees", sort);
        return "employees";
    }


    // login
    @GetMapping("/login")
    public String login() {
       return  "login";
    }

    // logout
    @GetMapping("/logout")
    public String logout() {
        return "login";
    }



}
