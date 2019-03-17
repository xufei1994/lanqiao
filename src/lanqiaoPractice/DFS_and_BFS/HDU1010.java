package lanqiaoPractice.DFS_and_BFS;

import java.util.Scanner;

public class HDU1010 {
    private static int[] moveX = new int[]{1, -1, 0, 0};
    private static int[] moveY = new int[]{0, 0, 1, -1};
    private static char[][] map;
    private static boolean[][] marked;
    private static int row, col;
    private static int sx, sy;
    private static int T;
    private static int targetX, targetY;
    private static boolean canMove(int x, int y){
        return !(x < 0 || x >= col || y < 0 || y >= row || map[y][x] == 'X');
    }
    private static void getStart(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(map[i][j] == 'S'){
                    sy = i;
                    sx = j;
                }
                if(map[i][j] == 'D'){
                    targetX = j;
                    targetY = i;
                }
            }
        }
    }
    private static boolean dfs(int x, int y, int cost){
        if(y == targetY && x == targetX && cost == T) return true;
        marked[y][x] = true;
        int t = Math.abs(x - targetX) + Math.abs(y - targetY);
        t = T - cost - t;
        if (t % 2 == 1) return false;
        if (t < 0) return false;
        for(int i = 0; i < 4; i++){
            int x1 = x + moveX[i], y1 = y + moveY[i];
            if(canMove(x1, y1) && !marked[y1][x1]){
                if(dfs(x1 , y1, cost + 1)) return true;
            }
        }
        marked[y][x] = false;
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            row = in.nextInt();
            col = in.nextInt();
            T = in.nextInt();
            if(row == 0 && col == 0 && T == 0)break;
            in.nextLine();
            map = new char[row][col];
            marked = new boolean[row][col];
            for(int i = 0; i < row; i++){
                map[i] = in.nextLine().toCharArray();
            }
            getStart();
            System.out.println(dfs(sx, sy, 0) ? "YES" : "NO");
        }

    }
}
