package lanqiaoCourse.course4;

public class course4_5_1 {

    public static void main(String[] args){
        int l = 100;
        int[][] a = new int[l][l];
        int t = Integer.MAX_VALUE;
        int[] r = new int[2];
        for(int i = 0; i <= l; i++){
            for(int j = 1; j <= l; j++){
                a[i][j] = i * 97 - j * 127;
                if(a[i][j] == 1 && (i + j) < t){
                    t = i + j;
                    r[0] = i;
                    r[1] = j;
                }
            }
        }
        System.out.printf("%d*97-%d*127=%d", r[0], r[1], r[0] * 97 - r[1] * 127);
    }
}
