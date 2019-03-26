import java.util.*;
public class PlusString{
    public static void main(String[] args) {
        String n1 = "1111111111111111111111111111111";
        String n2 = "999999999999999999999999999999";
                  //1111111111111111111111111111110
        MyStack st1 = new MyStack(n1.length());
        MyStack st2 = new MyStack(n2.length());
        MyStack ans = new MyStack(n1.length()>n2.length()?(n1.length()+1):(n2.length()+1));
        for (int i = 0; i < n1.length(); i++) {
            st1.push(Integer.parseInt(n1.substring(i, i+1)));
        }
        for (int i = 0; i < n2.length(); i++) {
            st2.push(Integer.parseInt(n2.substring(i, i+1)));
        }
        int carry =0;
        int result=0;
        while(carry==1||!(st1.isEmpty()&&st2.isEmpty())){
            if(st1.isEmpty()&&!st2.isEmpty()){
                result= st2.pop()+carry;
                carry = result/10;
                result=result%10;
                //System.out.println("full1 "+carry);
                ans.push(result);
            }else if(!st1.isEmpty()&&st2.isEmpty()){
                result= st1.pop()+carry;
                carry = result/10;
                result=result%10;
                //System.out.println("full2 "+carry);
                ans.push(result);
            }else if(st1.isEmpty()&&st2.isEmpty()){
                ans.push(carry);
                //System.out.println("full3 "+carry);
                carry=0;
            }else{
                result=st1.pop()+st2.pop()+carry;
                carry = result/10;
                result=result%10;
                //System.out.println("full4 "+carry);
                ans.push(result);
            }
        }
        String output="";
        while(!ans.isEmpty()){
            output=output+ans.pop();
        }
        System.out.println(output);
    }
}