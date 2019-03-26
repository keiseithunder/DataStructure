public class BSTNode{
    int info ;
    BSTNode left , right;

    public BSTNode(int info , BSTNode l, BSTNode r){
        this.info = info;
        left = l;
        right = r;
    }
    public BSTNode(int info){
        this.info = info;
        left = right = null;
    }
}