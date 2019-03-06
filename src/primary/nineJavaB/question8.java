package primary.nineJavaB;

import java.util.*;

public class question8 {
    // 用一个map来储存各个id的ts列表
    private static Map<Integer, List<Integer>> map = new HashMap<>();
    private static void f(int N, int D, int K){
        // 将idSet转化为数组并排序
        Set<Integer> idSet = map.keySet();
        Integer[] ids = new Integer[idSet.size()];
        idSet.toArray(ids);
        Arrays.sort(ids);



        for(Integer i: ids){
            // 对某个id的ts列表，取出转化为数组并排序
            List<Integer> list = map.get(i);
            Integer[] t = new Integer[list.size()];
            list.toArray(t);
            Arrays.sort(t);

            // 遍历，从第一条记录开始遍历
            for(int j = 0, l = t.length - K; j <= l; j++){
                if(t[j + K - 1] - t[j] < D){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N, D, K;
        int ts, id;
        if(true){
            N = in.nextInt();
            D = in.nextInt();
            K = in.nextInt();
            // 读取数据
            while (N-- > 0){
                ts = in.nextInt();
                id = in.nextInt();
                if(!map.containsKey(id)) map.put(id, new LinkedList<>());
                map.get(id).add(ts);
            }
        }else{
            N = 100000;
            D = new Random().nextInt(100) + 1;
            K = 2;
            Random tsSeed = new Random();
            Random idSeed = new Random();
            while (N-- > 0){
                ts = tsSeed.nextInt(100000);
                id = idSeed.nextInt(100000);
                if(!map.containsKey(id)) map.put(id, new LinkedList<>());
                map.get(id).add(ts);
            }
        }
        f(N, D, K);

    }
}
