package pl.walasiksggw.service

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.Transaction
import org.hibernate.cfg.Configuration
import org.junit.Assert
import org.mockito.Mockito
import pl.walasiksggw.model.Employee
import pl.walasiksggw.dao.EmployeeDAOImpl
import spock.lang.Specification

class EmployeeServiceImplTest extends Specification {
    private EmployeeDAOImpl employeeDAO;
    EmployeeServiceImpl employeeService;
    Employee employee;

    void setup(){
        employee= new Employee();
        employeeService= new EmployeeServiceImpl();
        employeeDAO= Mock(EmployeeDAOImpl);
        employeeService.employeeDAO=employeeDAO;
    }

    def "Get List Of Employee From DataBase "(){
        given:
        List<Employee> listMock=new ArrayList<>();
        employee.name="Jan";
        employee.surname="Kowalski";
        listMock.add(employee);
        employeeDAO.getListOfEmployeeFromDataBase()>> listMock;
        when:
        employeeService.getListOfEmployeeFromDataBase();
        then:
        1*employeeDAO.getListOfEmployeeFromDataBase();
    }

    def "Save Employee To DataBase"() {
        given:
        employee.name="Jan";
        employee.surname="Kowalski";
        employee.position="tester";
        employee.salary=4000;
        employee.numberOfHoursPerMonth=160;
        employee.overtime=0;
        employee.salaryPerHour=25;
        employeeDAO.saveToDataBase(employee)>> employee;
        when:
        employeeService.saveToDataBase(employee);
        then:
        1*employeeDAO.saveToDataBase(employee);
    }

    def "Search Employee By Name"() {
        given:
        employeeDAO.searchEmployeeByName("name","surname")>>"Employee was found"
        when:
        employeeService.searchEmployeeByName("name","surname");
        then:
        1*employeeDAO.searchEmployeeByName("name", "surname");

    }
}
