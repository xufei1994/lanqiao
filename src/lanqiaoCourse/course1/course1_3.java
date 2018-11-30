package lanqiaoCourse.course1;

import java.io.*;
import java.util.*;

public class course1_3 {
    public static void main(String[] args) throws IOException {
        String[] all = {
                "492357816",
                "834159672",
                "618753294",
                "276951438",
                "294753618",
                "438951276",
                "816357492",
                "672159834"
        };
        boolean[] marked = new boolean[all.length];
        Scanner in = new Scanner(System.in);
        int count = all.length;
        for(int i = 0; i < 9; i++){
            int t = in.nextInt();
            if(t != 0){
                for(int k = 0; k < all.length; k++){
                    if(marked[k]) continue;
                    if((all[k].charAt(i) - '0') != t){
                        marked[k] = true;
                        count--;
                    }
                }
            }
            if(i % 3 == 2){
                in.nextLine();
            }
        }
        if(count >= 2){
            System.out.print("Too Many");
        }else{
            String s = "";
            for(int k = 0; k < marked.length; k++){
                if(!marked[k]){
                    s = all[k];
                    break;
                }
            }
            char[] c = s.toCharArray();
            for(int i = 0; i < 9; i++){
                System.out.print(c[i]);
                System.out.print(i % 3 == 2 ? '\n' : ' ');
            }
        }
    }
}
