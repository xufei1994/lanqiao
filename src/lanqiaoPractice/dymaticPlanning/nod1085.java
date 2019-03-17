package lanqiaoPractice.dymaticPlanning;
import java.io.*;
public class nod1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        String[] s = reader.readLine().split("\\s+");
        int N = Integer.parseInt(s[0]), W = Integer.parseInt(s[1]);
        int[] weights = new int[N], prices = new int[N];
        for(int i = 0; i < N; i++){
            s = reader.readLine().split("\\s+");
            weights[i] = Integer.parseInt(s[0]);
            prices[i] = Integer.parseInt(s[1]);
        }
        int[][] f = new int[N + 1][W + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= W; j++){
                f[i][j] = weights[i - 1] > j ? f[i - 1][j] : Math.max(f[i - 1][j], f[i - 1][j - weights[i - 1]] + prices[i - 1]);
            }
        }
        writer.write(f[N][W] + "");
        writer.flush();
    }
}
