package pl.walasiksggw.cba.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.walasiksggw.cba.DTO.EmployeeDTO;
import pl.walasiksggw.cba.DTO.EmployeeDTO2;
import pl.walasiksggw.cba.Model.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class EmployeeController {
    @Autowired
    private Employee employee;

    protected ApplicationContext createApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        return context;
    }
    @RequestMapping(value = "/list", method= RequestMethod.GET)
    public String listOfEmployee(Model model) {
        model.addAttribute("getList", employee.getListOfEmployeeFromDataBase());
        return "list";
    }


    @RequestMapping("/dodaj")
    public String addEmployee(HttpServletRequest request, @ModelAttribute("employeeDTO") @Valid EmployeeDTO employeeDTO, BindingResult result) {
        if (request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()) {
            EmployeeModel employee = createApplicationContext().getBean("employeeModel", EmployeeModel.class);
            employee.setName(employeeDTO.getName());
            employee.setSurname(employeeDTO.getSurname());
            employee.setPosition(employeeDTO.getPosition());
            employee.setSalary(employeeDTO.getSalary());
            employee.setSalaryPerHour(employeeDTO.getSalaryPerHour());
            employee.setNumberOfHoursPerMonth(employeeDTO.getNumberOfHoursPerMonth());
            employee.setOvertime(employeeDTO.getOvertime());
            EmployeeImpl employeeImpl= createApplicationContext().getBean("employeeImpl", EmployeeImpl.class);
            employeeImpl.saveToDataBase(employee);
            return "redirect:/list";
        }
        return "dodaj";
    }
    @RequestMapping("/szukaj")
    public String searchEmployee(HttpServletRequest request, @ModelAttribute("employeeDTO2") @Valid EmployeeDTO2 employeeDTO2, BindingResult result)
    {
        if (request.getMethod().equalsIgnoreCase("post") &&!result.hasErrors()) {
            EmployeeImpl employeeImpl= createApplicationContext().getBean("employeeImpl", EmployeeImpl.class);
            EmployeeModel employee;
            employee= employeeImpl.searchEmployeeByName(employeeDTO2.getName(), employeeDTO2.getSurname());
            if (employee!=null){ return "redirect:/list";}
            else{
            return  "warning";
            }
        }
        return "szukaj";
    }
}
