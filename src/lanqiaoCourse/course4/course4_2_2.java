package lanqiaoCourse.course4;

public class course4_2_2 {
    static int[] a = new int[]{0, 1, 3, 9, 27, 81};
    private static void f(int k, int gold, String s){
        if(gold == 0){
            System.out.print(s.substring(1));
            return;
        }

        int goldAbs = Math.abs(gold);
        while (k >= 0 && goldAbs < a[k] / 2) k--;
        if(gold > 0){
            gold -= a[k];
            s += "+" + a[k];
        }else{
            gold += a[k];
            s += "-" + a[k];
        }
        f(k - 1, gold, s);
    }
    public static void main(String[] args){

//        Scanner in = new Scanner(System.in);
//        f(a.length - 1, in.nextInt(), "");

        for(int i = 2; i <= 121; i++){
            f(a.length - 1, i, "");
        }
    }
}
