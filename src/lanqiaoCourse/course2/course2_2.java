package lanqiaoCourse.course2;

public class course2_2 {
    static int count = 0;
    private static void f(int left, int stop){
        if(left == 0 && stop == 0){
            count++;
            return;
        }
        if(left == 0){
            f(0, 0);
        }else if(stop == 0){
            f(left - 1, 1);
        }else{
            f(left - 1, stop + 1);
            f(left, stop - 1);
        }
    }
    public static void main(String[] args){
        f(16, 0);
        System.out.println(count);
    }
}
