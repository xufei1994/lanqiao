package lanqiaoPractice.dymaticPlanning;
import java.io.*;
public class nod1118 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        String[] s = reader.readLine().split("\\s+");
        int M = Integer.parseInt(s[0]), N = Integer.parseInt(s[1]);
        int MOD = (int)1e9 + 7;
        int[][] f = new int[M][N];
        for(int i = 0; i < M; i++){
            f[i][0] = 1;
        }
        for(int j = 0; j < N; j++){
            f[0][j] = 1;
        }
        for(int i = 1; i < M; i++){
            for(int j = 1; j < N; j++){
                f[i][j] = (f[i - 1][j] + f[i][j - 1]) % MOD;
            }
        }
        writer.write(f[M - 1][N - 1] + "");
        writer.flush();
    }
}
