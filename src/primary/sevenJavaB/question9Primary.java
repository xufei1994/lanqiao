package primary.sevenJavaB;

import java.util.Arrays;
import java.util.Scanner;
// 暴力模拟 会超时
public class question9Primary {
    private static char[] symbol = new char[]{'+', '-', '0'};
    private static int[] v = new int[3];
    // 0 1 2分别代表赢 输 和平局
    private static int f(int n, int p, int q, boolean myTime){
        if(n < v[0]){
            if(p % 2 == 1 && q % 2 == 1) return 2;
            if(p % 2 == 1) return 0;
            if(q % 2 == 1) return 1;
            return 2;
        }
        boolean canPing = false;
        // 遍历可取球数， 注意循环的条件
        for(int i = 0; i < 3 && v[i] <= n; i++){
            int cmp = myTime ? f(n - v[i], p + v[i], q, !myTime) : f(n - v[i], p, q + v[i], !myTime);
            // 如果有一种方案能赢，直接弹出到最上层，能赢
            if(cmp == 0){
                return 0;
            }else if(cmp == 2){// 如果有一种方案能平，标记能平
                canPing = true;
            }
        }
        // 如果没有被标记能平，那么一定会输了
        return canPing ? 2 : 1;
    }
    private static char f(int n){
        return symbol[f(n, 0, 0, true)];
    }
    public static void main(String[] args){
        // true为输入输出， false为生成模拟数据
        if(true){
            Scanner in = new Scanner(System.in);
            int T = 5;
            v = new int[3];
            for(int i = 0; i < 3; i++){
                v[i] = in.nextInt();
            }
            Arrays.sort(v);
            in.nextLine();
            for(int i = 0; i < T - 1; i++){
                System.out.print(f(in.nextInt()));
                System.out.print(' ');
            }
            System.out.print(f(in.nextInt()));
            System.out.print(' ');
        }else{
            // 当可取球数特别小，而初始球数大时， 运行时间最长
            for(int i = 0; i < 3; i++){
                v[i] = (int)(Math.random() * 5);
            }
            Arrays.sort(v);
            long start = System.currentTimeMillis();
            for(int i = 0; i < 4; i++){
                System.out.print(f((int)(Math.random() * 10) + 990));
                System.out.print(' ');
            }
            System.out.print(f((int)(Math.random() * 10) + 990));
            System.out.printf("\ncost:%d", System.currentTimeMillis() - start);
        }
    }
}
