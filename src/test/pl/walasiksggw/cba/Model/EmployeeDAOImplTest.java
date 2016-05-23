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
public class EmployeeDAOImplTest{
    @Test
    public void getListOfEmployeeFromDataBase() throws Exception {
        ApplicationContext context= new ClassPathXmlApplicationContext("context.xml");
        EmployeeDAO employeeDAO = context.getBean("employeeDAOImpl", EmployeeDAO.class);
        List<EmployeeModel> listOfObjectsFromDataBase=employeeDAO.getListOfEmployeeFromDataBase();
        assertEquals(1,listOfObjectsFromDataBase.get(0).getId());
        try {
            listOfObjectsFromDataBase.get(listOfObjectsFromDataBase.size());
        } catch (IndexOutOfBoundsException e) {
            boolean thrown = true;
        }
    }

    @Test
    public void saveToDataBase() throws Exception {
        ApplicationContext context= new ClassPathXmlApplicationContext("context.xml");
        EmployeeDAO employeeDAO = context.getBean("employeeDAOImpl", EmployeeDAO.class);
        EmployeeModel employeeModel = context.getBean("employeeModel", EmployeeModel.class);
        employeeModel.setName("Aleksander");
        employeeModel.setSurname("Jankowski");
        employeeModel.setPosition("tester");
        employeeModel.setSalary(3800);
        employeeModel.setSalaryPerHour(25);
        employeeModel.setNumberOfHoursPerMonth(125);
        employeeModel.setOvertime(0);
        employeeDAO.saveToDataBase(employeeModel);
        List<EmployeeModel> listOfObjectsFromDataBase=employeeDAO.getListOfEmployeeFromDataBase();
        assertEquals(employeeModel.getName(), listOfObjectsFromDataBase.get(listOfObjectsFromDataBase.size()-1).getName());
    }

    @Test
    public void searchEmployeeByName() throws Exception {
        String name="Natalia", surname="Walasik";
        ApplicationContext context= new ClassPathXmlApplicationContext("context.xml");
        EmployeeDAO employeeDAO = context.getBean("employeeDAOImpl", EmployeeDAO.class);
        EmployeeModel employeeModel = employeeDAO.searchEmployeeByName(name, surname);
        assertEquals("Natalia", employeeModel.getName());
        assertEquals("Walasik", employeeModel.getSurname());

    }

}