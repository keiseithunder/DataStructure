

public class DLLDriver{
    public static void main(String[] args) {
        DoublyLL list1 = new DoublyLL();
        for (int i = 1; i < 6; i++) {
            list1.addToTail(Integer.toString(i));
        }
        for (DNode var : DoublyLL.allN) {
            System.out.println(var);
        }
    }   
}