package repositories;

import model.AbsenceDay;
import model.AbsenceType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeAbsenceRepository implements Repository<AbsenceDay> {
    public static EmployeeAbsenceRepository INSTANCE = new EmployeeAbsenceRepository();

    private List<AbsenceDay> absenceDaysList = new ArrayList<>();

    public List<AbsenceDay> getById(int id) {
        List<AbsenceDay> lFromDb = absenceDaysList.stream()
                .filter(entity -> entity.getEmployeeId() == id)
                .collect(Collectors.toList());
        return lFromDb;
    }


    public int getLoADaysUsedInMonth(int employeeId, int year, int month) {
        List<AbsenceDay> lFromDb = absenceDaysList.stream()
                .filter(entity -> entity.getEmployeeId() == employeeId)
                .filter(entity -> entity.getDayOfAbsence().getYear() == year)
                .filter(entity -> entity.getDayOfAbsence().getMonthValue() == month)
                .filter(entity -> entity.getAbsenceType() == AbsenceType.LEAVE_OF_ABSENCE)
                .collect(Collectors.toList());
        return lFromDb.size();
    }

    public int getSickLeaveDaysUsedInMonth(int employeeId, int year, int month) {
        List<AbsenceDay> lFromDb = absenceDaysList.stream()
                .filter(entity -> entity.getEmployeeId() == employeeId)
                .filter(entity -> entity.getDayOfAbsence().getYear() == year)
                .filter(entity -> entity.getDayOfAbsence().getMonthValue() == month)
                .filter(entity -> entity.getAbsenceType() == AbsenceType.SICK_LEAVE)
                .collect(Collectors.toList());
        return lFromDb.size();
    }

    public int getUnpaidLeaveDaysUsedInMonth(int employeeId, int year, int month) {
        List<AbsenceDay> lFromDb = absenceDaysList.stream()
                .filter(entity -> entity.getEmployeeId() == employeeId)
                .filter(entity -> entity.getDayOfAbsence().getYear() == year)
                .filter(entity -> entity.getDayOfAbsence().getMonthValue() == month)
                .filter(entity -> entity.getAbsenceType() == AbsenceType.UNPAID_LEAVE)
                .collect(Collectors.toList());
        return lFromDb.size();
    }

    public AbsenceDay getAbsenceDayByDate(LocalDate dayOfAbsence, int employeeId){
        AbsenceDay entityFromDb = absenceDaysList.stream()
                .filter(entity -> entity.getEmployeeId() == employeeId)
                .filter(entity -> entity.getDayOfAbsence().isEqual(dayOfAbsence))
                .findAny()
                .orElse(null);

        if (entityFromDb == null) {
            throw new IllegalArgumentException("This day of absence doesn't exists!");
        }
        return entityFromDb;
    }


    @Override
    public List<AbsenceDay> getAll() {
        return new ArrayList<>(absenceDaysList);
    }

    @Override
    public boolean delete(AbsenceDay absenceDay) {
        return absenceDaysList.remove(absenceDay);
    }

    @Override
    public void deleteAll() {
        absenceDaysList.clear();
    }

    @Override
    public int count() {
        return absenceDaysList.size();
    }

    @Override
    public boolean create(AbsenceDay absenceDay) {
        AbsenceDay entityFromDb = absenceDaysList.stream()
                .filter(entity -> entity.getDayOfAbsence().isEqual(absenceDay.getDayOfAbsence()))
                .filter(entity -> entity.getEmployeeId() == absenceDay.getEmployeeId())
                .findAny()
                .orElse(null);

        if (entityFromDb == null) {
            return absenceDaysList.add(absenceDay);
        } else {
            throw new IllegalArgumentException("Absence is already assigned to this date!");
        }
    }


    @Override
    public AbsenceDay update(AbsenceDay absenceDay) {
        AbsenceDay absenceDayFromDB = absenceDaysList.stream()
                .filter(t1 -> t1.getEmployeeId() == absenceDay.getEmployeeId())
                .filter(t1 -> t1.getDayOfAbsence().isEqual(absenceDay.getDayOfAbsence()))
                .findAny()
                .orElse(null);

        if (absenceDayFromDB == null) {
            throw new IllegalArgumentException("Object doesn't exist");
        }
        absenceDaysList.remove(absenceDayFromDB);
        absenceDaysList.add(absenceDay);

        return absenceDaysList.get(absenceDaysList.size() - 1);
    }
}
