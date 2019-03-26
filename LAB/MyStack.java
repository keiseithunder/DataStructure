/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacklab;

/**
 *
 * @author Student
 */
public class MyStack {

    String[] info;
    int top;

    public MyStack(int n) {
        info = new String[n];
        top = 0;
    }

    public void push(String info) {
        if (!isFull()) {
            this.info[top] = info;
            top++;
        } else {
            System.out.println("Stack is full");
        }
    }

    public String pop() {
        if (!isEmpty()) {
            top--;  
            return this.info[top];
        }
        System.out.println("this stack is empty");
        return "this stack is empty";
    }

    public String top() {
        if (!isEmpty()) {
            return info[top-1];
        }
        System.out.println("this stack is empty");
        return "";
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
}
