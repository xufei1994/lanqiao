package primary.sixJavaB;

import java.util.Vector;

public class question4 {
    public static int f(int n, int m)
    {
        n = n % m;
        Vector v = new Vector();

        for(;;)
        {
            v.add(n);
            n *= 10;
            n = n % m;
            if(n==0) return 0;
            if(v.indexOf(n)>=0)return v.size() ;  //填空
        }
    }
    public static void main(String[] args){
        System.out.print(f(11, 13));
    }
}
