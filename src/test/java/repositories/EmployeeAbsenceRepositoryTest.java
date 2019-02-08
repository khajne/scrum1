package repositories;

import model.AbsenceDay;
import model.AbsenceType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class EmployeeAbsenceRepositoryTest {

    private static final int EMPLOYEE_TEST__ID = 12;
    private static final LocalDate TEST_DATE = LocalDate.of(2018, 1, 2);
    private EmployeeAbsenceRepository employeeAbsenceRepository = EmployeeAbsenceRepository.INSTANCE;


    @Before
    public void setUp(){
        employeeAbsenceRepository.create(new AbsenceDay(TEST_DATE,AbsenceType.SICK_LEAVE,EMPLOYEE_TEST__ID));
        employeeAbsenceRepository.create(new AbsenceDay(TEST_DATE,AbsenceType.LEAVE_OF_ABSENCE,11));
    }

    @After
    public void tearDown(){
        employeeAbsenceRepository.deleteAll();
    }

    @Test
    public void getById() {
        employeeAbsenceRepository.getById(EMPLOYEE_TEST__ID).size();
        assertEquals(1,employeeAbsenceRepository.getById(EMPLOYEE_TEST__ID).size());
    }

    @Test
    public void getLoADaysUsedInMonth() {
        assertEquals(1,employeeAbsenceRepository.getLoADaysUsedInMonth(11,2018,1));
        employeeAbsenceRepository.create(new AbsenceDay(LocalDate.of(2018,1,3),AbsenceType.LEAVE_OF_ABSENCE,11));
        employeeAbsenceRepository.create(new AbsenceDay(LocalDate.of(2018,2,2),AbsenceType.LEAVE_OF_ABSENCE,11));
        assertEquals(2,employeeAbsenceRepository.getLoADaysUsedInMonth(11,2018,1));
    }

    @Test
    public void getSickLeaveDaysUsedInMonth() {
        assertEquals(0,employeeAbsenceRepository.getSickLeaveDaysUsedInMonth(11,2018,1));
        employeeAbsenceRepository.create(new AbsenceDay(LocalDate.of(2018,1,3),AbsenceType.SICK_LEAVE,11));
        employeeAbsenceRepository.create(new AbsenceDay(LocalDate.of(2018,2,2),AbsenceType.SICK_LEAVE,11));
        assertEquals(1,employeeAbsenceRepository.getSickLeaveDaysUsedInMonth(11,2018,1));
    }

    @Test
    public void getUnpaidLeaveDaysUsedInMonth() {
        assertEquals(0,employeeAbsenceRepository.getUnpaidLeaveDaysUsedInMonth(11,2018,1));
        employeeAbsenceRepository.create(new AbsenceDay(LocalDate.of(2018,1,3),AbsenceType.UNPAID_LEAVE,11));
        employeeAbsenceRepository.create(new AbsenceDay(LocalDate.of(2018,2,2),AbsenceType.UNPAID_LEAVE,11));
        assertEquals(1,employeeAbsenceRepository.getUnpaidLeaveDaysUsedInMonth(11,2018,1));
    }

    @Test
    public void delete() {
        assertEquals(2, employeeAbsenceRepository.count());
        employeeAbsenceRepository.delete(new AbsenceDay(TEST_DATE, AbsenceType.SICK_LEAVE, EMPLOYEE_TEST__ID));
        assertEquals(1, employeeAbsenceRepository.count());
    }

    @Test
    public void update() {
        employeeAbsenceRepository.update(new AbsenceDay(TEST_DATE, AbsenceType.UNPAID_LEAVE, EMPLOYEE_TEST__ID));
        AbsenceDay absenceDayFromDb = employeeAbsenceRepository.getAbsenceDayByDate(TEST_DATE,EMPLOYEE_TEST__ID);
        assertEquals(TEST_DATE, absenceDayFromDb.getDayOfAbsence());
        assertEquals(EMPLOYEE_TEST__ID, absenceDayFromDb.getEmployeeId());
        assertEquals(AbsenceType.UNPAID_LEAVE, absenceDayFromDb.getAbsenceType());
    }
}