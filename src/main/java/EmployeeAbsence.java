import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeAbsence  {

    private int leaveOfAbsenceDaysToUse;
    private List<AbsenceDay> absenceDaysHistory;



    public EmployeeAbsence() {
        this.leaveOfAbsenceDaysToUse = 0;
        this.absenceDaysHistory = new ArrayList<>();
    }

    public boolean addLeaveDay(LocalDate dayOfAbsence, AbsenceType absenceType){
        AbsenceDay entityFromDb = absenceDaysHistory.stream()
                .filter(entity -> entity.getDayOfAbsence().isEqual(dayOfAbsence))
                .findAny()
                .orElse(null);

        if (entityFromDb == null) {
            AbsenceDay newAbsenceDay = new AbsenceDay(dayOfAbsence, absenceType);
            this.absenceDaysHistory.add(newAbsenceDay);
            return true;
        }
        else {
            throw new IllegalArgumentException("Absence is already assigned to this date!");}
    }

    public boolean removeLeaveDay(LocalDate dayOfAbsence){
        AbsenceDay entityFromDb = absenceDaysHistory.stream()
                .filter(entity -> entity.getDayOfAbsence().isEqual(dayOfAbsence))
                .findAny()
                .orElse(null);

        if (entityFromDb == null) {
            throw new IllegalArgumentException("This day of absence doesn't exists!");
        }
        return absenceDaysHistory.remove(entityFromDb);
    }

    public AbsenceDay getAbsenceDayByDate(LocalDate dayOfAbsence){
        AbsenceDay entityFromDb = absenceDaysHistory.stream()
                .filter(entity -> entity.getDayOfAbsence().isEqual(dayOfAbsence))
                .findAny()
                .orElse(null);

        if (entityFromDb == null) {
            throw new IllegalArgumentException("This day of absence doesn't exists!");
        }
        return entityFromDb;
    }

    public int getLoADaysUsedInMonth(int year, int month){
        List<AbsenceDay> lFromDb = absenceDaysHistory.stream()
                .filter(entity -> entity.getDayOfAbsence().getYear() == year)
                .filter(entity -> entity.getDayOfAbsence().getMonthValue() == month)
                .filter(entity -> entity.getAbsenceType() == AbsenceType.LEAVE_OF_ABSENCE)
                .collect(Collectors.toList());

        return lFromDb.size();
    }

    public int getSickLeaveDaysUsedInMonth(int year, int month){
        List<AbsenceDay> lFromDb = absenceDaysHistory.stream()
                .filter(entity -> entity.getDayOfAbsence().getYear() == year)
                .filter(entity -> entity.getDayOfAbsence().getMonthValue() == month)
                .filter(entity -> entity.getAbsenceType() == AbsenceType.SICK_LEAVE)
                .collect(Collectors.toList());
        return lFromDb.size();
    }

    public int getUnpaidLeaveDaysUsedInMonth(int year, int month){
        List<AbsenceDay> lFromDb = absenceDaysHistory.stream()
                .filter(entity -> entity.getDayOfAbsence().getYear() == year)
                .filter(entity -> entity.getDayOfAbsence().getMonthValue() == month)
                .filter(entity -> entity.getAbsenceType() == AbsenceType.UNPAID_LEAVE)
                .collect(Collectors.toList());
        return lFromDb.size();
    }

    public List<AbsenceDay> getAbsenceDaysHistory() {
        return absenceDaysHistory;
    }

    public int getLeaveOfAbsenceDaysToUse() {
        return leaveOfAbsenceDaysToUse;
    }

    public void setLeaveOfAbsenceDaysToUse(int leaveOfAbsenceDaysToUse) {
        this.leaveOfAbsenceDaysToUse = leaveOfAbsenceDaysToUse;
    }
}
