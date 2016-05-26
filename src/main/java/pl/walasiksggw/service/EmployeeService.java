package pl.walasiksggw.service;

import pl.walasiksggw.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getListOfEmployeeFromDataBase();

    void saveToDataBase(Employee employee);

    Employee searchEmployeeByName(String name, String surname);
}
