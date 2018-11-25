package lanqiaoCourse;

import java.util.Scanner;

/*

         16 17
         19 18
        -------
 12 13 |  0  1 |  4  5 |  8  9
 15 14 |  3  2 |  7  6 | 11 10
        -------
         20 21
         23 22

*/
public class course1_4 {
    static final int[][] transX ={{0,1,2,3},{4,21,14,19},{7,20,13,18}};
    static final int[][] transY ={{4,5,6,7},{1,17,11,21},{2,18,8,22}};
    static final int[][] transZ ={{16,17,18,19},{0,12,8,4},{1,13,9,5}};
    static char[] rotating(char[] a, int[][] trans){
        char[] b = java.util.Arrays.copyOf(a,a.length);
        for(int i=0; i<trans.length; i++){
            b[trans[i][1]] = a[trans[i][0]];
            b[trans[i][2]] = a[trans[i][1]];
            b[trans[i][3]] = a[trans[i][2]];
            b[trans[i][0]] = a[trans[i][3]];
        }
        return b;
    }
    static char[] rotating(char[] a, String s){
        char[] b = java.util.Arrays.copyOf(a, a.length);
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i)=='x') b = rotating(b, transX);
            if(s.charAt(i)=='y') b = rotating(b, transY);
            if(s.charAt(i)=='z') b = rotating(b, transZ);
        }
        return b;
    }

    public static void main(String[] args){
        char[] init =  {
                '绿','绿','绿','绿',
                '红','红','红','红',
                '蓝','蓝','蓝','蓝',
                '橙','橙','橙','橙',
                '白','白','白','白',
                '黄','黄','黄','黄',
        };
        Scanner in = new Scanner(System.in);
        char[] b = rotating(init, in.nextLine());
        System.out.println("" + b[1] + b[4] + b[18]);
    }
}
