package lanqiaoCourse.course4;

public class course4_4 {
    private static int gcd(int a, int b){
        if(a < b){
            return gcd(b, a);
        }
        int r;
        do{
            r = a % b;
            a = b;
            b = r;
        }while (r > 0);
        return a;
    }
    private static int mcf(int a, int b){
        return a * b / gcd(a, b);
    }
    private static int gcd(int[] t){
        int a = t[0];
        for(int i = 1; i < t.length; i++){
            a = gcd(a, t[i]);
        }
        return a;
    }
    private static int mcf(int[] t){
        int a = t[0];
        for(int i = 1; i < t.length; i++){
            a = mcf(a, t[i]);
        }
        return a;
    }
    public static void main(String[] args){
        System.out.println(gcd(65, 24));
        System.out.println(gcd(65, 26));
        System.out.println(gcd(new int[]{130, 52, 13}));
        System.out.println(gcd(new int[]{130, 52, 4}));

        System.out.println(mcf(65, 26));
        System.out.println(mcf(new int[]{130, 52, 13}));
        System.out.println(mcf(new int[]{130, 52, 4}));
    }
}
