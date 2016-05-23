package pl.walasiksggw.cba.Model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/context.xml"})
public class EmployeeImplTest {
    @Test
    public void getListOfEmployeeFromDataBase() throws Exception {
        ApplicationContext context= new ClassPathXmlApplicationContext("context.xml");
        EmployeeDAO employeeDAO = context.getBean("employeeDAOImpl", EmployeeDAOImpl.class);
        List<EmployeeModel> listOfEmployeeFromDataBase = employeeDAO.getListOfEmployeeFromDataBase();
        assertEquals(listOfEmployeeFromDataBase.toString().trim(), employeeDAO.getListOfEmployeeFromDataBase().toString().trim());
    }

    @Test
    public void saveToDataBase() throws Exception {
        ApplicationContext context= new ClassPathXmlApplicationContext("context.xml");
        EmployeeDAO employeeDAO = context.getBean("employeeDAOImpl", EmployeeDAOImpl.class);
        EmployeeModel employeeModel = context.getBean("employeeModel", EmployeeModel.class);
        EmployeeImpl employeeImpl = context.getBean("employeeImpl", EmployeeImpl.class);
        employeeModel.setName("Jan");
        employeeModel.setSurname("Kowalski");
        employeeModel.setPosition("tester");
        employeeModel.setSalary(3800);
        employeeModel.setSalaryPerHour(25);
        employeeModel.setNumberOfHoursPerMonth(125);
        employeeModel.setOvertime(0);
        employeeImpl.saveToDataBase(employeeModel);
        List<EmployeeModel> listOfEmployeeFromDataBase = employeeDAO.getListOfEmployeeFromDataBase();
        assertEquals(employeeModel.toString().trim(),listOfEmployeeFromDataBase.get(listOfEmployeeFromDataBase.size()-1).toString().trim());
    }

    @Test
    public void searchEmployeeByName() throws Exception {
        ApplicationContext context= new ClassPathXmlApplicationContext("context.xml");
        EmployeeDAO employeeDAO = context.getBean("employeeDAOImpl", EmployeeDAOImpl.class);
        EmployeeModel employeeModel = employeeDAO.searchEmployeeByName("Natalia", "Walasik");
        assertEquals(employeeModel.toString().trim(), employeeDAO.searchEmployeeByName("Natalia", "Walasik").toString().trim());
    }


}