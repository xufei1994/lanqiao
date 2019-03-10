package primary.sevenJavaB;

import java.util.HashSet;
import java.util.Set;

/**
 * dfs法
 */
public class question7 {
    private static int row = 3, col = 4;
    private static boolean[][] marked = new boolean[row][col];
    private static Set<String> set = new HashSet<>();
    private static int[] selected = new int[5];
    private static void store(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                sb.append(marked[i][j] ? '*' : '.');
            }
            sb.append('\n');
        }
        set.add(sb.toString());
    }
    private static void dfs(int i, int j, int k){
        if(k == 5){
            store();
            return;
        }
        if(i + 1 < row && !marked[i + 1][j]){
            marked[i + 1][j] = true;
            dfs(i + 1, j, k + 1);
            marked[i + 1][j] = false;
        }
        if(i - 1 >= 0 && !marked[i - 1][j]){
            marked[i - 1][j] = true;
            dfs(i - 1, j, k + 1);
            marked[i - 1][j] = false;
        }
        if(j + 1 < col && !marked[i][j + 1]){
            marked[i][j + 1] = true;
            dfs(i, j + 1, k + 1);
            marked[i][j + 1] = false;
        }
        if(j - 1 >= 0 && !marked[i][j - 1]){
            marked[i][j - 1] = true;
            dfs(i, j - 1, k + 1);
            marked[i][j - 1] = false;
        }
    }
    public static void main(String[] args){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                dfs(i, j, 0);
            }
        }
        for(String s:set){
            System.out.println(s);
        }
        System.out.println(set.size());
    }
}
