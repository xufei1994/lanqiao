package lanqiaoPractice.greed;

import java.util.Arrays;
import java.util.Scanner;

public class HDU1052 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (true){
            int N = in.nextInt();
            if(N == 0) break;
            in.nextLine();
            int[] a = new int[N];
            for(int i = 0; i < N; i++){
                a[i] = in.nextInt();
            }
            in.nextLine();

            int[] b = new int[N];
            for(int i = 0; i < N; i++){
                b[i] = in.nextInt();
            }
            in.nextLine();

            Arrays.sort(a);
            Arrays.sort(b);
            int i = 0, j = 0, p = N - 1, q = N - 1;
            int res = 0;
            while (i <= p){
                if(a[p] > b[q]){
                    p--;
                    q--;
                    res++;
                }else if(a[i] > b[j]){
                    i++;
                    j++;
                    res++;
                }else{
                    if(a[i] < b[q]) res--;
                    i++;
                    q--;
                }
            }
            System.out.println(res * 200);
        }
    }
}
