public class EmployeeRepository extends AbstractRepository<Employee> {
    public static EmployeeRepository INSTANCE = new EmployeeRepository();

    @Override
    public String toString() {
        return "EmplyeeRepository{" +
                "employeeList=" + super.getEntityList() +
                ", id=" + '}';
    }
}
