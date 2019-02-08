package model.employeeTypes;

import model.ContractType;
import model.Employee;

public class Developer extends Employee {

    public Developer(String firstName, String lastName, ContractType contractType, double baseSalary) {
        super(firstName, lastName, contractType, baseSalary);
    }
}
