package primary.nineJavaB;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

public class question3 {
    private static BigInteger Two = new BigInteger("2");
    // (a+bi)^2 = (a^2-b^2) + (2*a*b)*i

    // 法1：使用递归实现反复平方法
    private static int[] f(int[] c, int p){
        if(p == 1) return c;
        // 如果幂正好是偶数，那不断递归下去就可以
        if(p % 2 == 0){
            return f(new int[]{c[0] * c[0] - c[1] * c[1], 2 * c[0] * c[1]}, p / 2);
        }else{
            // 反之要先算p/2再乘以1次，比如p=5, 5 //2 = 2, 5 = 1 + 5 // 2;(这里用//代表整除)
            int[] c0 = f(new int[]{c[0] * c[0] - c[1] * c[1], 2 * c[0] * c[1]}, p / 2);

            // (a+bi) * (c+di) = (ac-bd) + (ad + bc)i
            return new int[]{c[0] * c0[0] - c[1] * c0[1], c[0] * c0[1] + c[1] * c0[0]};
        }
    }

    private static int[] f2(int[] c, int p){
        while (p > 1){
            if(p % 2 == 0){
                // 想一下这里为什么要设置a, b， 而不直接对c[0], c[1]赋值
                // 当然可以用一个t变量而不是a,b两个变量，这样更优一点，但是可读性也差点
                int a = c[0] * c[0] - c[1] * c[1];
                int b = 2 * c[0] * c[1];
                c[0] = a;
                c[1] = b;
            }else{
                int a = c[0] * c[0] - c[1] * c[1];
                int b = 2 * c[0] * c[1];

                int m = c[0] * a - c[1] * b;
                int n = c[0] * b + c[1] * a;

                c[0] = m;
                c[1] = n;
            }
            p /= 2;
        }
        return c;
    }

    private static BigInteger[] f(BigInteger[] c, BigInteger p){
        if(p.toString().equals("1")) return c;
        if(p.mod(Two).toString().equals("0")){
            return f(new BigInteger[]{c[0].multiply(c[0]).subtract(c[1].multiply(c[1])), Two.multiply(c[0]).multiply(c[1])}, p.divide(Two));
        }else{
            BigInteger[] c0 = f(new BigInteger[]{c[0].multiply(c[0]).subtract(c[1].multiply(c[1])), Two.multiply(c[0]).multiply(c[1])}, p.divide(Two));

            return new BigInteger[]{c[0].multiply(c0[0]).subtract(c[1].multiply(c0[1])), c[0].multiply(c0[1]).add(c[1].multiply(c0[0]))};
        }
    }
    // 法2：使用循环实现反复平方法
    public static void main(String[] args) throws Exception{
        // 测试一下，没问题
        int[] c0 = f(new int[]{2, 3}, 5);
        System.out.println(c0[0] + "+(" + c0[1] + "i)");

        int[] c2 = f2(new int[]{2, 3}, 5);
        System.out.println(c2[0] + "+(" + c2[1] + "i)");


        BigInteger[] c1 = f(new BigInteger[]{new BigInteger("2"), new BigInteger("3")}, new BigInteger("123456"));

        int cmp = c1[1].compareTo(new BigInteger("0"));
        String b;
        if(cmp > 0){
            b = "+" + c1[1].toString();
        }else if(cmp < 0){
            b = c1[1].toString();
        }else{
            b = "";
        }

        System.setOut(new PrintStream(new BufferedOutputStream(
                new FileOutputStream("print.txt")),true));
        System.out.print(c1[0].toString() + b);
    }
}
