package salaryLogic;

import model.AbsenceDay;
import model.AbsenceType;
import model.ContractType;
import model.Employee;
import model.employeeTypes.Tester;
import org.junit.Before;
import org.junit.Test;
import repositories.EmployeeAbsenceRepository;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class SalaryTest {
    private static final String EMPLOYEE_TEST__FIRST_NAME = "Jan";
    private static final String EMPLOYEE_TEST__LAST_NAME = "Kowalski";
    Employee employee;
    private static final int EMPLOYEE_TEST__ID = 12;
    private static final LocalDate TEST_DATE = LocalDate.of(2018, 2, 3);
    private EmployeeAbsenceRepository employeeAbsenceRepository = EmployeeAbsenceRepository.INSTANCE;

    @Before
    public void setup() {
        employee = new Tester(EMPLOYEE_TEST__FIRST_NAME, EMPLOYEE_TEST__LAST_NAME, ContractType.CONTRACT_OF_EMPL, 1000);
        employee.setEmployeeId(EMPLOYEE_TEST__ID);
        employeeAbsenceRepository.deleteAll();
    }

    @Test
    public void getMonthSalary_ContractOfEmployment() {
        assertEquals(1000, Salary.getMonthSalary(2018, 2, employee, employeeAbsenceRepository), 0);

        employeeAbsenceRepository.create(new AbsenceDay(TEST_DATE, AbsenceType.SICK_LEAVE, EMPLOYEE_TEST__ID));
        assertEquals(990, Salary.getMonthSalary(2018, 2, employee, employeeAbsenceRepository), 0.1);

        employeeAbsenceRepository.update(new AbsenceDay(TEST_DATE, AbsenceType.UNPAID_LEAVE, EMPLOYEE_TEST__ID));
        assertEquals(950, Salary.getMonthSalary(2018, 2, employee, employeeAbsenceRepository), 0.1);

        employeeAbsenceRepository.update(new AbsenceDay(TEST_DATE, AbsenceType.LEAVE_OF_ABSENCE, EMPLOYEE_TEST__ID));
        assertEquals(1000, Salary.getMonthSalary(2018, 2, employee, employeeAbsenceRepository), 0);

        employeeAbsenceRepository.create(new AbsenceDay(LocalDate.of(2018, 1, 3), AbsenceType.SICK_LEAVE, EMPLOYEE_TEST__ID));
        assertEquals(990.47, Salary.getMonthSalary(2018, 1, employee, employeeAbsenceRepository), 0.1);

    }

    @Test
    public void getMonthSalary_B2B() {
        assertEquals(1000, Salary.getMonthSalary(2018, 2, employee, employeeAbsenceRepository), 0);

        employeeAbsenceRepository.create(new AbsenceDay(TEST_DATE, AbsenceType.UNPAID_LEAVE, EMPLOYEE_TEST__ID));
        assertEquals(950, Salary.getMonthSalary(2018, 2, employee, employeeAbsenceRepository), 0.1);
    }
}