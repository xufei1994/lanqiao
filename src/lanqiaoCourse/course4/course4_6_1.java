package lanqiaoCourse.course4;

import java.math.BigInteger;

public class course4_6_1 {

    private static BigInteger gcd(BigInteger a, BigInteger b){
        if(a.compareTo(b) < 0){
            return gcd(b, a);
        }
        BigInteger r;
        BigInteger zero = new BigInteger("0");
        do{
            BigInteger divideAndRemainder[] = a.divideAndRemainder(b);
            a = b;
            r = divideAndRemainder[1];
            b = r;
        }while (r.compareTo(zero) > 0);
        return a;
    }
    public static void main(String[] args){
        BigInteger a = new BigInteger("1"), b = new BigInteger("2"), c, d;
        for(int i = 3; i <= 100; i++){
            c = new BigInteger(i+"");
            a = a.multiply(c).add(b);
            b = b.multiply(c);

            d = gcd(a, b);
            a = a.divide(d);
            b = b.divide(d);
        }
        System.out.println(a.divide(b).toString());
    }
}
