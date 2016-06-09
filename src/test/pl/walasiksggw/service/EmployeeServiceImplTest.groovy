package pl.walasiksggw.service

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.Transaction
import org.hibernate.cfg.Configuration
import pl.walasiksggw.dao.EmployeeDAOImpl
import pl.walasiksggw.model.Employee
import spock.lang.Specification

class EmployeeServiceImplTest extends Specification {
    EmployeeDAOImpl employeeDAO=new EmployeeDAOImpl();
    SessionFactory sessionFactory=new Configuration().configure("databaseConfigTests.xml").buildSessionFactory();
    EmployeeServiceImpl employeeService= new EmployeeServiceImpl();
    Employee employee= new Employee();


    def "Get List Of Employee From DataBase "() {
        given:
        Session session= sessionFactory.getCurrentSession();
        Transaction trx =session.beginTransaction();
        employeeDAO.setSessionFactory(sessionFactory);
        employeeDAO.setSessionFactory(sessionFactory);
        employeeService.setEmployeeDAO(employeeDAO);

        when: "Get from database"
        List<Employee> list= employeeService.getListOfEmployeeFromDataBase();
        trx.commit();
        then: "The database is empty"
        list.size() == 0;
    }

    def "Save Employee To DataBase"() {
        given:
        Session session= sessionFactory.getCurrentSession();
        Transaction trx =session.beginTransaction();
        employeeDAO.setSessionFactory(sessionFactory);
        employeeDAO.setSessionFactory(sessionFactory);
        employeeService.setEmployeeDAO(employeeDAO);

        when: "Employee creating"
        employee.setName("Jan");
        employee.setSurname("Kowalski");
        employee.setPosition("manager");
        employee.setSalary(3500);
        employee.setSalaryPerHour(40);
        employee.setNumberOfHoursPerMonth(80);
        employee.setOvertime(10);
        employeeService.saveToDataBase(employee);
        List<Employee> list= employeeService.getListOfEmployeeFromDataBase();
        trx.commit();
        then: "The database should have added employee"
        list.size() == 1;
        list.get(0).name=="Jan";

    }

    def "Search Employee By Name"() {
        given:
        Session session= sessionFactory.getCurrentSession();
        Transaction trx =session.beginTransaction();
        employeeDAO.setSessionFactory(sessionFactory);
        employeeDAO.setSessionFactory(sessionFactory);
        employeeService.setEmployeeDAO(employeeDAO);

        when: "Employee creating"
        employee.setName("Jan");
        employee.setSurname("Kowalski");
        employee.setPosition("manager");
        employee.setSalary(3500);
        employee.setSalaryPerHour(40);
        employee.setNumberOfHoursPerMonth(80);
        employee.setOvertime(10);
        employeeService.saveToDataBase(employee);
        Employee employeeFound= employeeService.searchEmployeeByName("Jan","Kowalski")
        then:"Database should contains added employee"
        employeeFound.name == "Jan";
        employeeFound.surname == "Kowalski";
        when:
        employee.setName("Jan");
        employee.setSurname("Kowalski");
        employee.setPosition("manager");
        employee.setSalary(3500);
        employee.setSalaryPerHour(40);
        employee.setNumberOfHoursPerMonth(80);
        employee.setOvertime(10);
        employeeService.saveToDataBase(employee);
        Employee employeeNotFound= employeeService.searchEmployeeByName("Jan","Kowal")
        trx.commit();
        then:"Database shouldn't contains this employee"
        employeeNotFound==null;
    }
}
