package primary.sevenJavaB;

public class question1 {
    public static void main(String[] args){
        int current = 0;
        long total = 0;
        for(int i = 1; i <= 100; i++){
            current += i;
            total += current;
            System.out.println(current);
        }
        System.out.print(total);
        // 答案 171700
    }
}
