package primary.sixJavaB;

public class question2 {
    public static void main(String[] args){
        int count = 0;
        for(int i = 1; i < 100000000; i++){
            int pow3 = i * i * i;
            int total = 0;
            while (pow3 > 0){
                total += pow3 % 10;
                pow3 /= 10;
            }
            if(total == i){
                count++;
                System.out.println(i);
            }
        }
        System.out.printf("total:%d", count);
        // 6个
    }
}
