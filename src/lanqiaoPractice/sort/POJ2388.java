package lanqiaoPractice.sort;

import java.io.*;

public class POJ2388 {
    private static int[] a;
    private static void swap(int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static int get(int k, int l, int r){
        int v = a[l];
        int i = l, j = r + 1;
        while (i <= j){
            while (a[++i] <= v){
                if(i == r) break;
            }
            while (a[--j] >= v){
                if(j == l) break;
            }
            if(i >= j) break;
            swap(i, j);
        }
        swap(j, l);
        if(j - l + 1 == k) return a[j];
        else if(j - l + 1 < k) return get(k - j + l - 1, j + 1, r);
        else return get(k, l, j);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int N = Integer.parseInt(reader.readLine());
        a = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = Integer.parseInt(reader.readLine());
        }
        writer.write(get(N / 2 + 1, 0, N - 1) + "");
        writer.flush();
    }
}
