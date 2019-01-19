import java.time.LocalDate;

public  class WorkingDays {


    public static int getWorkingDays (int year, int month){

        if(month <1 || month>12 || year<2018 || year>LocalDate.now().getYear()){throw new IllegalArgumentException();}

        if(year == 2018){
            return year2018(month);
        }
        else if(year == 2019){
            return year2019(month);
        }
        else{
            return 0;
        }
    }

    private static int year2018 (int month){
        int[] workingDays = {21,20,22,20,20,21,22,22,20,23,20,19};
        return workingDays[month-1];
    }

    private static int year2019 (int month){
        int[] workingDays = {22,20,21,21,21,19,23,21,21,23,19,20};
        return workingDays[month-1];
    }


}
