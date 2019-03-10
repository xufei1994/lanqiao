package primary.sixJavaB;

public class question6 {
    // 把48个加号分别编号为0-47, 0号加号左边的数字为1，1号加号左边的数字为2，以此类推
    private static int change(int i, int j){
        return 1225 - (i + 1) - (i + 2) + (i + 1) * (i + 2)
                - (j + 1) - (j + 2) + (j + 1) * (j + 2);
    }
    private static void f(){
        for(int i = 0; i < 48; i++){
            for(int j = i + 2; j < 48; j++){
                if(change(i, j) == 2015){
                    for(int k = 0; k < 48; k++) {
                        System.out.print(k + 1);
                        System.out.print((k == i || k == j) ? '*' : '+');
                    }
                    System.out.print("49=2015\n");
                }
            }
        }
    }
    public static void main(String[] args){
        f();
        // 答案 16
    }
}
