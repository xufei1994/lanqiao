package primary.sevenJavaB;

import java.util.*;
// 使用map和set做就可以，不需要线段树等的优化
public class question10 {
    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private static int count(int[] a, int p, int q){
        Set<Integer>  set = new HashSet<>();
        for(int i = p + 1; i < q; i++){
            set.add(a[i]);
        }
        return set.size();
    }
    private static void f(int[] a, int[] b, int N, boolean print){
        int e;
        for(int i = 0; i < N; i++){
            e = a[i];
            if(map.containsKey(e)){
                b[i] = count(a, map.get(e), i);
                map.replace(e, i);
            }else{
                b[i] = -e;
                map.put(e, i);
            }
        }
        if(print){
            for(int i = 0, l = N - 1; i < l; i++){
                System.out.print(b[i]);
                System.out.print(' ');
            }
            System.out.print(b[N - 1]);
        }
    }
    public static void main(String[] args){
        int N;
        int[] a, b;
        // if为true则接受控制台输入，并打印结果
        // 反之，自动生成数据，不打印结果，并输出程序运行时间
        if(true){
            Scanner in = new Scanner(System.in);
            N = in.nextInt();
            a = new int[N];
            b = new int[N];
            in.nextLine();
            for(int i = 0; i < N; i++){
                a[i] = in.nextInt();
            }
            f(a, b, N, true);
        }else{
            N = 100000;
            a = new int[N];
            b = new int[N];
            for(int i = 0; i < N; i++){
                a[i] = (int)(Math.random() * 1000000000);
            }
            long start = System.currentTimeMillis();
            f(a, b, N, false);
            System.out.print(System.currentTimeMillis() - start);
        }

    }
}
