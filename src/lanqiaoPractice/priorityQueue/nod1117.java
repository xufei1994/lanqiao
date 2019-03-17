package lanqiaoPractice.priorityQueue;

import java.io.*;
import java.util.PriorityQueue;

public class nod1117 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        PriorityQueue<Integer> items = new PriorityQueue<>();
        int N = Integer.parseInt(reader.readLine());
        for(int i = 0; i < N; i++){
            items.add(Integer.parseInt(reader.readLine()));
        }
        int r = 0;

        while (items.size() >= 2){
            int p = items.poll(), q = items.poll();
            r += p + q;
            items.add(p + q);
        }
        writer.write(r + "");
        writer.flush();
    }
}
