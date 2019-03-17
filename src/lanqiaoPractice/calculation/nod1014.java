package lanqiaoPractice.calculation;

import java.io.*;

public class nod1014 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        String[] s = reader.readLine().split("\\s+");
        long P = Integer.parseInt(s[0]), A = Integer.parseInt(s[1]);
        long x = 0;
        boolean flag = false;
        while (x <= P){
            if((x * x) % P == A){
                flag = true;
                writer.write(x + " ");
            }
            x++;
        }
        if(!flag){
            writer.write("No Solution");
        }
        writer.flush();
    }
}
