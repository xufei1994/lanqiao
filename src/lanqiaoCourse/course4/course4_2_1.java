package lanqiaoCourse.course4;

import java.util.Arrays;
import java.util.Scanner;

public class course4_2_1 {
    static int[] a = new int[]{1, 3, 9, 27, 81};
    static int[] b = new int[]{0, 1, -1};
    static int[] c = new int[]{0, 0, 0, 0, 0};// c[k]-> 0 1 -1  => a[k]
    static int[][] data = new int[122][];
    private static void f(int k, int sum){
        if(k == a.length){
            if(sum >= 0){
                data[sum] = Arrays.copyOf(c, c.length);
            }
            return;
        }
        for(int t : b){
            c[k] = t;
            f(k + 1, sum + t * a[k]);
        }
    }
    public static void main(String[] args){
        f(0, 0);
        // 输出1-121所有整数的表示法
//        if(true){
//            for(int i = 1; i < data.length; i++){
//                int[] row = data[i];
//                if(row == null) continue;
//                System.out.print(i + "=");
//                for(int j = row.length - 1; j >= 0; j--){
//                    if(row[j] == 0)continue;
//                    System.out.print((row[j] == 1 ? "+" : "-") + a[j]);
//                }
//                System.out.print('\n');
//            }
//        }
        Scanner in = new Scanner(System.in);
        int[] r = data[in.nextInt()];
        boolean outputSymbol = false;
        for(int i  = r.length - 1; i >= 0; i--){
            if(r[i] == 0) continue;
            if(outputSymbol) System.out.print(r[i] == 1 ? "+" : "-");
            System.out.print(a[i]);
            outputSymbol = true;
        }
    }
}
