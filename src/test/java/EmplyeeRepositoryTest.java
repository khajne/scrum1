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
    public void get() {
        emplyeeRepository.create(employee);
        Employee employeeTmp = emplyeeRepository.get(0);
        assertEquals(employee.getFirstName(), employeeTmp.getFirstName());
        assertEquals(employee.getLastName(), employeeTmp.getLastName());

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
        //emplyeeRepository.print();
        assertEquals(updated.getFirstName(), employeeTmp.getFirstName());
        assertEquals(updated.getLastName(), employeeTmp.getLastName());
    }
}