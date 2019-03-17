package lanqiaoPractice.dymaticPlanning;

import java.io.*;

public class nod1006 {
    static BufferedWriter writer;
    private static void f(char[] x, char[] y) throws  IOException{
        int m = x.length, n = y.length;
        int[][] c = new int[m + 1][n + 1];
        int[][] b = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            c[i][0] = 0;
        }
        for(int j = 0; j < m + 1; j++){
            c[0][j] = 0;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(x[i - 1] == y[j - 1]){
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 0;
                }else{
                    int p = c[i - 1][j], q = c[i][j - 1];
                    if(p > q){
                        c[i][j] = p;
                        b[i][j] = 1;
                    }else{
                        c[i][j] = q;
                        b[i][j] = -1;
                    }
                }
            }
        }
        printLCS(b, x , m, n);
    }
    private static void printLCS(int[][] b, char[] x, int i, int j) throws IOException{
        if(i == 0 || j == 0){
            return;
        }
        if(b[i][j] == 0){
            printLCS(b, x, i - 1, j - 1);
            writer.write(x[i - 1] + "");
        }else if(b[i][j] == 1){
            printLCS(b, x, i - 1, j);
        }else{
            printLCS(b, x, i, j - 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        char[] x = reader.readLine().toCharArray(), y = reader.readLine().toCharArray();
        f(x, y);
        writer.flush();
    }
}
