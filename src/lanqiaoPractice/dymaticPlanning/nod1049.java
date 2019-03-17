package lanqiaoPractice.dymaticPlanning;

import java.io.*;

public class nod1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int n = Integer.parseInt(reader.readLine());
        long nextInt, thisSum = 0, maxSum = 0;
        for(int i = 0; i < n; i++){
            nextInt = Integer.parseInt(reader.readLine());
            thisSum += nextInt;
            if(thisSum > maxSum){
                maxSum = thisSum;
            }else if(thisSum < 0){
                thisSum = 0;
            }
        }
        writer.write(maxSum + "");
        writer.flush();
    }
}
