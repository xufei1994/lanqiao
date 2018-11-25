package lanqiaoPractice;

import java.io.*;
import java.math.BigInteger;

public class PREV55 {
    private static BigInteger output(BigInteger num, BigInteger base){
        StringBuilder sb = new StringBuilder();
        BigInteger zero = new BigInteger("0");
        while (num.compareTo(zero) > 0) {
            BigInteger[] arr = num.divideAndRemainder(base);
            num = arr[0];
            sb.append(arr[1].toString());
        }
        return new BigInteger(sb.reverse().toString());
    }
    private static BigInteger convertTo10(BigInteger num,BigInteger base){
        StringBuilder sb = new StringBuilder();
        BigInteger zero = new BigInteger("0");
        BigInteger r = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        String s = num.toString();
        r = r.add(new BigInteger(num.toString().substring(s.length() - 1)));
        for(int i = s.length() - 2; i >= 0; i--){
            b = b.multiply(base);
            r = r.add(b.multiply(new BigInteger((s.charAt(i) - '0') + "")));
        }
        return r;
    }
    public static void main(String[] args) throws IOException {
//        System.out.println(output(new BigInteger("12"), new BigInteger("2")).toString());
        System.out.println(convertTo10(new BigInteger("A"), new BigInteger("31")).toString());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int T = Integer.parseInt(reader.readLine());
        BigInteger currentC = new BigInteger("10");
        BigInteger num = null;
        String currentOperation = "";
        String[] s;
        while (T-- > 0){
            s = reader.readLine().split("\\s+");
            BigInteger t = s.length >= 2 ? new BigInteger(s[1]) : new BigInteger("0");
            String c = s[0];
            switch (c){
                case "NUM":
                    if(num == null){
                        num = convertTo10(t, currentC);
                    }else if(!currentOperation.equals("")){
                        t = convertTo10(t, currentC);
                        switch (currentOperation){
                            case "ADD":
                                num = num.add(t);
                                break;
                            case "SUB":
                                num = num.subtract(t);
                                break;
                            case "MUL":
                                num = num.multiply(t);
                                break;
                            case "DIV":
                                num = num.divide(t);
                                break;
                            case "MOD":
                                num = num.mod(t);
                                break;
                        }
                        currentOperation = "";
                    }
                    break;
                case "CHANGE":
                    currentC = t;
                    break;
                case "CLEAR":
                    num = null;
                    break;
                case "EQUAL":
                    writer.write(output(num, currentC).toString());
                    break;
                default:
                    currentOperation = c;
            }
        }
        writer.flush();
    }
}
