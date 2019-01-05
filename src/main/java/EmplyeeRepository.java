public class EmplyeeRepository extends AbstractRepository<Employee> {
    public static EmplyeeRepository INSTANCE = new EmplyeeRepository();

    @Override
    public String toString() {
        return "EmplyeeRepository{" +
                "employeeList=" + super.getEntityList() +
                ", id=" + '}';
    }
}
