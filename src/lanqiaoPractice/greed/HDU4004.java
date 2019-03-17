package lanqiaoPractice.greed;

import java.util.Arrays;
import java.util.Scanner;

public class HDU4004 {
    private static boolean check(int[] pos, int n, int m, int dist){
        int i = 0;
        int s = 0;
        int t = 0;
        while (true){
            while (i < n && pos[i++] - s <= dist);
            s = pos[i - 1];
            if(i == n) return ++t <= m;
            if(++t > m) return false;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (true){
            int L = in.nextInt(), n = in.nextInt(), m = in.nextInt();
            in.nextLine();
            int[] pos = new int[n];
            for(int i = 0; i < n; i++){
                pos[i] = Integer.parseInt(in.nextLine());
            }
            Arrays.sort(pos);
            int low = Math.max(L / m, L - pos[n - 1]), high = L;
            while(low <= high){
                int mid = (low + high) / 2;
                if(check(pos, n, m, mid)){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            if(!check(pos, n, m, low)) low++;
            System.out.println(low);
        }
    }
}
