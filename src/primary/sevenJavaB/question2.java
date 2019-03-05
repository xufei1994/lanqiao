package primary.sevenJavaB;

public class question2 {
    private static int[] f(){
        for(int i = 1; i < 150; i++){
            int total = 0;
            for(int j = i; j < 150; j++){
                total += j;
                if(total == 236){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        int[] r = f();
        int total = 0;
        for(int i = r[0]; i <= r[1]; i++){
            total += i;
            System.out.println(i);
        }
        System.out.println(total);
    }
}
