package lanqiaoPractice.DFS_and_BFS;

import java.util.Scanner;

public class HDU1241 {
    private static int count = 0;
    private static int row, col;
    private static boolean[][] data;
    private static boolean[][] marked;
    private static void dfs(int i, int j){
        if(!data[i][j]) return;
        marked[i][j] = true;
        if(i + 1 < row && !marked[i + 1][j]) dfs(i + 1, j);
        if(i - 1 >= 0 && !marked[i - 1][j]) dfs(i - 1, j);
        if(j + 1 < col && !marked[i][j + 1]) dfs(i,j + 1);
        if(j - 1 >= 0 && !marked[i][j - 1]) dfs(i,j - 1);
        if(i + 1 < row && j + 1 < col && !marked[i + 1][j + 1]) dfs(i + 1, j + 1);
        if(i + 1 < row && j - 1 >= 0 && !marked[i + 1][j - 1]) dfs(i + 1, j - 1);
        if(i - 1 >= 0 && j + 1 < col && !marked[i - 1][j + 1]) dfs(i - 1, j + 1);
        if(i - 1 >= 0 && j - 1 >= 0 && !marked[i - 1][j - 1]) dfs(i - 1, j - 1);

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (true){
            row = in.nextInt();
            col = in.nextInt();
            if(row == 0 && col == 0) break;
            count = 0;
            in.nextLine();
            data = new boolean[row][col];
            marked = new boolean[row][col];
            for(int i = 0; i < row; i++){
                char[] c = in.nextLine().toCharArray();
                for(int j = 0; j < col; j++){
                    data[i][j] = c[j] == '@';
                }
            }
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(!marked[i][j] && data[i][j]){
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
