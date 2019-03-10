package lanqiaoPractice.uf;

import java.io.*;

public class LA3027 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0){
            int N = Integer.parseInt(reader.readLine());
            int[] dist = new int[N + 1];
            int[] id = new int[N + 1];
            for(int i = 1; i <= N; i++) id[i] = i;
            String line;
            String[] parm;
            while (true){
                line = reader.readLine();
                if(line.equals("O")) break;
                parm = line.split("\\s+");
                if(parm.length == 3){
                    int u = Integer.parseInt(parm[1]), v = Integer.parseInt(parm[2]);
                    id[u] = v;
                    dist[u] =  Math.abs(u - v) % 1000;
                }else{
                    int d = 0;
                    for(int x = Integer.parseInt(parm[1]); x != id[x]; x = id[x]){
                        d += dist[x];
                    }
                    writer.write(d + "\n");
                }
            }
        }
        writer.flush();
    }
}