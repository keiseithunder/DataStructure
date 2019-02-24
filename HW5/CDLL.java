public class CDLL{
    DNode head;
    int size;
    public static DNode[] allN=new DNode[5];
    public static int index=0;

    public void addToTail(String info) {
        if (head == null) {
            allN[index]=head =  new DNode(info, null, null);
            index++;
        } else {
            DNode temp=head;
            while(temp.next!=head)
            allN[index]=tail.next = new DNode(info, head, tail);
            index++;
            tail = tail.next;
            head.prev=tail;
        }
    }
}