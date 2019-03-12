package lanqiaoPractice.sort;

import java.io.*;
import java.util.Arrays;

public class nod1267 {
    private static boolean f(int[] a, int N){
        for(int i = 0, l = N - 3; i < l; i++){
            for(int j = i + 1; j < N; j++){
                for(int k = j + 1; k < N; k++){
                    int index = Arrays.binarySearch(a, k + 1, N, - a[i] - a[j] - a[k]);
                    if(index < 0) continue;
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int N = Integer.parseInt(reader.readLine());
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(a);
        System.out.print(f(a, N) ? "Yes" : "No");
        writer.flush();
    }
}
