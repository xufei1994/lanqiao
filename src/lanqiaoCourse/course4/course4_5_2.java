package lanqiaoCourse.course4;

import java.util.LinkedList;
import java.util.List;

public class course4_5_2 {
    private static List<Integer> gcd2(int a, int b){
        if(a < b){
            return gcd2(b, a);
        }
        List<Integer> qs = new LinkedList<>();
        int r, q;
        do{
            q = a / b;
            r = a - q * b;
            a = b;
            b = r;
            qs.add(q);
        }while (r > 0);
        qs.remove(qs.size() - 1);
        return qs;
    }
    private static int[] solve(int a, int b){
        List<Integer> qs = gcd2(a, b);
        int l = qs.size();
        int[] Q = new int[l + 1], P = new int[l + 1];
        Integer[] q  = new Integer[l];
        qs.toArray(q);

        P[0] = 1;
        P[1] = q[0];
        Q[0] = 0;
        Q[1] = 1;
        for(int k = 2; k <= l; k++){
            P[k] = q[k - 1] * P[k - 1] + P[k - 2];
            Q[k] = q[k - 1] * Q[k - 1] + Q[k - 2];
        }

        return new int[]{(l % 2 == 0 ? -1 : 1) * Q[l], (l % 2 == 0 ? 1 : -1) * P[l]};
    }
    public static void main(String[] args){
        int a = 97, b = -127;
        int[] r = solve(a, -b);
        System.out.println("x : " + r[0] + " y :" + (-r[1]));
    }
}
