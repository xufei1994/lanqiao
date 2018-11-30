package lanqiaoCourse.course2;

public class course2_1 {
    static int count = 0;
    private static void f(int stair, int step){
        if(stair < 0) return;
        if(stair == 0){
            if(step % 2 == 0) count++;
        }
        f(stair - 1, step + 1);
        f(stair - 2, step + 1);
    }
    public static void main(String[] args){
        f(39, 0);
        System.out.println(count);
    }
//    static int count = 0;
//    private static void f(int stair, boolean isRight){
//        if(stair < 0) return;
//        if(stair == 0){
//            if(isRight) count++;
//        }
//        f(stair - 1, !isRight);
//        f(stair - 2, !isRight);
//    }
//    public static void main(String[] args){
//        f(39, true);
//        System.out.println(count);
//    }
}
