package primary.sevenJavaB;
/*
* 暴力做法， 会超时
* */
public class question8Primary {
    private static void print(int[] a){
        System.out.printf("%d %d %d %d\n", a[0], a[1], a[2], a[3]);
    }
    private static boolean f(int[] a, int n, int k, int last, boolean print){
        if(k == 4) return false;
        int i = last, n0;
        while (true){
            n0 = n - i * i;
            a[k] = i;
            if(n0 == 0){
                if(print)print(a);
                return true;
            }
            if(n0 < 0){
                return false;
            }
            if(f(a, n0, k + 1, i, print)){
                return true;
            }
            i++;
        }
    }
    public static void main(String[] args){
        // 测试100个n
        for(int n = 1; n < 100; n++){
            System.out.printf("\n\n%d>>\n",n);
            f(new int[4], n, 0, 0, true);
        }

        for(int n = 5000000 - 5; n < 5000000; n++){
            long start = System.currentTimeMillis();
            f(new int[4], n, 0, 0, false);
            long cost = System.currentTimeMillis() - start;
            if(cost > 1000){
                System.out.printf("%d cost %d", n, (int)cost);
            }
        }
    }
}
