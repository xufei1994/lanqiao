package primary.sevenJavaB;

public class question3 {
    private static int[] a = new int[]{1,2,3,4,5,6,7,8,9};
    private static int count = 0;
    private static void swap(int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void f(int k){
        if(k == a.length){
            int def = a[3] * 100 + a[4] * 10 + a[5], ghi = a[6] * 100 + a[7] * 10 + a[8];
            if((a[0] + (double)a[1] / a[2] + (double)def / ghi) == 10){
                System.out.printf("%d+%d/%d+%d/%d\n", a[0], a[1], a[2], def, ghi);
                count++;
            }
            return;
        }
        for(int i = k; i < a.length; i++){
            swap(i, k);
            f(k + 1);
            swap(i, k);
        }
    }
    public static void main(String[] args){
        f(0);
        System.out.println(count);
        // 答案 29
    }
}
