package lanqiaoPractice.sort;

import java.util.Arrays;
import java.util.Scanner;

public class POJ1007X1 {
    private static class MergeSort{
        static char[] c;
        static char[] aux;
        static int N;
        static int count = 0;
        private MergeSort(){ }
        static int sort(String s){
            c = s.toCharArray();
            N = c.length;
            aux = new char[N];
            count = 0;
            sort(0, N - 1);
            return count;
        }
        static void merge(int lo, int mid, int hi){
            int i = lo, j = mid + 1, k = lo;
            System.arraycopy(c, lo, aux, lo, hi - lo + 1);
            // [2,5,7]  [1,3,6]
            while (k <= hi){
                if(i > mid){
                    c[k++] = aux[j++];
                }else if(j > hi){
                    c[k++] = aux[i++];
                }else if(aux[i] <= aux[j]){
                    c[k++] = aux[i++];
                }else{
                    count += (mid - i + 1);
                    c[k++] = aux[j++];
                }
            }
        }
        static void sort(int lo, int hi){
            if(lo >= hi) return;
            int mid = (lo + hi) / 2;
            sort(lo, mid);
            sort(mid + 1, hi);
            merge(lo, mid, hi);
        }
    }
    private static class Item implements Comparable<Item>{
        String s;
        int v;
        Item(String s, int M){
            this.v = MergeSort.sort(s);
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