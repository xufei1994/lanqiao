package primary.sevenJavaB;
/**
 * dfs法+回溯法解决， 做了一点改进，
 * 把每种剪法的左上角作为第一个点，来防止重复搜索，
 * 第一个点调用firstDfs，只考虑右边和下边
 * 其他点调用dfs，考虑上下左右
 */
public class question7 {
    private static int row = 3, col = 4;
    private static boolean[][] marked;
    private static int count = 0;
    private static void firstDfs(int i, int j){
        marked = new boolean[row][col];
        marked[i][j] = true;
        if(i + 1 < row){
            marked[i + 1][j] = true;
            dfs(i + 1, j, 1);
            marked[i + 1][j] = false;
        }
        if(j + 1 < row){
            marked[i][j + 1] = true;
            dfs(i, j + 1, 1);
            marked[i][j + 1] = false;
        }
    }
    private static void print(boolean[][] marked){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(marked[i][j] ? '*' : '.');
            }
            System.out.print('\n');
        }
        System.out.print("\n\n\n");
    }
    private static void dfs(int i, int j, int selected){
        if(selected == 4){
            count++;
            print(marked);
            return;
        }
        if(i + 1 < row && !marked[i + 1][j]){
            marked[i + 1][j] = true;
            dfs(i + 1, j, selected + 1);
            marked[i + 1][j] = false;
        }
        if(i - 1 >= 0 && !marked[i - 1][j]){
            marked[i - 1][j] = true;
            dfs(i - 1, j, selected + 1);
            marked[i - 1][j] = false;
        }
        if(j + 1 < col && !marked[i][j + 1]){
            marked[i][j + 1] = true;
            dfs(i, j + 1, selected + 1);
            marked[i][j + 1] = false;
        }
        if(j - 1 >= 0 && !marked[i][j - 1]){
            marked[i][j - 1] = true;
            dfs(i, j - 1, selected + 1);
            marked[i][j - 1] = false;
        }
    }
    public static void main(String[] args){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                firstDfs(i, j);
            }
        }
        System.out.println(count);
    }
}
