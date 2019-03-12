package lanqiaoPractice.sort;

import java.io.*;
import java.util.Arrays;

public class nod1090 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int N = Integer.parseInt(reader.readLine());
        long[] a = new long[N];
        for(int i = 0; i < N; i++){
            a[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(a);
        boolean flag = false;
        for(int i = 0, l = N - 3; i < l; i++){
            for(int j = i + 1; j < N; j++){
                for(int k = j + 1; k < N; k++){
                    int index = Arrays.binarySearch(a, k + 1, N, - a[i] - a[j] - a[k]);
                    if(index < 0) continue;
                    System.out.printf("%d %d %d\n", a[i], a[j], a[index]);
                    flag = true;
                }
            }
        }
        if(!flag) System.out.print("No Solution");
        writer.flush();
    }
}
