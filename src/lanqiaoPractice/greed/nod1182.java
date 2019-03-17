package lanqiaoPractice.greed;

import java.io.*;
import java.util.Arrays;

public class nod1182 {
    private static class Counter implements Comparable<Counter>{
        int count = 0;
        int id;
        int v;
        Counter(int id){
            this.id = id;
        }

        @Override
        public int compareTo(Counter o) {
            return count - o.count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        Counter[] counters = new Counter[26];
        for(int i = 0; i < 26; i++){
            counters[i] = new Counter(i);
        }
        char[] a = reader.readLine().toLowerCase().toCharArray();
        for(char c: a){
            counters[c - 'a'].count++;
        }
        Arrays.sort(counters);

        int r = 0;
        for(int i = 0; i < 26; i++){
            r += (i + 1) * counters[i].count;
        }
        writer.write(r + "");
        writer.flush();
    }
}
