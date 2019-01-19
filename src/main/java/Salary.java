import java.math.BigDecimal;

public class Salary {
    //zaimplementować pozostałe typy kontraktów
    //jesli wykorzystam te rozwiazanie to musze nadpisac klase employee - dodac parametr do konstruktora

    public static BigDecimal getMonthSalary(int year, int month, Employee employee){
        if(employee.getContractType() == ContractType.CONTRACT_OF_EMPL){
            return getMonthContractOfEmplSalary(year, month, employee);
        }
        return null;
    }

    private static BigDecimal getMonthContractOfEmplSalary (int year, int month, Employee employee){
        BigDecimal sickLeaveDaysPaymentRatio = new BigDecimal("0.80");
        BigDecimal baseSalary = new BigDecimal(employee.getBaseSalary().toString());

        int unpaidLeaveDaysUsed = employee.getEmployeeAbsence().getUnpaidLeaveDaysUsedInMonth(year, month);
        int sickLeaveDaysUsed   = employee.getEmployeeAbsence().getSickLeaveDaysUsedInMonth(year, month);

        if(unpaidLeaveDaysUsed==0 && sickLeaveDaysUsed==0){return baseSalary.setScale(2,BigDecimal.ROUND_HALF_EVEN);}
        else{
            int workingDays = WorkingDays.getWorkingDays(year, month);
            int daysWorked = workingDays-unpaidLeaveDaysUsed-sickLeaveDaysUsed;
            BigDecimal salaryPerDay = baseSalary.divide(new BigDecimal(String.valueOf(workingDays)));
            BigDecimal finalSalary = new BigDecimal(salaryPerDay.toString()).multiply(new BigDecimal(String.valueOf(daysWorked)));
            BigDecimal sickLeaveSalary = new BigDecimal(salaryPerDay.toString()).multiply(new BigDecimal(String.valueOf(sickLeaveDaysUsed))).multiply(sickLeaveDaysPaymentRatio);
            return finalSalary.add(sickLeaveSalary).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        }
    }
}
