package lanqiaoCourse.course4;

public class course4_7_1 {
    private static boolean isPrimer(int a){
        for(int i = 2, l = (int)Math.sqrt(a); i <= l; i++){
            if(a % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args){
        int count = 0;
        int i = 2;
        while (true){
            if(isPrimer(i)){
                count++;
                if(count == 5000002){
                    System.out.println(i);
                    break;
                }
            }
            i++;
        }
    }
}
