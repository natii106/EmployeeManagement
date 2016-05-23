package pl.walasiksggw.cba.Model;
import java.util.List;

public interface Employee {
    List<EmployeeModel> getListOfEmployeeFromDataBase();
    void saveToDataBase(EmployeeModel employee);
    EmployeeModel searchEmployeeByName(String name, String surname);
}
