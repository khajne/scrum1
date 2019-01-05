import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmplyeeRepositoryTest {

    private EmplyeeRepository emplyeeRepository = EmplyeeRepository.INSTANCE;
    private Employee employee;

    @Before
    public void setup(){
        employee = new Tester("Jan", "Kowalski");
    }

    @Test
    public void create() {
        emplyeeRepository.create(employee);
        assertEquals(1, emplyeeRepository.count());
    }


    @Test
    public void delete() {
        emplyeeRepository.create(employee);
        assertTrue(emplyeeRepository.delete(employee));
    }

    @Test
    public void update() {
        Employee employee2 = new Tester("Dariusz", "Zawadzki");
        emplyeeRepository.create(employee2);
        Employee employeeTmp = new Tester("Franek", "dolas");
        employeeTmp.setId(2);
        Employee updated = emplyeeRepository.update(employeeTmp);
        assertEquals(updated.getFirstName(), employeeTmp.getFirstName());
        assertEquals(updated.getLastName(), employeeTmp.getLastName());
    }
}