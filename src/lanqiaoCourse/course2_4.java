package lanqiaoCourse;

public class course2_4 {
    static int count = 0;
    private static void f(int m, int n, int c){
        if(m < n){
            return;
        }
        if(c < 0){
            return;
        }
        if(m == 0){
            if(c >= n) count++;
            return;
        }
        if(n == 0){
            count++;
            return;
        }
        f(m - 1, n, c + 1);
        f(m, n - 1, c - 1);
    }
    public static void main(String[] args){
        f(3, 2, 0);
        System.out.println(count + "");
    }
}
