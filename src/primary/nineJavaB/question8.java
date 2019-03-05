package primary.nineJavaB;

import java.util.*;

public class question8 {
    private static Map<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), D = in.nextInt(), K = in.nextInt();
        int ts, id;
        while (N-- > 0){
            ts = in.nextInt();
            id = in.nextInt();
            if(!map.containsKey(id)) map.put(id, new LinkedList<>());
            map.get(id).add(ts);
        }

        Set<Integer> idSet = map.keySet();
        Integer[] ids = new Integer[idSet.size()];
        idSet.toArray(ids);
        for(Integer i: ids){
            List<Integer> list = map.get(i);
            Integer[] t = new Integer[list.size()];
            list.toArray(t);
            Arrays.sort(t);
            for(int j = 0; j < t.length; j++){
                int s = t[j];
                int p = Arrays.binarySearch(t, j, t.length, s + D - 1);
                if(p >= 0){
                    if(p - j > K){
                        System.out.println(i);
                        break;
                    }
                }else{
                    p = - p - 2;
                    if(p - j  >= K){
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }
}
