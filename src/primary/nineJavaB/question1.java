package primary.nineJavaB;

public class question1 {
    private static int[] dayOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    // 判断是否为闰年， 百度百科：闰年
    private static boolean isLeapYear(int year){
        if(year % 4 == 0){
            if(year % 100 == 0 && year % 400 != 0){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    // 返回这一天是一年中的第几天
    private static int getDayOfYear(int y, int m, int d){
        // 比如为3月，则先将前两个月的天数加起来，而前两个月下标对应0， 1。所以l是3 - 1 = 2;
        int n = 0;
        for(int i = 0, l = m - 1; i < l; i++){
            n += dayOfMonth[i];
        }
        n += d;
        // 如果大于2月，则要考虑是否是闰年，是闰年则+1天（因为闰年2月多了一天，而在dayOfMonth里2月天数是28天）
        if(m > 2 && isLeapYear(y)) n++;
        return n;
    }
    public static void main(String[] args){
        System.out.print(getDayOfYear(2000, 5, 4));
    }
}
