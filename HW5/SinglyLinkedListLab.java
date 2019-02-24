public class SinglyLinkedListLab {


    public static void main(String[] args) {
        SinglyLinkedList list1= new SinglyLinkedList();
        list1.addToTail("1");
        list1.addToTail("1");
        list1.addToTail("2");
        SinglyLinkedList list2= new SinglyLinkedList();
        list2.addToTail("2");
        list2.addToTail("1");
        list2.addToTail("3");
        System.out.println(list1.checkIdentical(list2)); 
    }
}







