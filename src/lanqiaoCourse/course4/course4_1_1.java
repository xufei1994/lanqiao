package lanqiaoCourse.course4;

import java.util.Arrays;

public class course4_1_1 {
    static int l = 8;
    static int[] a = new int[l];
    static int[] countEveryKind = new int[l];
    static int[] bestChoose = new int[l];
    static int bestChooseCount = 0;
    static {
        int t = 1;
        for(int i = 0; i < l; i ++){
            a[i] = t;
            t *= 7;
            countEveryKind[i] = 0;
        }
    }
    private static void f(int k, int gold, int n){
        if(k == l){
            if(gold != 0) return;
            if(n > bestChooseCount){
                bestChoose = Arrays.copyOf(countEveryKind, l);
                bestChooseCount = n;
            }
            return;
        }

        for(int i = 0; i <= 5; i++){
            countEveryKind[k] = i;
            f(k + 1, gold - i * a[k], n + i);
        }
    }
    public static void main(String[] args){
        f(0, 1000000, 0);
        System.out.println(Math.log(1000000) / Math.log(7));// ln1000000 / ln7
        int sum  = 0;
        for(int i = 0; i < l; i++){
            System.out.printf("+%d*7^%d",bestChoose[i], i);
            sum += bestChoose[i] * a[i];
        }
        System.out.println("=" + sum);
        System.out.println("count:" + bestChooseCount);
    }
}
