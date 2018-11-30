package lanqiaoCourse.course3;

public class course3_3_1 {
    static int[] a = new int[]{4, 2, 2, 1, 1, 3};
    static char[] name = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
    static int groupCount = a.length;
    static int count = 0;
    private static String repeat(char c, int t){
        if(t == 0)return "";
        char[] s = new char[t];
        for(int i = 0; i < t; i++){
            s[i] = c;
        }
        return new String(s);
    }
    private static void f(int gold, int groupId, String used){
        if(groupId == groupCount - 1){
            if(gold <= a[groupId]){
                System.out.println(used + repeat(name[groupId], gold));
                count++;
            }
            return;
        }
        for(int k = 0, l = Math.min(gold, a[groupId]); k <= l; k++){
            f(gold - k, groupId + 1, used + repeat(name[groupId], k));
        }
    }
    public static void main(String[] args){
        f(5,0, "");
        System.out.println("count:" + count);
    }
}
