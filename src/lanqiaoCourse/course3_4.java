package lanqiaoCourse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class course3_4 {
    private static int[] pos = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    private static char[] card = new char[]{'A', 'A', '2', '2', '3', '3', '4', '4'};
    private static Set<String> results = new HashSet<>();
    private static void swap(int i, int j){
        int temp = pos[i];
        pos[i] = pos[j];
        pos[j] = temp;
    }
    private static void f(int k){
        if(k == pos.length){
            if(Math.abs(pos[0] - pos[1]) != 2) return;
            if(Math.abs(pos[4] - pos[5]) != 4) return;
            if(Math.abs(pos[6] - pos[7]) != 5) return;
            char[] c = new char[8];
            for(int i = 0; i < 8; i++){
                c[pos[i]] = card[i];
            }
            results.add(new String(c));
            return;
        }
        for(int i = k; i < pos.length; i++){
            swap(i, k);
            f(k + 1);
            swap(i, k);
        }
    }
    public static void main(String[] args){
        f(0);
        String[] s = new String[results.size()];
        results.toArray(s);
        Arrays.sort(s);
        for(String item : s){
            System.out.println(item);
        }
    }
}
