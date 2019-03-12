package lanqiaoPractice.binarySearch;

import java.io.*;

public class nod1010 {
    private static int[] factor = new int[]{2, 3, 5};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int T = Integer.parseInt(reader.readLine());
        long[] a = new long[T];
        long max = 0, t;
        for(int i = 0; i < T; i++){
            t = Long.parseLong(reader.readLine());
            if(t > max) max = t;
            a[i] = t;
        }
        writer.flush();
    }
}
