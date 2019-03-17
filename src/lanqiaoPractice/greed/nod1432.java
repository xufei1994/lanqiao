package lanqiaoPractice.greed;

import java.util.Arrays;
import java.util.Scanner;

public class nod1432 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        in.nextLine();
        boolean[] marked = new boolean[n];
        long[] a = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(in.nextLine());
        }
        Arrays.sort(a);

        long half = m / 2;
        long k;
        int r = n;
        for(int i = 0; i < n; i++){
            if(!marked[i]){
                k = a[i];
                if(k > half) break;
                int index = Arrays.binarySearch(a, m - k);
                if(index < 0) index = - index - 2;
                while (index > i && marked[index]) index--;
                if(index == i) continue;
                marked[i] = true;
                marked[index] = true;
                r--;
            }
        }
        System.out.print(r);
    }
}
