package salaryLogic;

import model.ContractType;
import model.Employee;
import repositories.EmployeeAbsenceRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Salary {

    public static double getMonthSalary(int year, int month, Employee employee, EmployeeAbsenceRepository employeeAbsenceRepository) {
        if (employee.getContractType() == ContractType.CONTRACT_OF_EMPL) {
            return getMonthContractOfEmplSalary(year, month, employee, employeeAbsenceRepository);
        }
        else {
            throw new IllegalArgumentException("Ups, sth went wrong if u see this msg :(");
        }
    }

    private static double getMonthContractOfEmplSalary(int year, int month, Employee employee, EmployeeAbsenceRepository employeeAbsenceRepository) {

        double sickLeaveDaysPaymentRatio = 0.80;
        double baseSalary = employee.getBaseSalary();

        int unpaidLeaveDaysUsed = employeeAbsenceRepository.getUnpaidLeaveDaysUsedInMonth(employee.getEmployeeId(), year, month);
        int sickLeaveDaysUsed = employeeAbsenceRepository.getSickLeaveDaysUsedInMonth(employee.getEmployeeId(), year, month);

        if (unpaidLeaveDaysUsed == 0 && sickLeaveDaysUsed == 0) {
            return baseSalary;
        } else {
            int workingDays = WorkingDays.getWorkingDays(year, month);
            int daysWorked = workingDays - unpaidLeaveDaysUsed - sickLeaveDaysUsed;
            double salaryPerDay = baseSalary / workingDays;
            double finalSalary = salaryPerDay * daysWorked + salaryPerDay * sickLeaveDaysUsed * sickLeaveDaysPaymentRatio;
            return round(finalSalary, 2);
        }
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
