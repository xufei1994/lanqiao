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


        // 用f[i]代表b[i] > a[j]成立的取值中， j的取值个数
        int[] f = new int[N];

        // 因为b已经排序，所以b[i+1] > a[j]的组合数一定大于等于 b[j] > a[j]的组合数
        int fromIndex = 0;
        for(int i = 0; i < N; i++){
            // binarySearch测试
            // 详细看Arrays.binarySearch的函数说明，找不到元素则返回
            // t = -(<i>insertion point</i>) - 1
            //所以 insertion point = - t - 1
            // 例子1：
            // int t = Arrays.binarySearch(new int[]{3,6,9,13,18}, 13);
            // System.out.print(t);
            // t为3， 则小13的值的个数有 3个

            // 例子2：
            // int t = Arrays.binarySearch(new int[]{3,6,9,13,18}, 11);
            // System.out.print(t);
            // t为-4， 则小11的值的个数有 - t - 1


            int t = Arrays.binarySearch(a, Math.max(0, fromIndex), N, b[i]);

            // 把t为负数转化为t为正数来处理，减少代码量和处理复杂度
            if(t < 0) t = -t - 1;

            // 考虑重复值的情况 比如 {3, 4, 4, 7, 9}
            // 二分查找后可能搜索到第二个4 也就是下标为3， 这时候需要不停向左移动，直到左边的数更小为止
            while ((t - 1) >= 0 && a[t - 1] == a[t]) t--;
            f[i] = t;
            fromIndex = t;
                // 如果t=0,则b[i] = a[0], 因为a也已经排序， 所以f[i] = 0。 这里也不需要更新fromIndex了

        }

        // 用同样的方法处理c组和b组；
        int[] g = new int[N];
        fromIndex = 0;
        for(int i = 0; i < N; i++){
            int t = Arrays.binarySearch(b, Math.max(0, fromIndex), N, c[i]);
            if(t < 0) t = -t - 1;
            while ((t - 1) >= 0 && b[t - 1] == b[t]) t--;
            g[i] = t;
            fromIndex = t;
        }

        // 法一：先考虑c[i] > b[j] 有几个， 再考虑b[p] > a[k] , p = max(j), max(j) - 1,...0
        long count = 0;
        for(int i = 0; i < N; i++){
            for(int j = g[i] - 1; j >= 0; j--){
                count += f[j];
            }
        }
        return count;
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
            N = 1000;
            int max = 10;
            a = new int[N];
            b = new int[N];
            c = new int[N];
//            System.out.println(N);
            for(int i = 0; i < N; i++){
                a[i] = new Random().nextInt(max);
//                System.out.print(a[i] + " ");
            }
            System.out.print("\n");
            for(int i = 0; i < N; i++){
                b[i] = new Random().nextInt(max);
//                System.out.print(b[i] + " ");
            }
            System.out.print("\n");
            for(int i = 0; i < N; i++){
                c[i] = new Random().nextInt(max);
//                System.out.print(c[i] + " ");
            }
            System.out.print("\n");
        }
        // 写代码就是复制
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        long start = System.currentTimeMillis();
        System.out.println(primary(a, b, c, N));
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.println(f(a, b, c, N));
        System.out.println(System.currentTimeMillis() - start);

    }
}
