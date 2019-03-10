package primary.sixJavaB;

public class question3 {
    private static String[] s = new String[]{"三", "羊", "献", "瑞", "祥", "生", "辉", "气"};
    // "三", "羊", "献", "瑞", "祥", "生", "辉", "气"
    //  0      1    2     3    4     5     6    7
    /*
          祥 瑞 生 辉
      +   三 羊 献 瑞
    -------------------
       三 羊 生 瑞 气
       等价于

          n[4] n[3] n[5] n[6]
      +   n[0] n[1] n[2] n[3]
          -------------------
     n[0] n[1] n[5] n[3] n[7]
     */
    private static int[] n = new int[8];
    private static boolean[] marked = new boolean[10];
    private static void f(int k){
        if(k == 8){
            int b = n[0] * 1000 + n[1] * 100 + n[2] * 10 + n[3];
            if(b > 1000
                    &&
                    (n[4] * 1000 + n[3] * 100 + n[5] * 10 + n[6])+
                    b==
                    (n[0] * 10000 + n[1] * 1000 + n[5] * 100 + n[3] * 10 + n[7])){
                System.out.printf("     %d %d %d %d\n   + %d %d %d %d\n----------------\n   %d %d %d %d %d\n",
                        n[4], n[3], n[5], n[6],
                        n[0], n[1], n[2], n[3],
                        n[0], n[1], n[5], n[3], n[7]
                );
                System.out.print(b);
            }
            return;
        }
        for(int i = 0; i < 10; i++){
            if(!marked[i]){
                marked[i] = true;
                n[k] = i;
                f(k + 1);
                marked[i] = false;
            }
        }
    }
    public static void main(String[] args){
        f(0);
    }
}
