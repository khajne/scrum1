import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class EmployeeAbsenceTest {

    private final LocalDate TEST_DATE = LocalDate.of(2018, 1, 2);
    private EmployeeAbsence employeeAbsence;



    @Before
    public void setup(){
        employeeAbsence = new EmployeeAbsence();
        employeeAbsence.addLeaveDay(TEST_DATE,AbsenceType.LEAVE_OF_ABSENCE);
    }

    @Test
    public void addLeaveDay() {
        assertEquals(1, employeeAbsence.getAbsenceDaysHistory().size());
        employeeAbsence.addLeaveDay(LocalDate.of(2018,1,3),AbsenceType.SICK_LEAVE);
        assertEquals(2,employeeAbsence.getAbsenceDaysHistory().size());
    }

    @Test
    public void removeLeaveDay() {
        employeeAbsence.addLeaveDay(LocalDate.of(2018,1,3),AbsenceType.SICK_LEAVE);
        assertEquals(2,employeeAbsence.getAbsenceDaysHistory().size());
        assertEquals(true, employeeAbsence.removeLeaveDay(LocalDate.of(2018,1,3)));
        assertEquals(1,employeeAbsence.getAbsenceDaysHistory().size());
    }


    @Test
    public void getAbsenceDayByDate() {
        AbsenceDay dayFromDb = employeeAbsence.getAbsenceDayByDate(LocalDate.of(2018,1,2));
        assertEquals(2018, dayFromDb.getDayOfAbsence().getYear());
        assertEquals(1, dayFromDb.getDayOfAbsence().getMonthValue());
        assertEquals(2, dayFromDb.getDayOfAbsence().getDayOfMonth());
    }


    @Test
    public void getLoADaysUsedInMonth() {
        assertEquals(1, employeeAbsence.getAbsenceDaysHistory().size());
        assertEquals(1, employeeAbsence.getLoADaysUsedInMonth(2018,1));
        assertEquals(0, employeeAbsence.getLoADaysUsedInMonth(2018,2));
    }
}