import java.util.Scanner;

/*  Class Node  */
class Node {
    protected int data;
    protected Node next, prev;

    /* Constructor */
    public Node() {
        next = null;
        prev = null;
        data = 0;
    }

    /* Constructor */
    public Node(int d, Node n, Node p) {
        data = d;
        next = n;
        prev = p;
    }

    /* Function to set link to next node */
    public void setLinkNext(Node n) {
        next = n;
    }

    /* Function to set link to previous node */
    public void setLinkPrev(Node p) {
        prev = p;
    }

    /* Funtion to get link to next node */
    public Node getLinkNext() {
        return next;
    }

    /* Function to get link to previous node */
    public Node getLinkPrev() {
        return prev;
    }

    /* Function to set data to node */
    public void setData(int d) {
        data = d;
    }

    /* Function to get data from node */
    public int getData() {
        return data;
    }
    public String toString(){
        return data+" "+next.getData()+" "+ prev.getData();
    }
}

/* Class linkedList */
class linkedList {
    protected Node start;
    protected Node end;
    public int size;
    public static Node[] allN=new Node[5];
    public static int index=0;

    /* Constructor */
    public linkedList() {
        start = null;
        end = null;
        size = 0;
    }

    /* Function to check if list is empty */
    public boolean isEmpty() {
        return start == null;
    }

    /* Function to get size of list */
    public int getSize() {
        return size;
    }

    /* Function to insert element at begining */
    public void insertAtStart(int val) {
        Node nptr = new Node(val, null, null);
        if (start == null) {
            nptr.setLinkNext(nptr);
            nptr.setLinkPrev(nptr);
            start = nptr;
            end = start;
        } else {
            nptr.setLinkPrev(end);
            end.setLinkNext(nptr);
            start.setLinkPrev(nptr);
            nptr.setLinkNext(start);
            start = nptr;
        }
        size++;
    }

    /* Function to insert element at end */
    public void insertAtEnd(int val) {
        Node nptr = new Node(val, null, null);
        allN[index]=nptr;
        index++;
        if (start == null) {
            nptr.setLinkNext(nptr);
            nptr.setLinkPrev(nptr);
            start = nptr;
            end = start;
        } else {
            nptr.setLinkPrev(end);
            end.setLinkNext(nptr);
            start.setLinkPrev(nptr);
            nptr.setLinkNext(start);
            end = nptr;
        }
        size++;
    }

    /* Function to insert element at position */
    public void insertAtPos(int val, int pos) {
        Node nptr = new Node(val, null, null);
        if (pos == 1) {
            insertAtStart(val);
            return;
        }
        Node ptr = start;
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                Node tmp = ptr.getLinkNext();
                ptr.setLinkNext(nptr);
                nptr.setLinkPrev(ptr);
                nptr.setLinkNext(tmp);
                tmp.setLinkPrev(nptr);
            }
            ptr = ptr.getLinkNext();
        }
        size++;
    }

    /* Function to delete node at position */
    public void deleteAtPos(int pos) {
        if (pos == 1) {
            if (size == 1) {
                start = null;
                end = null;
                size = 0;
                return;
            }
            start = start.getLinkNext();
            start.setLinkPrev(end);
            end.setLinkNext(start);
            size--;
            return;
        }
        if (pos == size) {
            end = end.getLinkPrev();
            end.setLinkNext(start);
            start.setLinkPrev(end);
            size--;
        }
        Node ptr = start.getLinkNext();
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                Node p = ptr.getLinkPrev();
                Node n = ptr.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                size--;
                return;
            }
            ptr = ptr.getLinkNext();
        }
    }

    /* Function to display status of list */
    public void display() {
        System.out.print("\nCircular Doubly Linked List = ");
        Node ptr = start;
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (start.getLinkNext() == start) {
            System.out.print(start.getData() + " <-> " + ptr.getData() + "\n");
            return;
        }
        System.out.print(start.getData() + " <-> ");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != start) {
            System.out.print(ptr.getData() + " <-> ");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getData() + " <-> ");
        ptr = ptr.getLinkNext();
        System.out.print(ptr.getData() + "\n");
    }
}

/* Class CircularDoublyLinkedList */
public class CircularDoublyLinkedList {
    public static void main(String[] args) {
        linkedList list1 = new linkedList();
        for (int i = 1; i < 6; i++) {
            list1.insertAtEnd(i);
        }
        //list1.display();
        //System.out.println(linkedList.allN[0].getData());
        for (Node var : linkedList.allN) {
            System.out.println(var);
        }
        list1.start.next.next.next=list1.start.prev;
        System.out.println("----------------------------------");
        for (Node var : linkedList.allN) {
            System.out.println(var);
        }
        list1.start.prev.prev.prev=list1.start.next.next.next.prev;
        System.out.println("----------------------------------");
        for (Node var : linkedList.allN) {
            System.out.println(var);
        }
        list1.start.next.next.next.prev=list1.start.prev.prev.prev;
        System.out.println("----------------------------------");
        for (Node var : linkedList.allN) {
            System.out.println(var);
        }
        list1.start.next=list1.start.next.next;
        System.out.println("----------------------------------");
        for (Node var : linkedList.allN) {
            System.out.println(var);
        }
        list1.start.next.prev.next=list1.start.next.next.next;
        System.out.println("----------------------------------");
        for (Node var : linkedList.allN) {
            System.out.println(var);
        }
        //Node P = new Node(info,new Node(info,new Node(info,null)));
    }
}