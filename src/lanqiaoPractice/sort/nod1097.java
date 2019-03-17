package lanqiaoPractice.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class nod1097 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int N = Integer.parseInt(reader.readLine());
        String[] s = new String[N];
        for(int i = 0; i < N; i++){
            s[i] = reader.readLine();
        }
        /*
交换相邻两个串a,b会使答案变差当且仅当a+b<b+a，
用num(s)表示s对应的十进制数，
则有num(a)*10^|b|+num(b)<num(b)*10^|a|+num(a)，
整理一下可得num(a)/(10^|a|-1)<num(b)/(10^|b|-1)，
这是一个全序关系。
         */
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String p = o1 + o2;
                String q = o2 + o1;
                for(int i = 0, l = p.length(); i < l; i++){
                    int cmp = p.charAt(i) - q.charAt(i);
                    if(cmp < 0){
                        return -1;
                    }else if(cmp > 0){
                        return 1;
                    }
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(s[i]);
        }
        if(sb.length() <= 1000){
            writer.write(sb.toString());
        }else{
            for(int i = 0; i < sb.length(); i += 1000){
                writer.write(sb.substring(i, Math.min(i + 1000, sb.length())) + "\n");
            }
        }
        writer.flush();
    }
}
