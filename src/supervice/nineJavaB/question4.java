package supervice.nineJavaB;

import java.util.Scanner;

public class question4 {
    private static long parseNumTo10(String s, int from){
        char[] c = s.toCharArray();
        int N = c.length;
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            char t = c[i];
            a[i] = t >= '0' && t <= '9' ? t - '0' : t - 'A';
        }
        long base = 1;
        long r = 0;
        for(int i = a.length - 1; i >= 0; i--){
            r += a[i] * base;
            base *= from;
        }
        return r;
    }
    private static void print(long n, int k){
        int[] t = new int[64];
        int count = 0;
        while (n > 0){
            t[count++] = (int)(n % k);
            n /= k;
        }
        for(int i = count - 1; i >= 0; i--){
            System.out.print(t[i] > 9 ? (char)(t[i] - 10 + 'A') : (char)(t[i] + '0'));
        }
        System.out.print('\n');
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long n = -1;
        int k = 10;
        String operation = "";
        in.nextLine();
        while (N-- > 0){
            String[] line = in.nextLine().split("\\s+");
            if(line.length == 1){
                switch (line[0]){
                    case "CLEAR":
                        n = -1;
                        break;
                    case "EQUAL":
                        print(n, k);
                        break;
                    default:
                        operation = line[0];
                }
            }else{
                if(line[0].equals("NUM")){
                    if(n == -1){
                        n = parseNumTo10(line[1], k);
                    }else{
                        switch (operation){
                            case "ADD":
                                n += parseNumTo10(line[1], k);
                                break;
                            case "SUB":
                                n -= parseNumTo10(line[1], k);
                                break;
                            case "MUL":
                                n *= parseNumTo10(line[1], k);
                                break;
                            case "DIV":
                                n /= parseNumTo10(line[1], k);
                                break;
                            case "MOD":
                                n %= parseNumTo10(line[1], k);
                                break;
                        }
                        operation = "";
                    }
                }else{
                    k = Integer.parseInt(line[1]);
                }
            }
        }
    }
}
