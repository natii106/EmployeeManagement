package pl.walasiksggw.cba.Model;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

import org.jcp.xml.dsig.internal.SignerOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class EmployeeDAOImpl  implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;
        @Transactional
        public List<EmployeeModel> getListOfEmployeeFromDataBase()  {
            Query query = sessionFactory.getCurrentSession().createQuery("SELECT e FROM employee e");
            return (List<EmployeeModel>) query.list();
        }
        @Transactional
        public void saveToDataBase(EmployeeModel employee) {
            this.sessionFactory.getCurrentSession().save(employee);
        }
        @Transactional
        public EmployeeModel searchEmployeeByName(String searchingName, String searchingSurname) {

                EmployeeModel employeeModel;
                Query query = sessionFactory.getCurrentSession().createQuery("SELECT e from employee AS e where name =:name AND surname =:surname");
                query.setParameter("name", searchingName);
                query.setParameter("surname", searchingSurname);
                if (!query.list().isEmpty()) {
                    employeeModel = (EmployeeModel) query.list().get(0);
                    return employeeModel;
                } else {
                    return null;
                }




        }
    }

