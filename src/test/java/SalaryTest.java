import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class SalaryTest {
    private static final String EMPLOYEE_TEST__FIRST_NAME =  "Jan";
    private static final String EMPLOYEE_TEST__LAST_NAME = "Kowalski";
    Employee employee;

    @Before
    public void setup(){
        employee = new Tester(EMPLOYEE_TEST__FIRST_NAME, EMPLOYEE_TEST__LAST_NAME);
        employee.setBaseSalary(1000);
        employee.setContractType(ContractType.CONTRACT_OF_EMPL);
    }

    @Test
    public void getMonthSalary_ContractOfEmployment(){
        assertEquals(new BigDecimal("1000.00"),Salary.getMonthSalary(2018,2,employee));
        employee.getEmployeeAbsence().addLeaveDay(LocalDate.of(2018,2,3),AbsenceType.SICK_LEAVE);
        assertEquals(new BigDecimal("990.00"),Salary.getMonthSalary(2018,2,employee));
        employee.getEmployeeAbsence().removeLeaveDay(LocalDate.of(2018,2,3));
        employee.getEmployeeAbsence().addLeaveDay(LocalDate.of(2018,2,3),AbsenceType.UNPAID_LEAVE);
        assertEquals(new BigDecimal("950.00"),Salary.getMonthSalary(2018,2,employee));
        employee.getEmployeeAbsence().removeLeaveDay(LocalDate.of(2018,2,3));
        employee.getEmployeeAbsence().addLeaveDay(LocalDate.of(2018,2,3),AbsenceType.LEAVE_OF_ABSENCE);
        assertEquals(new BigDecimal("1000.00"),Salary.getMonthSalary(2018,2,employee));
    }
}