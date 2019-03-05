package lanqiaoCourse.course5;

public class course5_3 {
    private static int getNum(){
        return (int)(Math.random() * 6) + 1;
    }
    public static void main(String[] args){
        int[] r = new int[3];
        int bat, count;
        int gain = 0;
        for(int i = 0; i < 500000; i++){
            count = 0;
            bat = getNum();
            r[0] = getNum();
            r[1] = getNum();
            r[2] = getNum();

            for(int n : r){
                if(bat == n) count++;
            }
            switch (count){
                case 1:
                    gain -= 1;
                    break;
                case 2:
                    gain -= 2;
                    break;
                case 3:
                    gain -= 10;
                    break;
                default:
                    gain++;
            }
        }
        System.out.print((double) gain / 500000);
    }
}
