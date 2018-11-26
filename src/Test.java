public class Test {
    static int[] monthLength = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args){
        int s = 1;
        int day = 1;
        int month = 1;
        int allDay = monthLength[month - 1];
        int i = 0;
        while (day < allDay){
            if(i < s){
                System.out.print("    ");
            }else{
                System.out.printf("%4s",day++);
                if(i % 7 == 6) System.out.print('\n');
            }
            i++;
        }
    }
}
