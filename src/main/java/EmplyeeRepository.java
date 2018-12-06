import java.util.ArrayList;
import java.util.List;

public class EmplyeeRepository implements Repository<Employee> {
    private List<Employee> employeeList = new ArrayList<>();
    public static EmplyeeRepository INSTANCE = new EmplyeeRepository();

    private int id = 0;


    public void print() {
        employeeList.forEach((Employee e) -> System.out.println("Id: " + e.getId() +
                " | FirstName: " + e.getFirstName() + " | LastName: " + e.getLastName()));
    }


    public Employee getById(int id) {
        Employee empFromDB = employeeList.stream()
                .filter(employee1 -> employee1.getId() == id)
                .findAny()
                .orElse(null);

        if (empFromDB == null) {
            throw new IllegalArgumentException("Employee doesn't exist");
        }
        return  empFromDB;
    }



    @Override
    public boolean create(Employee employee) {
        employee.setId(id++);
        return employeeList.add(employee);
    }
    @Override
    public Employee get(int index) {
        return employeeList.get(index);
    }


    @Override
    public boolean delete(Employee employee) {
        return employeeList.remove(employee);
    }

    @Override
    public void deleteAll() {
        employeeList.clear();
    }

    @Override
    public Employee update(Employee employee) {
        Employee empFromDB = employeeList.stream()
                .filter(employee1 -> employee1.getId() == employee.getId())
                .findAny()
                .orElse(null);

        if (empFromDB == null) {
            throw new IllegalArgumentException("Employee doesn't exist");
        }
        employeeList.remove(empFromDB);
        employeeList.add(employee);


        return employeeList.get(employeeList.size()-1);
    }
    @Override
    public int count() {
        return employeeList.size();
    }

    @Override
    public String toString() {
        return "EmplyeeRepository{" +
                "employeeList=" + employeeList +
                ", id=" + id +
                '}';
    }
}
