package lanqiaoPractice.calculation;

import java.util.Scanner;

public class HDU1061 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        while (T-- > 0){
            long N = Long.parseLong(in.nextLine());
            long p = N;
            long r = 1;
            while (p > 0){
                if(p % 2 == 1){
                    r = (r * N) % 10;
                }
                N = (N * N) % 10;
                p /= 2;
            }
            System.out.println(r % 10);
        }
    }
}
