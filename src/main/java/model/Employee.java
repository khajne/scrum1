package model;

import java.util.Objects;

public abstract class Employee  {
    private String firstName, lastName;
    private int employeeId;
    private ContractType contractType;
    private double baseSalary;

    public Employee(String firstName, String lastName, ContractType contractType, double baseSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = 2000000;//do wyjaśnienia -> zastosować Integer?
        this.contractType = contractType;
        this.baseSalary = baseSalary;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getEmployeeId(), employee.getEmployeeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId());
    }
}
