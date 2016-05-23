package pl.walasiksggw.cba.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.walasiksggw.cba.DTO.EmployeeDTO;
import pl.walasiksggw.cba.Model.Employee;
import pl.walasiksggw.cba.Model.EmployeeModel;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class EmployeeRESTController {
    @Autowired
    Employee employee;
    @RequestMapping(value="/list", method= RequestMethod.GET)
    @ResponseBody
    public List<EmployeeModel> getList(){
        List<EmployeeModel> listOfEmployee= employee.getListOfEmployeeFromDataBase();
        return listOfEmployee;
    }
    
    @RequestMapping(value = "/{name}/{surname}", method = RequestMethod.GET)
    public String search(@PathVariable("name") String name, @PathVariable("surname") String surname) {
        EmployeeModel result=employee.searchEmployeeByName(name,surname);
        return result.toString();
    }

}
