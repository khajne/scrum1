package model;

import java.time.LocalDate;
import java.util.Objects;

public class AbsenceDay {
    LocalDate dayOfAbsence;
    AbsenceType absenceType;
    int employeeId;

    public AbsenceDay(LocalDate dayOfAbsence, AbsenceType absenceType, int employeeId) {
        this.dayOfAbsence = dayOfAbsence;
        this.absenceType = absenceType;
        this.employeeId = employeeId;
    }

    public LocalDate getDayOfAbsence() {
        return dayOfAbsence;
    }


    public AbsenceType getAbsenceType() {
        return absenceType;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbsenceDay that = (AbsenceDay) o;
        return employeeId == that.employeeId &&
                Objects.equals(dayOfAbsence, that.dayOfAbsence) &&
                absenceType == that.absenceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOfAbsence, absenceType, employeeId);
    }
}
