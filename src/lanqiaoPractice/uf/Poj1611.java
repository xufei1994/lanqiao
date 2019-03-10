package lanqiaoPractice.uf;

import java.util.Scanner;

public class Poj1611 {
    private static class UF{
        private int[] parent;
        private byte[] rank;
        private int[] size;
        private int count;
        UF(int N){
            parent = new int[N];
            rank = new byte[N];
            size = new int[N];
            for(int i = 0; i < N; i++){
                parent[i] = i;
                size[i] = 1;
            }
            count = N;
        }
        private int find(int p){
            while (p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q){
            int rootP = find(p), rootQ = find(q);
            if(rootP == rootQ) return;
            if(rank[rootP] < rank[rootQ]){
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }else if(rank[rootP] > rank[rootQ]){
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
                rank[rootP]++;
            }
            count--;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (true){
            int m = in.nextInt(), n = in.nextInt();
            if(m == 0 && n == 0) break;
            UF uf = new UF(m);
            while (n-- > 0){
                int t = in.nextInt();
                int a, b;
                a = in.nextInt();
                while (--t > 0){
                    b = in.nextInt();
                    uf.union(a, b);
                    a = b;
                }
            }
            System.out.println(uf.size[uf.find(0)]);
        }
    }
}
