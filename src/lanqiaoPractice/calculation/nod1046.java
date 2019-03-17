package lanqiaoPractice.calculation;

import java.util.Scanner;

public class nod1046 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long A = in.nextInt(), B = in.nextInt(), C = in.nextInt();
        long r = 1;
        while (B > 0){
            if(B % 2 == 1){
                r = (r * A) % C;
            }
            A = (A * A) % C;
            B /= 2;
        }
        System.out.print(r);
    }
}
