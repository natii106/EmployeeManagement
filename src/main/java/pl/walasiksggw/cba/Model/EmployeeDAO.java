package pl.walasiksggw.cba.Model;


import org.springframework.transaction.CannotCreateTransactionException;

import java.util.List;

public interface EmployeeDAO {
    List<EmployeeModel> getListOfEmployeeFromDataBase();
    void saveToDataBase(EmployeeModel employee);
    EmployeeModel searchEmployeeByName(String searchingName, String searchingSurname);
}
