package lanqiaoCourse;

public class course4_1 {
    private static String convertTo7(int n){
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            sb.append(n % 7);
            n /= 7;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        String s = convertTo7(1000000);
        System.out.println(s);

        int r = 0;
        for(char c : s.toCharArray()){
            r += c - '0';
        }
        System.out.println(r);
    }
}
