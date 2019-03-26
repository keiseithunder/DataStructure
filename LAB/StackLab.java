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
public class StackLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        MyStack stack1= new MyStack(20);
//        for (int i = 0; i < 20; i++) {
//            stack1.push(Integer.toString(i));
//        }
//        for (int i = 0; i < 20; i++) {
//            System.out.println(stack1.pop());
//        }
//        stack1.pop();
        MyStack st = new MyStack(7);
        st.push("Hawaiian");
        st.push("New Orlean");
        st.push("Cheese");
        st.push("Double Pepporony");
        st.push("Meat Deluxe");
        System.out.println(st.pop());
        st.push("Seafood");
        st.push("Tom Yum Kung");
        st.push("Red Pork");
        System.out.println(st.top());
        System.out.println(st.top());
        System.out.println(st.pop());
        System.out.println(st.top());
        System.out.println(checkExpression("()()[][]"));
        System.out.println(checkExpression("5*(2+6-4(5/2)+5"));
        System.out.println(checkExpression("()()[]["));
        System.out.println(checkExpression("()()[]]"));
        System.out.println(checkExpression("()[()()][]"));
        System.out.println(checkPalindrome("abacaba"));
        System.out.println(checkPalindrome("madaminedenimadam"));
        System.out.println(checkPalindrome("IIIIIIIA"));
    }

    public static boolean checkExpression(String ex) {
        MyStack stackForExpression = new MyStack(ex.length());
        System.out.print("Check Expression : "+ex+"\n");
        for (int i = 0; i < ex.length(); i++) {
            char c = ex.charAt(i);
            if (c == '(' || c == '[') {
                stackForExpression.push(c + "");
            } else if (c == ')' || c == ']') {
                if (stackForExpression.isEmpty()) {
                    //System.out.println("Expression is invalid!");
                    return false;
                } else {
                    char c2 = stackForExpression.pop().charAt(0);
                    if (!((c == ')' && c2 == '(') || (c == ']' && c2 == '['))) {
                        //System.out.println("Expression is invalid!");
                        return false;
                    }
                }
            }
        }
        if (stackForExpression.isEmpty()) {
            //System.out.println("Expression is valid");
            return true;
        }

        return false;

    }

    public static boolean checkPalindrome(String s) {
        MyStack checkPalin = new MyStack(s.length() / 2);
        System.out.print("Check Palindome : "+s+"\n");
        s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() / 2) {
                checkPalin.push(s.charAt(i) + "");
            } else if (s.length() % 2 == 1 && i == s.length() / 2 ) {

            } else if (checkPalin.pop().charAt(0) != s.charAt(i)) {
                //System.out.println(i);
                return false;
            }
        }

        return true;
    }

    public static boolean palindome(String s) {
        MyStack st = new MyStack(s.length());
        return false;
    }

}
