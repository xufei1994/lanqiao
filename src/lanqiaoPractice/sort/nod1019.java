package lanqiaoPractice.sort;

import java.io.*;
import java.util.Arrays;

public class nod1019 {
    private static class MergeSort{
        static int[] aux;
        static int N;
        static int count = 0;
        private MergeSort(){ }
        static int sort(int[] c){
            N = c.length;
            aux = Arrays.copyOf(c, N);
            count = 0;
            sort(aux, c, 0, N - 1);
            return count;
        }
        static void merge(int[] c, int[] aux, int lo, int mid, int hi){
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
        static void sort(int[] c, int[] aux, int lo, int hi){
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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int N = Integer.parseInt(reader.readLine());
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = Integer.parseInt(reader.readLine());
        }
        writer.write(MergeSort.sort(a) + "");
        writer.flush();
    }
}
