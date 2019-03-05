package lanqiaoCourse.course5;

public class course5_2 {
    static int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static boolean isLeapYear(int year){
        if(year % 400 == 0)return true;
        return year % 4 == 0 && year % 100 != 0;
    }
    private static int isLeapYear(int month, int day){
        for(int i = 0; i < month - 1; i++){
            day += daysInMonth[i];
        }
        return day - 1;
    }
    private static int[] getYear(int dayOfBase){
        dayOfBase += isLeapYear(4, 30);
        int year = 1777;
        while (true){
            int dayOfYear = isLeapYear(year) ? 366 : 365;
            if(dayOfBase <= dayOfYear){
                daysInMonth[1] = isLeapYear(year) ? 29 : 28;
                for(int m = 0, dayOfM; m < daysInMonth.length; m++){
                    dayOfM = daysInMonth[m];
                    if(dayOfBase > dayOfM){
                        dayOfBase -= dayOfM;
                    }else{
                        return new int[]{year, m + 1, dayOfBase};
                    }
                }
            }
            dayOfBase -= dayOfYear;
            year++;
        }
    }
    public static void main(String[] args){
        int[] r1 = getYear(5343);
        System.out.printf("%d-%d-%d\n", r1[0], r1[1], r1[2]);
        int[] r2 = getYear(8113);
        System.out.printf("%d-%d-%d", r2[0], r2[1], r2[2]);
    }
}
