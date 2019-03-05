package supervice.nineJavaB;

public class question1 {
    private static long max = 0;
    private static char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static void swap(int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void f(int k){
        if(k == 10){
            if(a[0] == '0') return;
            long v = Long.parseLong(new String(a));
            long sqrt = (long)(Math.sqrt(v));
            if((sqrt * sqrt) == v && v > max) max = v;
            return;
        }
        for(int i = k; i < 10; i++){
            swap(i, k);
            f(k + 1);
            swap(i, k);
        }
    }
    public static void main(String[] args){
        f(0);
        System.out.print(max);
    }
}
