package lanqiaoPractice.calculation;

import java.util.Scanner;

public class POJ3070 {
    private static class Matrix2{
        long[][] v;
        Matrix2(long a11, long a12, long a21, long a22){
            v = new long[][]{{a11, a12}, {a21, a22}};
        }
        public Matrix2 multiply(Matrix2 o, int mod){
            return new Matrix2(
                    (v[0][0] * o.v[0][0]) % mod + (v[0][1] * o.v[1][0]) % mod,
                    (v[0][0] * o.v[0][1]) % mod + (v[0][1] * o.v[1][1]) % mod,
                    (v[1][0] * o.v[0][0]) % mod + (v[1][1] * o.v[1][0]) % mod,
                    (v[1][0] * o.v[0][1]) % mod + (v[1][1] * o.v[1][1]) % mod
                    );
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int MOD = 10000;
        while (true){
            int N = Integer.parseInt(in.nextLine());
            if(N == -1) break;
            Matrix2 R = new Matrix2(1, 0, 0, 1);
            Matrix2 A = new Matrix2(1, 1, 1, 0);
            while (N > 0){
                if(N % 2 == 1){
                    R = R.multiply(A, MOD);
                }
                A = A.multiply(A, MOD);
                N /= 2;
            }
            System.out.println(R.v[0][1] % MOD);
        }
    }
}
