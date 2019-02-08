package salaryLogic;

import org.junit.Test;
import salaryLogic.WorkingDays;

import static org.junit.Assert.*;

public class WorkingDaysTest {

    @Test
    public void getWorkingDays(){
        assertEquals(20, WorkingDays.getWorkingDays(2018,2));
        assertEquals(21,WorkingDays.getWorkingDays(2019,3));
    }

}