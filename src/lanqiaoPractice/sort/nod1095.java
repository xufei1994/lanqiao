package lanqiaoPractice.sort;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class nod1095 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int N = Integer.parseInt(reader.readLine());
        Map<String, Integer> originMap = new HashMap<>();
        Map<String, Integer> sortedMap = new HashMap<>();
        while (N-- > 0){
            String line = reader.readLine();
            Integer p = originMap.getOrDefault(line, 0);
            originMap.put(line, p + 1);

            char[] c = line.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);

            Integer q = sortedMap.getOrDefault(sorted, 0);
            sortedMap.put(sorted, q + 1);
        }
        int Q = Integer.parseInt(reader.readLine());
        while (Q-- > 0){
            String line = reader.readLine();
            char[] c = line.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);

            System.out.println(sortedMap.getOrDefault(sorted, 0) - originMap.getOrDefault(line, 0));
        }
        writer.flush();
    }
}
