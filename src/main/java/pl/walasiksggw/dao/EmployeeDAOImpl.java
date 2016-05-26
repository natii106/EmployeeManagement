package pl.walasiksggw.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.walasiksggw.model.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Employee> getListOfEmployeeFromDataBase() {
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT e FROM employee e");
        return (List<Employee>) query.list();
    }

    @Transactional
    public void saveToDataBase(Employee employee) {
        this.sessionFactory.getCurrentSession().save(employee);
    }

    @Transactional
    public Employee searchEmployeeByName(String searchingName, String searchingSurname) {

        Employee employeeModel;
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT e from employee AS e where name =:name AND surname =:surname");
        query.setParameter("name", searchingName);
        query.setParameter("surname", searchingSurname);
        if (!query.list().isEmpty()) {
            employeeModel = (Employee) query.list().get(0);
            return employeeModel;
        } else {
            return null;
        }


    }
}

