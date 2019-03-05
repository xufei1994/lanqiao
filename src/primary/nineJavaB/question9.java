package primary.nineJavaB;

import java.util.Arrays;
import java.util.Scanner;

public class question9 {
    private static class Search {
        private boolean[][] marked;
        private boolean[][] data;
        private int N;
        private int count = 0;
        Search(boolean[][] data, int N){
            marked = new boolean[N][N];
            this.data = data;
            this.N = N;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!marked[i][j] && data[i][j]){
                        dfs(i, j);
                        count++;
                    }
                }
            }
        }
        // dfs搜索 详细见深度优先搜索
        private void dfs(int i, int j){
            marked[i][j] = true;
            if(i - 1 >= 0 && !marked[i - 1][j]  && data[i - 1][j]) dfs(i - 1, j);
            if(i + 1 < N && !marked[i + 1][j]  && data[i + 1][j]) dfs(i + 1, j);
            if(j - 1 >= 0 && !marked[i][j - 1]  && data[i][j - 1]) dfs(i, j - 1);
            if(j + 1 < N && !marked[i][j + 1]  && data[i][j + 1]) dfs(i, j + 1);
        }
        public int count(){
            return count;
        }
    }
    private static boolean[][] copy(boolean[][] data, int N){
        boolean[][] copy = new boolean[N][N];
        for(int i = 0; i < N; i++){
            copy[i] = Arrays.copyOf(data[i], N);
        }
        return copy;
    }
    private static boolean compare(boolean[][] src, boolean[][] dest, int N){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(src[i][j] != dest[i][j]) return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        boolean[][] data = new boolean[N][N], copy;
        // 将数据读入data中
        for(int i = 0; i < N; i++){
            char[] c = in.nextLine().toCharArray();
            for(int j = 0; j < N; j++){
                data[i][j] = c[j] == '#';
            }
        }

        // 用dfs计算开始时岛屿数
        int begin = new Search(data, N).count();


        // 计算淹没后的岛屿数
        copy = copy(data, N);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if((i - 1 >= 0 && !data[i - 1][j]) ||
                        (i + 1 < N && !data[i + 1][j]) ||
                        (j - 1 <= N && !data[i][j - 1]) ||
                        (j + 1 < N) && !data[i][j + 1] ){
                    copy[i][j] = false;
                }
            }
        }

        // 打印淹没后的地图
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(copy[i][j] ? "#" : '.');
            }
            System.out.print("\n");
        }

        int end = new Search(copy, N).count();

        System.out.println(begin - end);
    }
}
