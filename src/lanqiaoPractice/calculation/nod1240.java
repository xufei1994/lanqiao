package lanqiaoPractice.calculation;

import java.io.*;
public class nod1240{
    private static boolean isPrim(int n){

        for(int i = n, l = (int)Math.sqrt(n); i < l; i += 2){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static int f(int n){
        int count = 0;
        for(int k = 2, l = (int)Math.sqrt(n); k < l; k++){
            if(n % k == 0){
                if(n % (k * k) == 0){
                    return 0;
                }
                if(isPrim(k)){
                    count++;
                }
            }
        }
        if(isPrim(n)){
            count++;
        }
        return count % 2 == 0 ? 1 : -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int n = f(Integer.parseInt(reader.readLine()));
        writer.write(n + "");
        writer.flush();
    }
}