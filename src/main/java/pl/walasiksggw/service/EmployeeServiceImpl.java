package pl.walasiksggw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.walasiksggw.dao.EmployeeDAO;
import pl.walasiksggw.model.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;


    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    public List<Employee> getListOfEmployeeFromDataBase() {
        return employeeDAO.getListOfEmployeeFromDataBase();
    }

    @Transactional
    public void saveToDataBase(Employee employee) {
        employeeDAO.saveToDataBase(employee);
    }

    @Transactional
    public Employee searchEmployeeByName(String name, String surname) {
        return employeeDAO.searchEmployeeByName(name, surname);
    }


}

