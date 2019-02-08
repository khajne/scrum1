package repositories;

import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee> {
    public static EmployeeRepository INSTANCE = new EmployeeRepository();

    private int nextFreeId = 0;

    private List<Employee> employeesList= new ArrayList<>();


    public Employee getById(int id) {
        Employee emplFromDB = employeesList.stream()
                .filter(t1 -> t1.getEmployeeId() == id)
                .findAny()
                .orElse(null);

        if (emplFromDB == null) {
            throw new IllegalArgumentException("Object doesn't exist");
        }
        return  emplFromDB;
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employeesList);
    }

    @Override
    public boolean delete(Employee employee) {
        return employeesList.remove(employee);
    }

    @Override
    public void deleteAll() {
        employeesList.clear();
    }

    @Override
    public int count() {
        return employeesList.size();
    }

    @Override
    public boolean create(Employee employee) {
        employee.setEmployeeId(nextFreeId++);
        return employeesList.add(employee);
    }

    @Override
    public Employee update(Employee employee) {
        Employee employeeFromDB = employeesList.stream()
                .filter(t1 -> t1.getEmployeeId() == employee.getEmployeeId())
                .findAny()
                .orElse(null);

        if (employeeFromDB == null) {
            throw new IllegalArgumentException("Object doesn't exist");
        }
        employeesList.remove(employeeFromDB);
        employeesList.add(employee);

        return employeesList.get(employeesList.size()-1);
    }
}
