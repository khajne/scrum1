import java.math.BigDecimal;
import java.util.Objects;

public abstract class Employee implements IdSetGet {
    private String firstName, lastName;
    private int id;
    private EmployeeAbsence employeeAbsence;
    private ContractType contractType;
    private BigDecimal baseSalary;


    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.baseSalary = new BigDecimal("0");
        this.employeeAbsence = new EmployeeAbsence();
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = new BigDecimal(String.valueOf(baseSalary)).setScale(2,BigDecimal.ROUND_HALF_EVEN);
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeeAbsence getEmployeeAbsence() {
        return employeeAbsence;
    }

    public void setEmployeeAbsence(EmployeeAbsence employeeAbsence) {
        this.employeeAbsence = employeeAbsence;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

}
