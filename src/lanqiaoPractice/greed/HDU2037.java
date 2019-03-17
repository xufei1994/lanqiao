package lanqiaoPractice.greed;

import java.util.Arrays;
import java.util.Scanner;

public class HDU2037 {
    private static class Program implements Comparable<Program>{
        int s;
        int e;
        Program(int s, int e){
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Program o) {
            return e - o.e;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (true){
            int N = in.nextInt();
            if(N == 0) break;
            in.nextLine();
            Program[] programs = new Program[N];
            for(int i = 0; i < N; i++){
                programs[i] = new Program(in.nextInt(), in.nextInt());
                in.nextLine();
            }
            Arrays.sort(programs);
            int res = 1;
            int end = programs[0].e;
            for(int i = 1; i < N; i++){
                if(programs[i].s >= end){
                    res++;
                    end = programs[i].e;
                }
            }
            if(programs[N - 1].s >= end) res++;
            System.out.println(res);
        }
    }
}
