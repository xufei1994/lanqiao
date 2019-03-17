package lanqiaoPractice.dymaticPlanning;
import java.io.*;

public class nod1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int N = Integer.parseInt(reader.readLine());
        int[][] f = new int[N][];
        String[] s;
        f[0] = new int[]{Integer.parseInt(reader.readLine())};
        for(int i = 1; i < N; i++){
            f[i] = new int[i + 1];
            s = reader.readLine().split("\\s+");
            f[i][0] = f[i - 1][0] + Integer.parseInt(s[0]);
            for(int j = 1; j < i; j++){
                f[i][j] = Math.max(f[i - 1][j - 1], f[i - 1][j]) + Integer.parseInt(s[j]);
            }
            f[i][i] = f[i - 1][i - 1] + Integer.parseInt(s[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int t : f[N - 1]){
            if(t > max) max = t;
        }
        writer.write(max + "");
        writer.flush();
    }
}
