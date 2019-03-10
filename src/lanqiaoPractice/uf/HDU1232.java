package lanqiaoPractice.uf;

import java.util.Scanner;

public class HDU1232 {
    private static class UF{
        private int[] parent;
        private byte[] rank;
        private int count;
        UF(int N){
            parent = new int[N + 1];
            rank = new byte[N + 1];
            for(int i = 0; i <= N; i++){
                parent[i] = i;
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
            }else if(rank[rootP] > rank[rootQ]){
                parent[rootQ] = rootP;
            }else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
            count--;
        }
        public int count(){
            return count;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (true){
            int N = in.nextInt();
            if(N == 0) break;
            int M = in.nextInt();
            UF uf = new UF(N);
            while (M-- > 0){
                uf.union(in.nextInt(), in.nextInt());
                in.nextLine();
            }
            System.out.println(uf.count - 1);
        }
    }
}
