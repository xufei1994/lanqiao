package primary.sevenJavaB;

public class question5
{
    private static int count;// 增加计数器，判断结果是否正确
    public static void f(int[] a, int k, int n, String s)
    {
        if(k==a.length){

            if(n==0){
                count++; // 增加计数器，判断结果是否正确
                System.out.println(s);
            }
            return;
        }

        String s2 = s;
        for(int i=0; i<=a[k]; i++){
            f(a, k + 1, n - i, s2);   //填空位置
            s2 += (char)(k+'A');
        }
    }

    public static void main(String[] args)
    {
        int[] a = {4,2,2,1,1,3};

        f(a,0,5,"");
        System.out.println(count);
    }
}