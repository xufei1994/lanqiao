package lanqiaoPractice.calculation;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class nod1186 {
    private static List<Integer> eulerSeize(int N){
        boolean[] marked = new boolean[N + 1];
        List<Integer> prim = new ArrayList<>();
        int r;
        for(int i = 2; i < N; i++){
            if(!marked[i]){
                prim.add(i);
            }
            for(int p : prim){
                r = p * i;
                if(r > N) break;
                marked[r] = true;
            }
        }
        return prim;
    }
    private static boolean check(List<Integer> prim, int n){
        int l = (int)Math.sqrt(n);
        for(int p : prim){
            if(p > l) break;
            if(n % p == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        List<Integer> prim = eulerSeize((int)Math.sqrt((int)1e9) + 1);
        String s = reader.readLine();
        if(s.length() > 9){
            BigInteger n = new BigInteger(s);
            writer.write(n.isProbablePrime(4) ? "Yes\n" : "No\n");
        }else{
            writer.write(check(prim, Integer.parseInt(s)) ? "Yes\n" : "No\n");
        }
        writer.flush();
    }
}
