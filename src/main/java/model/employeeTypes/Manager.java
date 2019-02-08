package model.employeeTypes;

import model.ContractType;
import model.Employee;

public class Manager extends Employee {

    public Manager(String firstName, String lastName, ContractType contractType, double baseSalary) {
        super(firstName, lastName, contractType, baseSalary);
    }
}
