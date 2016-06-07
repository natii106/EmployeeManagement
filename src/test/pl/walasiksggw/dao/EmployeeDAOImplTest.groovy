package pl.walasiksggw.dao

import org.hibernate.Query
import org.hibernate.Session
import org.hibernate.SessionFactory

import org.hibernate.cfg.Configuration
import pl.walasiksggw.model.Employee
import spock.lang.Specification


class EmployeeDAOImplTest extends Specification {
    SessionFactory sessionFactory = new Configuration().configure("databaseConfigTests.xml").buildSessionFactory();

    def "Get list of employee from database when we have access to IMDB"() {
        given: "Database configuration"
        Session session = sessionFactory.openSession();
        when: "Get from database (empty)"
        Query query = session.createQuery("FROM employee");
        List<Employee> employeeList=Mock();
        employeeList = query.list();
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
        session.save(employeeTest);
        session.beginTransaction().commit();
        employeeList = query.list();
        session.close();
        then: "Database should contains added employee"
        employeeList.size() == 1

    }

    def "Save employee to database"() {
        given: "Database configuration"
        Session session = sessionFactory.openSession();

        when: "Employee creating"
        Employee employeeTest= new Employee();
        employeeTest.setName("Jan");
        employeeTest.setSurname("Kowalski");
        employeeTest.setPosition("manager");
        employeeTest.setSalary(3500);
        employeeTest.setSalaryPerHour(40);
        employeeTest.setNumberOfHoursPerMonth(80);
        employeeTest.setOvertime(10);
        session.save(employeeTest);
        session.beginTransaction().commit();

        Query query = session.createQuery("FROM employee");
        List<Employee> employeeList=Mock();
        employeeList = query.list();
        int id = query.list().get(0).getId();
        session.close();
        then: "Database should contains added employee"
        employeeList.size() == 1

        then: "Employee's auto-generated Id should be 1"
        id == 1;

    }

    def "SearchEmployeeByName"() {
        given: "Database configuration"
        Session session = sessionFactory.openSession();

        when: "Employee creating"
        Employee employeeTest = new Employee();
        employeeTest.setName("Jan");
        employeeTest.setSurname("Kowalski");
        employeeTest.setPosition("manager");
        employeeTest.setSalary(3500);
        employeeTest.setSalaryPerHour(40);
        employeeTest.setNumberOfHoursPerMonth(80);
        employeeTest.setOvertime(10);
        session.save(employeeTest);
        session.beginTransaction().commit();
        Query query = session.createQuery("SELECT e FROM employee e where e.name =:nameParam AND e.surname =:surnameParam");
        query.setParameter("nameParam", "Jan");
        query.setParameter("surnameParam", "Kowalski");
        Employee employee = Mock();
        employee = query.list().get(0);
        session.close();

        then:"Database should contains added employee"
        employee.name == "Jan";
        employee.surname == "Kowalski";

    }
}
