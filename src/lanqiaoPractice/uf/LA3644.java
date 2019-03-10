package lanqiaoPractice.uf;

import java.util.Scanner;

public class LA3644 {
    private static class UF{
        private int[] parent;
        private byte[] rank;
        UF(int N){
            parent = new int[N + 1];
            rank = new byte[N + 1];
            for(int i = 0; i <= N; i++){
                parent[i] = i;
            }
        }
        private int find(int p){
            while (p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public boolean same(int p, int q){
            return find(p) == find(q);
        }
        public void union(int p, int q){
            int rootP = find(p), rootQ = find(q);
            if(rank[rootP] < rank[rootQ]){
                parent[rootP] = rootQ;
            }else if(rank[rootP] > rank[rootQ]){
                parent[rootQ] = rootP;
            }else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int a, b;
            UF uf = new UF(100001);
            int res = 0;
            while (true){
                a = in.nextInt();
                if(a == -1) break;
                b = in.nextInt();
                if(uf.same(a, b)){
                    res++;
                }else{
                    uf.union(a, b);
                }
            }
            System.out.println(res);
        }
    }
}
