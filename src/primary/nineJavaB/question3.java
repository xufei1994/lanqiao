package primary.nineJavaB;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

public class question3 {
    private static BigInteger Two = new BigInteger("2");
    // (a+bi)^2 = (a^2-b^2) + (2*a*b)*i
    // (a+bi)*(c+di) = (ac-bd) + (ad + bc)*i
    // 递归写法
    private static int[] recursion(int[] c, int p){
        if(p == 1) return c;
        // 如果幂正好是偶数，那不断递归下去就可以
        if(p % 2 == 0){
            return recursion(new int[]{c[0] * c[0] - c[1] * c[1], 2 * c[0] * c[1]}, p / 2);
        }else{
            // 反之要先算p/2再乘以1次，比如p=5, 5 //2 = 2, 5 = 1 + 5 // 2;(这里用//代表整除)
            int[] c0 = recursion(new int[]{c[0] * c[0] - c[1] * c[1], 2 * c[0] * c[1]}, p / 2);
            // (a+bi) * (c+di) = (ac-bd) + (ad + bc)i
            return new int[]{c[0] * c0[0] - c[1] * c0[1], c[0] * c0[1] + c[1] * c0[0]};
        }
    }
    // 大数类的递归写法
    private static BigInteger[] recursion(BigInteger[] c, BigInteger p){
        if(p.toString().equals("1")) return c;
        if(p.mod(Two).toString().equals("0")){
            return recursion(new BigInteger[]{c[0].multiply(c[0]).subtract(c[1].multiply(c[1])), Two.multiply(c[0]).multiply(c[1])}, p.divide(Two));
        }else{
            BigInteger[] c0 = recursion(new BigInteger[]{c[0].multiply(c[0]).subtract(c[1].multiply(c[1])), Two.multiply(c[0]).multiply(c[1])}, p.divide(Two));

            return new BigInteger[]{c[0].multiply(c0[0]).subtract(c[1].multiply(c0[1])), c[0].multiply(c0[1]).add(c[1].multiply(c0[0]))};
        }
    }

    // 循环写法
    private static int[] circulation(int[] c, int p){
        int[] r = new int[]{1, 0};
        while (p > 0){
            if(p % 2 == 1){
                int temp = r[0];
                r[0] = r[0] * c[0] - r[1] * c[1];
                r[1] = temp * c[1] + r[1] * c[0];
            }
            int temp = c[0];
            c[0] = c[0] * c[0] - c[1] * c[1];
            c[1] = 2 * temp * c[1];
            p /= 2;
        }
        return r;
    }

    // 大数类的循环写法， 略
    public static void main(String[] args) throws Exception{
        // 测试一下，没问题
        int[] c0 = recursion(new int[]{2, 3}, 5);
        System.out.println(c0[0] + "+(" + c0[1] + "i)");
        c0 = circulation(new int[]{2, 3}, 5);
        System.out.println(c0[0] + "+(" + c0[1] + "i)");

        BigInteger[] c1 = recursion(new BigInteger[]{new BigInteger("2"), new BigInteger("3")}, new BigInteger("123456"));

        // 得到虚数系数，处理符号，如果为正加正号，为负不加，否则为空
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
