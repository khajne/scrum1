import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeRepositoryTest {

    private static final String EMPLOYEE_TEST__FIRST_NAME =  "Jan";
    private static final String EMPLOYEE_TEST__LAST_NAME = "Kowalski";
    private EmployeeRepository employeeRepository = EmployeeRepository.INSTANCE;
    private Employee employee;



    @Before
    public void setup(){
        employeeRepository = new EmployeeRepository();
        employee = new Tester(EMPLOYEE_TEST__FIRST_NAME, EMPLOYEE_TEST__LAST_NAME);
        employeeRepository.create(employee);
    }

    @After
    public void reset (){
        employeeRepository.deleteAll();
    }

    @Test
    public void create() {
        employeeRepository.create(employee);
        assertEquals(2, employeeRepository.count());
    }


    @Test
    public void delete() {
        employeeRepository.create(employee);
        assertTrue(employeeRepository.delete(employee));
    }

    @Test
    public void update() {
        Employee employee2 = new Tester("Dariusz", "Zawadzki");
        employeeRepository.create(employee2);
        Employee employeeTmp = new Tester("Franek", "Dolas");
        employeeTmp.setId(1);
        Employee updated = employeeRepository.update(employeeTmp);
        assertEquals(updated.getFirstName(), employeeTmp.getFirstName());
        assertEquals(updated.getLastName(), employeeTmp.getLastName());
    }

    @Test
    public void getById() {
        List<Employee> all = employeeRepository.getAll();
        int id = all.get(0).getId();
        Employee employeeFromRepo = employeeRepository.getById(id);
        assertEquals(EMPLOYEE_TEST__FIRST_NAME, employeeFromRepo.getFirstName());
        assertEquals(EMPLOYEE_TEST__LAST_NAME, employeeFromRepo.getLastName());
    }
}