package lanqiaoCourse.course3;

import java.util.HashSet;
import java.util.Set;

public class course3_4_1 {
    private static char[] card = new char[]{'A', 'A', '2', '2', '3', '3', '4', '4'};
    private static Set<String> results = new HashSet<>();
    private static void swap(int i, int j){
        char temp = card[i];
        card[i] = card[j];
        card[j] = temp;
    }
    private static void f(int k){
        if(k == card.length){
            String s = new String(card);
            if(s.lastIndexOf('A') - s.indexOf('A') != 2) return;
            if(s.lastIndexOf('2') - s.indexOf('2') != 3) return;
            if(s.lastIndexOf('3') - s.indexOf('3') != 4) return;
            if(s.lastIndexOf('4') - s.indexOf('4') != 5) return;
            results.add(s);
            return;
        }
        for(int i = k; i < card.length; i++){
            swap(i, k);
            f(k + 1);
            swap(i, k);
        }
    }
    public static void main(String[] args){
        f(0);
        for(String item : results){
            System.out.println(item);
        }
    }
}
