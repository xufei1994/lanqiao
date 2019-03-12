package lanqiaoPractice.sort;

import java.util.Arrays;
import java.util.Scanner;

public class POJ1007Primary {
    private static class Item implements Comparable<Item>{
        String s;
        int v;
        Item(String s, int M){
            char[] c = s.toCharArray();
            for(int i = 0; i < M; i++){
                char src = c[i];
                if(src == 'A') continue;
                for(int j = i + 1; j < M; j++){
                    if(src > c[j])v++;
                }
            }
            this.s = s;
        }

        @Override
        public int compareTo(Item o) {
            return v - o.v;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        in.nextLine();
        Item[] items = new Item[N];
        for(int i = 0; i < N; i++){
            items[i] = new Item(in.nextLine(), M);
        }
        Arrays.sort(items);
        for(int i = 0; i < N; i++){
            System.out.println(items[i].s);
        }
    }
}
