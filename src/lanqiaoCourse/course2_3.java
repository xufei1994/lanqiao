package lanqiaoCourse;

public class course2_3 {
    private static void f(String left, int gold, String expr){
        if(left.equals("")){
            if(gold == 0 && expr.charAt(0) == '+') System.out.println(expr.substring(1));
            return;
        }
        for(int i = 1, l = left.length();i <= l;i++){
            String n = left.substring(0, i), leftSub = left.substring(i);
            int num = Integer.parseInt(n);
            f(leftSub, gold - num, expr + "+" + n);
            f(leftSub, gold + num, expr + "-" + n);
        }
    }
    public static void main(String[] args){
        f("123456789", 110, "");
    }
}
