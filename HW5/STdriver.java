class STdriver {
    public static void main(String[] args) {
        
          MyStack st1 = new MyStack(10); st1.push(10); st1.push(9); st1.push(8);
          st1.push(7); st1.push(6); st1.push(5); st1.push(4); st1.push(3); st1.push(2);
          st1.push(1); st1 = ascendingStack(st1); st1.popAll();
         
        System.out.println();
        MyStack st3 = new MyStack(10);
        st3.push(10);
        st3.push(9);
        st3.push(8);
        st3.push(7);
        st3.push(6);
        st3.push(5);
        st3.push(4);
        st3.push(3);
        st3.push(2);
        st3.push(1);
        MyStack st2 = new MyStack(10);
        st2.push(111);
        tranferHelper(st3, st2);
        st2.popAll();

    }

    // For int Value
    public static MyStack ascendingStack(MyStack st) {
        MyStack newSt = new MyStack(st.max);
        while (st.size() > 0) {
            if (newSt.isEmpty()) {
                newSt.push(st.pop());
            } else {
                if (st.top() <= newSt.top()) {
                    newSt.push(st.pop());
                } else {
                    int s = st.pop();
                    st.push(newSt.pop());
                    for (int i = newSt.top; i > 0; i--) {
                        if (s > newSt.top()) {
                            st.push(newSt.pop());
                        }
                    }

                    newSt.push(s);
                }
            }
        }
        for (int i = newSt.size(); i > 0; i--) {
            st.push(newSt.pop());
        }

        return st;
    }

    public static MyStack stackTransferUseStack(MyStack st1, MyStack st2) {
        st2.top = 0;
        MyStack temp = new MyStack(st1.size());
        while (!st1.isEmpty()) {
            temp.push(st1.pop());
        }
        while (!temp.isEmpty()) {
            st2.push(temp.pop());
        }
        return st2;
    }

    public static MyStack stackTransferNotUseStack(MyStack st1, MyStack st2) {
        int temp = 0;
        st2.top = 0;
        for (int i = 1; i <= st1.size(); i++) {
            for (int j = 0; j < i; j++) {
                st2.push(st1.pop());
            }
            temp = st2.pop();
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
            st1.push(temp);
        }
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        return st2;
    }

    public static void tranferHelper(MyStack st1, MyStack st2){
        st2.top = 0;
        int temp;
        if(!st1.isEmpty()){
            temp=st1.pop();
            tranferHelper(st1,st2);
            st2.push(temp);
        }
    }

}