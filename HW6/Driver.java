public class Driver{
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(15);
        tree.insert(16);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(1);
        tree.insert(17);
        tree.insert(5);
        // System.out.println(tree.countAllNode());
        // System.out.println(tree.countAllLeaves());
        // System.out.println(tree.countRightChild());
        // System.out.println(tree.countHeight());
        BST tree2 = new BST();
        tree2.insert(10);
        tree2.insert(15);
        tree2.insert(17);
        tree2.insert(12);
        tree2.insert(5);
        tree2.insert(3);
        tree2.insert(7);
        // tree2.deleteAllLeaves();
        // tree2.preorder(tree2.root);
        tree.preorder(tree.root);
        System.out.println();
        tree.deleteAllLeaves();
        tree.preorder(tree.root);
        
    }
}