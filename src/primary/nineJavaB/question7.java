package primary.nineJavaB;

import java.util.Scanner;

public class question7 {
    // 对于左上角的点p(x, y) x = -a, y = a
    // 把它的螺旋线分为横纵两组线段
    // 每一组线段之和分别为 1，2，3， ... 2a - 1
    // 所以左上角的点到原点的距离为
    // 2 * (1+2+3+...+2a-1) 用一下求和公式得 (1 + 2a - 1) * (2a - 1)
    // 这样，任意一点到原点的螺旋线的长度就转化为
    // 这一点到最近的左上角的点的折线长加上左上角的点到原点的折线长
    // 根据数据大小，int型的范围可能不够 我们使用long型
    private static long g(long a){
        long t = 2 * a - 1;
        return (1 + t) * t;
    }
    private static long f(int x, int y){
        // 分8种情况考虑， 这里比较简单，注意正负号就行
        if(x >= 0){
           if(y >= 0){
               if(x <= y){
                   return x + y + g(y);
               }else{
                   return 2 * x + (x - y) + g(x);
               }
           }else{
               if(x <= -y){
                   return 2 * (2 * y - 1) + x + g(-y+1);
               }else{
                   return x * 3 - y + g(x);
               }
           }
        }else{
            if(y > 0){
                if(-x <= y){
                    return x + y + g(y);
                }else{
                    return -x - y + g(-x);
                }
            }else{
                if(x < y){
                    return x + y + g(- y + 1);
                }else{
                    return y + 2 * (y - 1) - x + g(- y + 1);
                }
            }
        }
    }
    public static void main(String[] args){
        if(false){
            Scanner in = new Scanner(System.in);
            int x = in.nextInt(), y = in.nextInt();
            System.out.print(f(x, y));
        }else{
//            // 最好把8种情况都测试一下
            System.out.println(f(1, 2)); // 14
            System.out.println(f(3, 2)); // 35
            System.out.println(f(-1, 2)); // 15
            System.out.println(f(-3, 2)); // 35
            System.out.println(f(1, -2)); // 5
            System.out.println(f(3, -2)); // 19
            System.out.println(f(-1, -2)); // 36
            System.out.println(f(-3, -2)); // 64

        }

    }
}
