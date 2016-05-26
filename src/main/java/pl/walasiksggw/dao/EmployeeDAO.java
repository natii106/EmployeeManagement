package pl.walasiksggw.dao;


import pl.walasiksggw.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getListOfEmployeeFromDataBase();

    void saveToDataBase(Employee employee);

    Employee searchEmployeeByName(String searchingName, String searchingSurname);
}
