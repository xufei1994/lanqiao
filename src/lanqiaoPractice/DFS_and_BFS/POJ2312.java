package lanqiaoPractice.DFS_and_BFS;

import java.util.PriorityQueue;
import java.util.Scanner;

public class POJ2312 {
    private static int[] moveX = new int[]{1, -1, 0, 0};
    private static int[] moveY = new int[]{0, 0, 1, -1};
    private static char[][] map;
    private static boolean[][] marked;
    private static int row, col;
    private static int sx, sy;
    private static boolean canMove(int x, int y){
        return !(x < 0 || x >= col || y < 0 || y >= row || map[y][x] == 'R' || map[y][x] == 'S');
    }
    private static void getStart(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(map[i][j] == 'Y'){
                    sy = i;
                    sx = j;
                    return;
                }
            }
        }
    }
    private static class MapTile implements Comparable<MapTile>{
        int x;
        int y;
        int cost;
        MapTile(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        @Override
        public int compareTo(MapTile o) {
            return cost - o.cost;
        }
    }
    private static int f(){
        PriorityQueue<MapTile> pq = new PriorityQueue<MapTile>();
        pq.add(new MapTile(sx, sy, 0));
        while (!pq.isEmpty()){
            MapTile current = pq.poll();
            for(int i = 0; i < 4; i++){
                int x = current.x + moveX[i], y = current.y + moveY[i];
                if(canMove(x, y) && !marked[y][x]){
                    if(map[y][x] == 'T'){
                        return current.cost + 1;
                    }
                    pq.add(new MapTile(x, y, current.cost + (map[y][x] == 'B' ? 2 : 1 )));
                    marked[y][x] = true;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            row = in.nextInt();
            col = in.nextInt();
            if(row == 0 && col == 0)break;
            in.nextLine();
            map = new char[row][col];
            marked = new boolean[row][col];
            for(int i = 0; i < row; i++){
                map[i] = in.nextLine().toCharArray();
            }
            getStart();
            System.out.println(f());
        }

    }
}
