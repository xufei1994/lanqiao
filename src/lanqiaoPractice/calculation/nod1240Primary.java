package lanqiaoPractice.calculation;

import java.util.Scanner;

public class nod1240Primary {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int L = (int)Math.sqrt(N);
        boolean[] marked = new boolean[L + 1];
        int[] primer = new int[L + 1];
        int count = 0;
        int r;
        // 欧拉筛法
        // 见博客 https://blog.csdn.net/chczy1/article/details/80327323
        for(int i = 2; i <= L; i++){
            if(!marked[i]){
                marked[i] = true;
                primer[count++] = i;
            }
            for(int j = 0; j < count; j++){
                r = primer[j] * i;
                if(r > L) break;
                marked[r] = true;
                if(i % primer[j] == 0) break;
            }
        }
    }
}
