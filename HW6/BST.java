import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
public class BST{
    BSTNode root;

    public BST(){
        root = null;
    }
    public void insert(int data){
        if(root == null){
            root = new BSTNode(data);
        }else {
            BSTNode temp = root; 
            while(true){
                if(temp.info> data){
                    if(temp.left==null){
                        temp.left = new BSTNode(data);
                        break;
                    }
                    temp = temp.left;
                }else{
                    if(temp.right==null){
                        temp.right = new BSTNode(data);
                        break;
                    }
                    temp = temp.right;
                }
            }
        }
    }
    public int countAllNode(){
        BSTNode temp = root;
        return countHelper(temp);
    }
    public int countHelper(BSTNode node){
        if(node == null){
            return 0;
        }
        return 1+countHelper(node.left) + countHelper(node.right);
    }
    public int countAllLeaves(){
        BSTNode temp = root;
        return countLeavesHelper(temp);
    }
    public int countLeavesHelper(BSTNode node){
        if(node == null){
            return 0;
        }
        else if(node.left==null&&node.right==null){
            return 1;
        }
        return countLeavesHelper(node.left)+countLeavesHelper(node.right);
    }
    public int countRightChild(){
        BSTNode temp = root;
        if(temp==null){
            return 0;
        }
        return countRightChildHelper(temp);
    }
    public int countRightChildHelper(BSTNode node){
        if(node == null){
            return 0;
        }
        if(node.right!=null){
            return 1+countRightChildHelper(node.right)+countRightChildHelper(node.left);
        }
        return countRightChildHelper(node.left);
    }
    public int count2(){
        if(root == null){
            return 0;
        }
        BSTNode temp = root;
        Stack<BSTNode> stack = new Stack<>();
        stack.push(temp);
        int count = 0;
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(temp.right!=null){
                stack.push(temp.right);
                count++;
            }if(temp.left!=null){
                stack.push(temp.left);
            }
        }
        return count;
    }
    public int count3(BSTNode node){
        if(node == null){
            return 0;
        }
        int num_l = 0;
        int num_r = 0;
        if(node.right!=null){
            num_r += (1+count3(node.right));
        }if(node.left!=null){
            num_l += count3(node.left);
        }
        return num_l+num_r;
    }
    public void preorder(BSTNode node){
        if(node!=null){
            System.out.print(node.info+" ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public int countHeight(){
        if(root == null){
            return 0;
        }
        int height = 1;
        Queue<BSTNode> queue = new LinkedList<>(); 
        queue.add(root);
        int add = 1;
        int out = 0;
        int newAdd = 0;
        while(!queue.isEmpty()){
            while(add>out){
                if(queue.peek().left!=null){
                    queue.add(queue.peek().left);
                    newAdd++;
                }
                if(queue.peek().right!=null){
                    queue.add(queue.peek().right);
                    newAdd++;
                }
                queue.remove();
                out++;
            }
            if(newAdd>0){
                height++;
            }
            add= newAdd;
            out=0;
            newAdd=0;
        }
        return height;
    }

    public void deleteAllLeaves(){
        if(root!=null){
            deleteAllLeavesHelper(root);
        }
    }
    public void deleteAllLeavesHelper(BSTNode node){
        if(node == null){
            return;
        }
        if(node.left!=null&&node.left.left==null&&node.left.right==null){
            node.left = null;
        }else{
            deleteAllLeavesHelper(node.left);
        }
        if(node.right!=null&&node.right.left==null&&node.right.right==null){
            node.right = null;
        }else{
            deleteAllLeavesHelper(node.right);
        }
    }
}