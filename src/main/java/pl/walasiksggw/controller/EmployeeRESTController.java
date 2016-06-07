package pl.walasiksggw.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.walasiksggw.service.EmployeeService;
import pl.walasiksggw.model.Employee;
import java.util.List;

@RestController
@ComponentScan(basePackages = {("pl.walasiksggw.service")})
public class EmployeeRESTController {

    @Autowired
    EmployeeService employeeService;

        @RequestMapping(value="/list", method= RequestMethod.GET)
        public List<Employee> getListOfEmployee() {
            return employeeService.getListOfEmployeeFromDataBase();
        }

        @RequestMapping(value = "/add", method = RequestMethod.POST)
        public void saveEmployeeToDatabase(@RequestBody Employee employee) {
            employeeService.saveToDataBase(employee);
        }

        @RequestMapping(value = "/search/{name}/{surname}", method = RequestMethod.GET)
        public Employee searchEmployee(@PathVariable("name") String name, @PathVariable("surname") String surname) {
            Employee employee = employeeService.searchEmployeeByName(name, surname);
            if (employee == null) {
                System.out.println("User not found");
                return null;
            }
            return employee;
        }


    }
