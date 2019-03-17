package lanqiaoPractice.greed;

import java.io.*;

public class nod1344 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int N = Integer.parseInt(reader.readLine());
        long max = 0;
        long sum = 0;
        for(int i = 0; i < N; i++){
            sum += Integer.parseInt(reader.readLine());
            if(sum < 0 && -sum > max){
                max = -sum;
            }
        }
        writer.write(max + "");
        writer.flush();
    }
}
