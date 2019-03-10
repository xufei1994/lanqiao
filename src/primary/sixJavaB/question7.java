package primary.sixJavaB;

public class question7 {
    private static long total = 0;
    private static void f(int k, int left){
        if(k == 13){
            total++;
            return;
        }
        for(int i = 0; i <= 4 && i <= left; i++){
            f(k + 1, left - i);
        }
    }
    public static void main(String[] args){
        f(0, 13);
        System.out.print(total);
        // 答案 7798910
    }
}
