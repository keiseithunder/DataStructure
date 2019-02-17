public class DoublyLL {
    DNode head, tail;
    int size;

    public DoublyLL() {
        head = tail = null;
        size = 0;
    }

    public void addToHead(String info) {
        if (head == null) {
            head = tail = new DNode(info, null, null);
        } else {
            head.prev = new DNode(info, head, null);
            head = head.prev;
        }
    }

    public void addToTail(String info) {
        if (head == null) {
            head = tail = new DNode(info, null, null);
        } else {
            tail.next = new DNode(info, null, tail);
            tail = tail.next;
        }
    }

    public void addAtI(String info, int i) {
        if (i <= 0) {
            addToHead(info);
        } else {
            DNode temp = head;
            for (int j = 0; temp != null && j < i; j++) {
                temp = temp.next;
            }
            if (temp == null) {
                addToTail(info);
            } else {
                temp.prev.next = new DNode(info, temp, temp.prev);
                temp.prev = temp.prev.next;
            }

        }
    }

    public void printAll() {
        for (DNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp + (temp == tail ? "\n" : "-->"));
        }
        if (head == null) {
            System.out.println("Empty List");
        }
    }

    public void deleteFromHead() {
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteFromTail() {
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void delete_i_Node(int i) {
        if (i < 0) {
            System.out.println("Index out bounds");
        } else {
            DNode temp = head;
            for (int j = 0; temp != null && j < i; j++) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Index out bounds2");
            } else if (temp == head) {
                deleteFromHead();
            } else if (temp == tail) {
                deleteFromTail();
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
    }

    // node start at 0
    // list index 0-->1-->2-->3-->4-->5-->6-->7
    // list data a-->b-->c-->d-->e-->f-->g-->h
    // i=1 a(count 0)-->b(printed)-->c(count 0)-->d(printed)-->e(count 0)
    // -->f(printed)-->g(count 0)-->h(printed)
    public void Print_Every_i_Node(int i) {
        DNode temp = head;
        int counter = 0;
        for (int j = 0; temp != null; j++, counter++) {
            if (counter == i) {
                System.out.print(temp + " ");
                counter = -1;
            }
            temp = temp.next;
        }
        System.out.println();
    }
}