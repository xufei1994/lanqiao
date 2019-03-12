package lanqiaoPractice.sort;

import java.util.Arrays;
import java.util.Scanner;

public class POJ1007X2 {
    private static class MergeSort{
        static char[] c;
        static char[] aux;
        static int N;
        static int count = 0;
        private MergeSort(){ }
        static int sort(String s){
            c = s.toCharArray();
            N = c.length;
            aux = Arrays.copyOf(c, N);
            count = 0;
            sort(aux, c, 0, N - 1);
            return count;
        }
        static void merge(char[] c, char[] aux, int lo, int mid, int hi){
            int i = lo, j = mid + 1, k = lo;
            while (k <= hi){
                if(i > mid){
                    aux[k++] = c[j++];
                }else if(j > hi){
                    aux[k++] = c[i++];
                }else if(c[i] <= c[j]){
                    aux[k++] = c[i++];
                }else{
                    count += (mid - i + 1);
                    aux[k++] = c[j++];
                }
            }
        }
        static void sort(char[] c, char[] aux, int lo, int hi){
            if(lo >= hi) return;
            int mid = (lo + hi) / 2;
            sort(aux, c, lo, mid);
            sort(aux, c, mid + 1, hi);
            if(c[mid] < c[mid + 1]){// 已经有序时跳过merge(a中lo到mid mid到hi分别都是有序的)
                System.arraycopy(c, lo, aux, lo, hi - lo + 1);
                return;
            }
            merge(c, aux, lo, mid, hi);
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
