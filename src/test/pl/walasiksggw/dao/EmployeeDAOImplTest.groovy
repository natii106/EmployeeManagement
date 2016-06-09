package pl.walasiksggw.dao

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.Transaction
import org.hibernate.cfg.Configuration
import pl.walasiksggw.model.Employee
import spock.lang.Specification


class EmployeeDAOImplTest extends Specification {
    EmployeeDAOImpl employeeDAO=new EmployeeDAOImpl();
    SessionFactory sessionFactory=new Configuration().configure("databaseConfigTests.xml").buildSessionFactory();

    def "Get list of employee from database when we have access to IMDB"() {
        given:
        Session session= sessionFactory.getCurrentSession();
        Transaction trx =session.beginTransaction();
        employeeDAO.setSessionFactory(sessionFactory);
        when: "Get from database (empty)"
        List<Employee> employeeList= employeeDAO.getListOfEmployeeFromDataBase();
        then: "The database is empty"
        employeeList.size() == 0;
        when: "Employee creating"
        Employee employeeTest = new Employee();
        employeeTest.setName("Jan");
        employeeTest.setSurname("Kowalski");
        employeeTest.setPosition("manager");
        employeeTest.setSalary(3500);
        employeeTest.setSalaryPerHour(40);
        employeeTest.setNumberOfHoursPerMonth(80);
        employeeTest.setOvertime(10);
        employeeDAO.saveToDataBase(employeeTest);
        employeeList= employeeDAO.getListOfEmployeeFromDataBase();
        trx.commit();
        then: "Database should contains added employee"
        employeeList.size() == 1

    }

    def "Save employee to database"() {
        given:
        Session session= sessionFactory.getCurrentSession();
        Transaction trx =session.beginTransaction();
        employeeDAO.setSessionFactory(sessionFactory);
        when: "Employee creating"
        Employee employeeTest= new Employee();
        employeeTest.setName("Jan");
        employeeTest.setSurname("Kowalski");
        employeeTest.setPosition("manager");
        employeeTest.setSalary(3500);
        employeeTest.setSalaryPerHour(40);
        employeeTest.setNumberOfHoursPerMonth(80);
        employeeTest.setOvertime(10);
        employeeDAO.saveToDataBase(employeeTest);
        List<Employee> employeeList=employeeDAO.getListOfEmployeeFromDataBase();
        int id = employeeList.get(0).getId();
        trx.commit();
        then: "Database should contains added employee"
        employeeList.size() == 1
        then: "Employee's auto-generated Id should be 1"
        id == 1;

    }

    def "SearchEmployeeByName"() {
        given:
        Session session= sessionFactory.getCurrentSession();
        Transaction trx =session.beginTransaction();
        employeeDAO.setSessionFactory(sessionFactory);
        when: "Employee creating"
        Employee employeeTest = new Employee();
        employeeTest.setName("Jan");
        employeeTest.setSurname("Kowalski");
        employeeTest.setPosition("manager");
        employeeTest.setSalary(3500);
        employeeTest.setSalaryPerHour(40);
        employeeTest.setNumberOfHoursPerMonth(80);
        employeeTest.setOvertime(10);
        employeeDAO.saveToDataBase(employeeTest);
        Employee employeeSearch= employeeDAO.searchEmployeeByName("Jan", "Kowalski")
        trx.commit();
        then:"Database should contains added employee"
        employeeSearch.name == "Jan";
        employeeSearch.surname == "Kowalski";

    }
}
