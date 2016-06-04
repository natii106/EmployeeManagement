package pl.walasiksggw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.walasiksggw.dao.EmployeeDAO;
import pl.walasiksggw.dao.EmployeeDAOImpl;
import pl.walasiksggw.model.Employee;
import pl.walasiksggw.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

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

