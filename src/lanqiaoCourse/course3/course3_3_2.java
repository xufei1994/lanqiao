package lanqiaoCourse.course3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class course3_3_2 {
    static int l;
    static Set<String> result = new HashSet<>();
    private static void swap(int i, int j, char[] c){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
    private static void f(int k, char[] c){
        if(k == l){
            char[] r = Arrays.copyOf(c, 5);
            Arrays.sort(r);
            result.add(new String(r));
            return;
        }
        for(int i = k; i < c.length; i++){
            if(i != k && c[i] == c[k])continue;
            swap(i, k, c);
            f(k + 1, c);
            swap(i, k, c);
        }
    }
    public static void main(String[] args){
        l = 5;
        f(0, "AAAABBCCEFGGG".toCharArray());
        String[] sortedResults = new String[result.size()];
        result.toArray(sortedResults);
        Arrays.sort(sortedResults);
        for(String r : sortedResults){
            System.out.println(r);
        }
        System.out.println(result.size());
    }
}
