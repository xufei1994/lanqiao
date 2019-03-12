package lanqiaoPractice.sort;

import java.io.*;
import java.util.Arrays;

public class nod1097 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int N = Integer.parseInt(reader.readLine());
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(a[i]);
        }
        writer.write(sb.toString());
        writer.flush();
    }
}
