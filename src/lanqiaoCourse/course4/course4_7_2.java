package lanqiaoCourse.course4;

public class course4_7_2 {
    public static void main(String[] args){
        int n = (int)1e7;
        boolean[] marked = new boolean[n + 1];
        int count = 0;
        for(int i = 2; i <= n; i++){
            if(!marked[i]){
                count++;
                if(count == 100002){
                    System.out.println(i);
                    break;
                }
                for(int j = i + i; j <= n; j+=i){
                    marked[j] = true;
                }
            }
        }
    }
}
