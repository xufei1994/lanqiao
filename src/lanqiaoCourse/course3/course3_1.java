package lanqiaoCourse.course3;

import java.util.Scanner;

public class course3_1 {
    private static void swap(int i, int j, char[] c){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
    private static void f(int k, char[] c){
        if(k == c.length){
            System.out.println(c);
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
        Scanner in = new Scanner(System.in);
        f(0, in.nextLine().toCharArray());
    }
}
