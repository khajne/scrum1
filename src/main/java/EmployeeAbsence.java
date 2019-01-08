public class EmployeeAbsence {

    private int leaveOfAbsenceDaysToUse;
    private int leaveOfAbsenceDaysUsed;
    private int unpaidLeaveDaysUsed;
    private int sickLeaveDaysUsed;

    public EmployeeAbsence() {
        this.leaveOfAbsenceDaysToUse = 0;
        this.leaveOfAbsenceDaysUsed = 0;
        this.unpaidLeaveDaysUsed = 0;
        this.sickLeaveDaysUsed = 0;
    }


    public int getLeaveOfAbsenceDaysToUse() {
        return leaveOfAbsenceDaysToUse;
    }

    public void setLeaveOfAbsenceDaysToUse(int leaveOfAbsenceDaysToUse) {
        this.leaveOfAbsenceDaysToUse = leaveOfAbsenceDaysToUse;
    }

    public int getLeaveOfAbsenceDaysUsed() {
        return leaveOfAbsenceDaysUsed;
    }

    public void setLeaveOfAbsenceDaysUsed(int leaveOfAbsenceDaysUsed) {
        this.leaveOfAbsenceDaysUsed = leaveOfAbsenceDaysUsed;
    }

    public int getUnpaidLeaveDaysUsed() {
        return unpaidLeaveDaysUsed;
    }

    public void setUnpaidLeaveDaysUsed(int unpaidLeaveDaysUsed) {
        this.unpaidLeaveDaysUsed = unpaidLeaveDaysUsed;
    }

    public int getSickLeaveDaysUsed() {
        return sickLeaveDaysUsed;
    }

    public void setSickLeaveDaysUsed(int sickLeaveDaysUsed) {
        this.sickLeaveDaysUsed = sickLeaveDaysUsed;
    }
}
