package lanqiaoPractice.dymaticPlanning;
import java.io.*;

public class nod1083 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int N = Integer.parseInt(reader.readLine());
        String[] s = reader.readLine().split("\\s+");
        int[][] f = new int[N][N];
        f[0][0] = Integer.parseInt(s[0]);
        for(int j = 1; j < N; j++){
            f[0][j] = f[0][j - 1] + Integer.parseInt(s[j]);
        }
        for(int i = 1; i < N; i++){
            s = reader.readLine().split("\\s+");
            f[i][0] = f[i - 1][0] + Integer.parseInt(s[0]);
            for(int j = 1; j < N; j++){
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + Integer.parseInt(s[j]);
            }
        }
        writer.write(f[N - 1][N - 1] + "");
        writer.flush();
    }
}
