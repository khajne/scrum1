import java.time.LocalDate;

public class AbsenceDay {
    LocalDate dayOfAbsence;
    AbsenceType absenceType;

    public AbsenceDay(LocalDate dayOfAbsence, AbsenceType absenceType) {
        this.dayOfAbsence = dayOfAbsence;
        this.absenceType = absenceType;
    }

    public LocalDate getDayOfAbsence() {
        return dayOfAbsence;
    }


    public AbsenceType getAbsenceType() {
        return absenceType;
    }
}
