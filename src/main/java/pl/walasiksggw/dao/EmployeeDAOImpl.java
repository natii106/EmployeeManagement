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
    SessionFactory sessionFactory;

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

        Employee employee;
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT e FROM employee e where e.name =:nameParam AND e.surname =:surnameParam");
        query.setParameter("nameParam",searchingName);
        query.setParameter("surnameParam", searchingSurname);
        if (!query.list().isEmpty()) {
            employee = (Employee) query.list().get(0);
            return employee;
        } else {
            return null;
        }


    }

}



