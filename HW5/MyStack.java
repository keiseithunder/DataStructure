public class MyStack {

    int[] info;
    int top;
    int max;

    public MyStack(int n) {
        info = new int[n];
        top = 0;
        max=n;
    }

    public void push(int info) {
        if (!isFull()) {
            this.info[top] = info;
            top++;
        } else {
            System.out.println("Stack is full");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            top--;  
            return this.info[top];
        }
        System.out.println("this stack is empty");
        return 0;
    }

    public int top() {
        if (!isEmpty()) {
            return info[top-1];
        }
        System.out.println("this stack is empty");
        return -99;
    }

    public boolean isFull() {
        return top == info.length;
    }

    public boolean isEmpty() {
        return top == 0;
    }
    public int size(){
        return top;
    }
    public void popAll(){
        if(top!=0){
            for (int i = top-1;i >=0; i--) {
                System.out.print((top)+"."+pop()+" ");
            }
        }
    }
}