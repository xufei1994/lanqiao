package supervice.nineJavaB;

import java.util.Scanner;

public class question5Primary {
    private static char[] choose = new char[]{'L', 'O'};
    private static int f(char[] c){
        String s = new String(c);
        if(s.contains("LOL")) return 1;
        if(!s.contains("*")) return 0;
        int res = -1;
        for(int i = 0; i < c.length; i++){
            if(c[i] == '*'){
                c[i] = 'L';
                res = Math.max(res,-f(c));
                if(res == 1){
                    c[i] = '*';
                    return 1;
                }
                c[i] = 'O';
                res = Math.max(res,-f(c));
                c[i] = '*';

            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0){
            char[] c = in.nextLine().toCharArray();
            int left = 0;
            for(int i = 0; i < c.length; i++){
                if(c[i] == '*') left++;
            }
            System.out.println(f(c));
        }
    }
}
