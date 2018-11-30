package lanqiaoCourse.course3;

public class course3_2 {
    static int count = 0;
    private static void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void f(int k, int[] a){
        if(k == a.length){
            if(a[1]<a[0]) return;
            if(a[2]<a[0]) return;
            if(a[3]<a[1]) return;
            if(a[4]<a[1]) return;
            if(a[4]<a[2]) return;
            if(a[5]<a[2]) return;
            if(a[6]<a[3]) return;
            if(a[7]<a[3]) return;
            if(a[7]<a[4]) return;
            if(a[8]<a[4]) return;
            if(a[8]<a[5]) return;
            if(a[9]<a[5]) return;
            System.out.println("   " + a[0]);
            System.out.println("  " + a[1] + " " + a[2]);
            System.out.println(" " + a[3] + " " + a[4] + " " + a[5]);
            System.out.println("" + a[6] + " " + a[7] + " " + a[8] + " " + a[9]);
            System.out.println();
            count++;
        }
        for(int i = k; i < a.length; i++){
            swap(i, k, a);
            f(k + 1, a);
            swap(i, k, a);
        }
    }
    public static void main(String[] args){
        f(0, new int[]{0,1,2,3,4,5,6,7,8,9});
        System.out.println("count:" + count);
    }
}
