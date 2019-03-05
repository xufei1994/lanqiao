package supervice.nineJavaB;

import java.util.Arrays;
import java.util.Scanner;

public class question4 {
    private static void reverse(int[] t){
        int count = t.length;
        for(int i = 0, l = count / 2; i < l; i++){
            int temp = t[i];
            t[i] = t[count - i - 1];
            t[count - i - 1] = temp;
        }
    }
    private static int[] change(int[] a,int from, int to){
        long n = 0;
        long base = 1;
        n += a[a.length - 1];
        for(int i = a.length - 2; i >= 0; i--){
            base *= from;
            n += base * a[i];
        }

        int[] t = new int[64];
        int count = 0;
        while (n >= to){
            t[count++] = (int)(n % to);
            n /= to;
        }
        t[count++] = (int)n;

        t = Arrays.copyOf(t, count);
        for(int i = 0, l = count / 2; i < l; i++){
            int temp = t[i];
            t[i] = t[count - i - 1];
            t[count - i - 1] = temp;
        }
        return t;
    }
    private static void print(int[] t){
        for(int i = 0; i < t.length; i++){
            System.out.print(t[i] > 9 ? (char)(t[i] - 10 + 'A') : (char)(t[i] + '0'));
        }
    }
    private static int[] parseNum(char[] c){
        int N = c.length;
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            char t = c[i];
            if(t >= '0' && t <= '9'){
                a[i] = t - '0';
            }else{
                a[i] = t - 'A';
            }
        }
        return a;
    }
    private static int[] add(int[] a, int b[], int k){
        int N = Math.max(a.length, b.length) + 1;
        int[] c = new int[N + 1];
        for(int i = 1; i <= N; i++){
            int p = a.length - i >= 0 ? a[a.length - i] : 0,
                    q = b.length - i >= 0 ? b[b.length - i] : 0;
            int r = p + q;
            if(r >= k){
                c[i] = 1;
                r -= k;
            }
            c[i - 1] = r;
        }
        if(c[N] == 0) c = Arrays.copyOf(c, N);
        reverse(c);
        return c;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = null;
        int k = 10;
        String operation = null;
        in.nextLine();
        while (N-- > 0){
            String[] line = in.nextLine().split("\\s+");
            if(line.length == 1){
                switch (line[0]){
                    case "CLEAR":
                        a = null;
                        break;
                    case "EQUAL":
                        print(a);
                        break;
                    default:
                        operation = line[0];
                }
            }else{
                if(line[0].equals("NUM")){
                    if(a == null){
                        a = parseNum(line[1].toCharArray());
                    }else{
                        int[] b = parseNum(line[1].toCharArray());
                        switch (operation){
                            case "ADD":
                                a = add(a, b, k);
                                break;
                            case "SUB":
                                a = add(a, b, k);
                                break;
                            case "MUL":
                                a = add(a, b, k);
                                break;
                            case "DIV":
                                a = add(a, b, k);
                                break;
                            case "MOD":
                                a = add(a, b, k);
                                break;
                        }
                        operation = null;
                    }
                }else{
                    int newK = Integer.parseInt(line[1]);
                    a = change(a, k, newK);
                    k = newK;
                }
            }
        }
    }
}
