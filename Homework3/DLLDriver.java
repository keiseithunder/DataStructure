

public class DLLDriver{
    public static void main(String[] args) {
        DoublyLL list1 = new DoublyLL();
        for (int i = 0; i < 25; i++) {
            list1.addToTail(Integer.toString(i));
        }
        list1.printAll();
        for (int i = 24; i >=0; i-=3) {
            list1.delete_i_Node(i);
        }
        list1.printAll();
        list1.Print_Every_i_Node(3);
        DoublyLL list2 = new DoublyLL();
        list2.addToTail("a");
        list2.addToTail("b");
        list2.addToTail("c");
        list2.addToTail("d");
        list2.addToTail("e");
        list2.addToTail("f");
        list2.addToTail("g");
        list2.addToTail("h");
        list1.printAll();
        list2.Print_Every_i_Node(1);
    }   
}