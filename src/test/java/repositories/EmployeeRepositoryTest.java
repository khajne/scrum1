package repositories;

import model.ContractType;
import model.Employee;
import model.employeeTypes.Tester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repositories.EmployeeRepository;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeRepositoryTest {

    private static final String EMPLOYEE_TEST__FIRST_NAME = "Jan";
    private static final String EMPLOYEE_TEST__LAST_NAME = "Kowalski";
    private static final ContractType EMPLOYEE_TEST__CONTRACT_TYPE = ContractType.CONTRACT_OF_EMPL;
    private static final double EMPLOYEE_TEST__BASESALARY = 1000;
    private EmployeeRepository employeeRepository = EmployeeRepository.INSTANCE;
    private Employee employee;


    @Before
    public void setup() {
        employeeRepository = new EmployeeRepository();
        employee = new Tester(EMPLOYEE_TEST__FIRST_NAME, EMPLOYEE_TEST__LAST_NAME, EMPLOYEE_TEST__CONTRACT_TYPE, EMPLOYEE_TEST__BASESALARY);
        employeeRepository.create(employee);
    }

    @After
    public void reset() {
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
        Employee employee2 = new Tester("Dariusz", "Zawadzki", ContractType.B2B, 1500);
        employeeRepository.create(employee2);
        Employee employeeTmp = new Tester("Franek", "Dolas", ContractType.CONTRACT_OF_EMPL, 1800);
        employeeTmp.setEmployeeId(1);
        Employee updated = employeeRepository.update(employeeTmp);
        assertEquals(updated.getFirstName(), employeeTmp.getFirstName());
        assertEquals(updated.getLastName(), employeeTmp.getLastName());
        assertEquals(updated.getContractType(), employeeTmp.getContractType());
        assertEquals(updated.getBaseSalary(), employeeTmp.getBaseSalary(), 0);
    }

    @Test
    public void getById() {
        List<Employee> all = employeeRepository.getAll();
        Employee employeeFromRepo = employeeRepository.getById(0);
        assertEquals(EMPLOYEE_TEST__FIRST_NAME, employeeFromRepo.getFirstName());
        assertEquals(EMPLOYEE_TEST__LAST_NAME, employeeFromRepo.getLastName());
        assertEquals(EMPLOYEE_TEST__CONTRACT_TYPE, employeeFromRepo.getContractType());
        assertEquals(EMPLOYEE_TEST__BASESALARY, employeeFromRepo.getBaseSalary(), 0);
    }
}