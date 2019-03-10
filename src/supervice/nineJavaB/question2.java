package supervice.nineJavaB;

import java.util.Arrays;
import java.util.Scanner;

public class question2 {
    private static boolean[][] copy(boolean[][] data, int R, int C){
        boolean[][] copy = new boolean[R][C];
        for(int i = 0; i < R; i++){
            copy[i] = Arrays.copyOf(data[i], C);
        }
        return copy;
    }
    private static boolean compare(boolean[][] src, boolean[][] dest, int R, int C){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(src[i][j] != dest[i][j]) return false;
            }
        }
        return true;
    }
    private static int countNeighbor(boolean[][] data,int i, int j, int R, int C){
        int count = 0;
        if(i - 1 >= 0 && data[i - 1][j]) count++;
        if(i + 1 < R && data[i + 1][j]) count++;
        if(j - 1 >= 0 && data[i][j - 1]) count++;
        if(j + 1 < C && data[i][j + 1]) count++;

        if(i - 1 >= 0 && j + 1 < C && data[i - 1][j + 1]) count++;
        if(i - 1 >= 0 && j - 1 >= 0 && data[i - 1][j - 1]) count++;
        if(i + 1 < R && j + 1 < C && data[i + 1][j + 1]) count++;
        if(i + 1 < R && j - 1 >= 0 && data[i + 1][j - 1]) count++;

        return count;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int R = 11, C = 38;
        boolean[][] data = new boolean[R][C], copy, origin;
        // 将数据读入data中
        for(int i = 0; i < R; i++){
            char[] c = in.nextLine().toCharArray();
            for(int j = 0; j < C; j++){
                data[i][j] = c[j] == 'X';
            }
        }

        origin = copy(data, R, C);

//        int round = 0;
        int round = 1000;
        while (round-- > 0){
//            round++;
            // 计算淹没后的岛屿数
            copy = copy(data, R, C);
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    int count = countNeighbor(data, i, j, R, C);
                    if(copy[i][j]){
                        if(count < 2 || count > 3){
                            copy[i][j] = false;
                        }
                    }else{
                        if(count == 3) copy[i][j] = true;
                    }
                }
            }
            data = copy;
            if(compare(origin, data, R, C)){
                break;
            }
            if(round < 10){
                for(int i = 0; i < R; i++){
                    for(int j = 0; j < C; j++){
                        System.out.print(data[i][j] ? "X" : '.');
                    }
                    System.out.print("\n");
                }
                System.out.print("\n\n\n");

            }
        }

        System.out.print(round);

        // 答案：11
    }
}
