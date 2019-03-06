package primary.nineJavaB;

import java.util.Random;
public class question5{
    public static int quickSelect(int a[], int l, int r, int k) {
        Random rand = new Random();
        int p = rand.nextInt(r - l + 1) + l;
        int x = a[p];
        int tmp = a[p]; a[p] = a[r]; a[r] = tmp;
        int i = l, j = r;
        while(i < j) {
            while(i < j && a[i] < x) i++;
            if(i < j) {
                a[j] = a[i];
                j--;
            }
            while(i < j && a[j] > x) j--;
            if(i < j) {
                a[i] = a[j];
                i++;
            }
        }
        a[i] = x;
        p = i;
        if(i - l + 1 == k) return a[i];
        if(i - l + 1 < k) return quickSelect(a, i + 1, r, k - (i - l + 1)); //填空
        else return quickSelect(a, l, i - 1, k);
    }
    public static void main(String args[]) {
        for(int t = 0; t < 100; t++){
            int [] a = {1, 4, 2, 8, 5, 7};
            System.out.println(quickSelect(a, 0, 5, 4));
        }
    }
}