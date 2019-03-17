package lanqiaoPractice.tree;

public class HDU1166 {
    private static class Tree{
        private Node root;
        private class Node{
            int mid;
            Node leftTree;
            Node rightTree;
            Node parent;
            Node(int mid, Node parent){
                this.mid = mid;
                this.parent = parent;
            }
        }
        Tree(int left, int right){
            root = build(left, right, null);
        }
        private Node build(int left, int right, Node parent){
            if(right - left == 1) return null;
            int mid = (left + right) / 2;
            Node x = new Node(mid, parent);
            x.leftTree = build(left, mid, x);
            x.rightTree = build(mid + 1, right, x);
            return x;
        }
    }
}
