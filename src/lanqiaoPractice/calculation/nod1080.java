package lanqiaoPractice.calculation;

import java.io.*;

public class nod1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int N = Integer.parseInt(reader.readLine()), M, P;
        boolean flag = false;

        for(int i = 0, l = (int)Math.sqrt(N / 2);i <= l;i++){
            M = N - i * i;
            P = (int)Math.sqrt(M);
            if(M == P * P){
                flag = true;
                writer.write(i + " " + P + "\n");
            }
        }
        if(!flag){
            writer.write("No Solution");
        }
        writer.flush();
    }
}
