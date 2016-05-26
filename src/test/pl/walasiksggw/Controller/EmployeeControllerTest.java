package pl.walasiksggw.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/context.xml"})
public class EmployeeControllerTest {
  //  @Autowired
  //  private ApplicationContext applicationContext;
    @Autowired
    private EmployeeController employeeController;
    @Test
    public void listOfEmployee() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
        mockMvc.perform(get("/list"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/Views/list.jsp"));
    }

    @Test
    public void addEmployee() throws Exception {

    }

    @Test
    public void searchEmployee() throws Exception {

    }

}