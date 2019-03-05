package lanqiaoCourse.course5;

public class course5_4 {
    private static boolean isLeapYear(int year){
        if(year % 400 == 0)return true;
        return year % 4 == 0 && year % 100 != 0;
    }
    public static void main(String[] args){
        int dayOfWeek = 6;
        int count = 0;
        for(int y = 1950; y <= 2012; y++){
            dayOfWeek = (dayOfWeek + (isLeapYear(y) ? 366 : 365)) % 7;
            if(dayOfWeek == 0){
                count++;
                System.out.println(y);
            }
        }
        System.out.println(count);
    }
}
