package primary.sixJavaB;

import java.util.Scanner;

public class question8 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = N;
        while (true){
            if(M < 3)break;
            int t = M / 3;
            N += t;
            M -= 2 * t;
        }
        System.out.print(N);
    }
}
