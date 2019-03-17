package lanqiaoPractice.greed;

import java.util.*;

public class nod1428Primary {
    static class Activity{
        int s;
        int e;
        Activity(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        List<Activity> list = new LinkedList<>();
        for(int i = 0; i < N; i++){
            int s = in.nextInt(), e = in.nextInt();
            list.add(new Activity(s, e));
            in.nextLine();
        }
        list.sort(new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                int cmp =  o1.s - o2.s;
                if(cmp != 0) return cmp;
                return o1.e - o2.e;
            }
        });
        int res = 0;
        while (!list.isEmpty()){
            res++;
            int e = list.remove(0).e;
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).s >= e){
                    e = list.get(i).e;
                    list.remove(i);
                    i--;
                }
            }
        }
        System.out.print(res);
    }
}
