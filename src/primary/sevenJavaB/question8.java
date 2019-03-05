package primary.sevenJavaB;

import java.util.Arrays;
import java.util.Scanner;

public class question8 {
    // sqrt(5000000) = 2236.06797749979
    private static int[] a = new int[2240], b = new int[2240];
    private static int count = 0;
    private static int[] selected = new int[4];
    private static boolean f(int n, int k, int last, boolean print){
        if(k == 3){
            int index = Arrays.binarySearch(b, 0, count, n);
            if(index >= 0){
                selected[3] = a[index];
                if(print)System.out.printf("%d %d %d %d\n", selected[0], selected[1], selected[2], selected[3]);
                return true;
            }
            return false;
        }
        for(int i = last; i < count; i++){
            selected[k] = a[i];
            if(f(n - b[i], k + 1, i, print)) return true;
        }
        return false;
    }
    public static void main(String[] args){
        int N;
        if(false){
            Scanner in = new Scanner(System.in);
            N = in.nextInt();
            for(int i = 0, l = (int)Math.sqrt(N); i <= l; i++){
                a[count] = i;
                b[count] = i * i;
                count++;
            }
            f(N, 0, 0, true);
        }else{
            long start = System.currentTimeMillis();
            N = 5000000;
            for(int i = 0, l = (int)Math.sqrt(N); i <= l; i++){
                a[count] = i;
                b[count] = i * i;
                count++;
            }
            long maxCostInBuild = System.currentTimeMillis() - start;

            for(int n = 5000000 - 50; n < 5000000; n++){
                start = System.currentTimeMillis();
                f(n, 0, 0, false);
                long cost = System.currentTimeMillis() - start;
                System.out.printf("%d cost %d\n", n, cost);
            }
        }
    }
}
