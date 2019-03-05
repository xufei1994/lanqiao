package primary.sevenJavaB;

public class question6 {
    private static int[] a = new int[]{0, 1,2,3,4,5,6,7,8,9};
    private static int count = 0;
    private static void swap(int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static boolean isNotNeighbor(int i, int j){
        return Math.abs(a[i] - a[j]) != 1;
    }
    private static void print(){
        System.out.println("   +--+--+--+");
        System.out.printf("   | %d| %d| %d|\n", a[0], a[1], a[2]);
        System.out.println("+--+--+--+--+");
        System.out.printf("| %d| %d| %d| %d|\n",a[3], a[4], a[5], a[6]);
        System.out.println("+--+--+--+--+");
        System.out.printf("| %d| %d| %d|\n", a[7], a[8], a[9]);
        System.out.println("+--+--+--+\n\n\n");
    }
    private static void f(int k){
        if(k == a.length){
            if(isNotNeighbor(0,1) &&
                    isNotNeighbor(0,3) &&
                    isNotNeighbor(0,4) &&
                    isNotNeighbor(0,5) &&
                    isNotNeighbor(1,2) &&
                    isNotNeighbor(1,4) &&
                    isNotNeighbor(1,5) &&
                    isNotNeighbor(1,6) &&
                    isNotNeighbor(2,5) &&
                    isNotNeighbor(2,6) &&
                    isNotNeighbor(3,4) &&
                    isNotNeighbor(3,7) &&
                    isNotNeighbor(3,8) &&
                    isNotNeighbor(4,5) &&
                    isNotNeighbor(4,7) &&
                    isNotNeighbor(4,8) &&
                    isNotNeighbor(4,9) &&
                    isNotNeighbor(5,6) &&
                    isNotNeighbor(5,8) &&
                    isNotNeighbor(5,9) &&
                    isNotNeighbor(7,8) &&
                    isNotNeighbor(8,9)){
                count++;
                print();
            }
            return;
        }
        for(int i = k; i < a.length; i++){
            swap(i, k);
            f(k + 1);
            swap(i, k);
        }
    }
    public static void main(String[] args){
        f(0);
        System.out.println(count);
    }
}
