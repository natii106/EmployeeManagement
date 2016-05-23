package pl.walasiksggw.cba.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
    public class EmployeeImpl implements Employee {
        @Autowired
        private EmployeeDAO employeeDAO;
        @Transactional
        public List<EmployeeModel> getListOfEmployeeFromDataBase() {
            return employeeDAO.getListOfEmployeeFromDataBase();
        }
        @Transactional
        public void saveToDataBase(EmployeeModel employee) {
            employeeDAO.saveToDataBase(employee);
        }
        @Transactional
        public EmployeeModel searchEmployeeByName(String name, String surname) {
            return employeeDAO.searchEmployeeByName(name,surname);
        }
    }

