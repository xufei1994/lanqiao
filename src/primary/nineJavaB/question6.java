package primary.nineJavaB;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class question6 {
    private static long primary(int[] a, int[] b, int[] c, int N){
        long count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(a[i] < b[j] && b[j] < c[k]) count++;
                }
            }
        }
        return count;
    }
    private static long f(int[] a, int[] b, int[] c, int N){
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        long total = 0;
        int l = 0, r = 0;
        for(int i = 0; i < N; i++){
            while (l < N && a[l] < b[i])l++;
            while (r < N && c[r] <= b[i])r++;
            total += l * (N - r);
        }
        return total;
    }
    private static void print(int[] a){
        for(int i =0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.print('\n');
    }
    public static void main(String[] args){
        int[] a, b, c;
        int N;
        if(false){
            Scanner in = new Scanner(System.in);
            N = in.nextInt();
            in.nextLine();
            // 只有a, b, c三组， 使用3个一维数组代码可读性更强，也易于编写
            a = new int[N];
            b = new int[N];
            c = new int[N];

            // 用for循环读入数据， 因为只有a, b, c三组， 所以复制就好啦

            for(int i = 0; i < N; i++){
                a[i] = in.nextInt();
            }
            in.nextLine();

            for(int i = 0; i < N; i++){
                b[i] = in.nextInt();
            }
            in.nextLine();

            for(int i = 0; i < N; i++){
                c[i] = in.nextInt();
            }
        }else{
            N = 100000;
            int max = 100000;
            a = new int[N];
            b = new int[N];
            c = new int[N];
            for(int i = 0; i < N; i++){
                a[i] = new Random().nextInt(max);
            }
            for(int i = 0; i < N; i++){
                b[i] = new Random().nextInt(max);
            }
            for(int i = 0; i < N; i++){
                c[i] = new Random().nextInt(max);
            }
            System.out.println(N);
            Arrays.sort(a);
            Arrays.sort(b);
            Arrays.sort(c);
            if(false){
                print(a);
                print(b);
                print(c);
            }
        }
        // 写代码就是复制


//        long start = System.currentTimeMillis();
//        System.out.println(primary(a, b, c, N));
//        System.out.println(System.currentTimeMillis() - start);

        long start = System.currentTimeMillis();
        System.out.println(f(a, b, c, N));
        System.out.println(System.currentTimeMillis() - start);
    }
}
