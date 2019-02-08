package model.employeeTypes;

import model.ContractType;
import model.Employee;

public class Tester extends Employee {

    public Tester(String firstName, String lastName, ContractType contractType, double baseSalary) {
        super(firstName, lastName, contractType, baseSalary);
    }
}
