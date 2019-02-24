
public class SinglyLinkedList {

    SLLNode head, tail;
    int size = 0;

    public SinglyLinkedList() {
        head = null; // creating an empty list;
        tail = null; // head and tail do not point to any node.
    }

    public void addToTail(String id) {
        if (head == null) {
            head = tail = new SLLNode(id, null);
            size++;
        } else {
            tail.next = new SLLNode(id, null);
            tail = tail.next;
            size++;
        }
    }

    public boolean checkIdentical(SinglyLinkedList x) {
        if (size == x.size) {
            if (size == 0) {
                return true;
            } else {
                SLLNode currNode = head;
                for (int i = 0; i < size; i++, currNode = currNode.next) {
                    SLLNode currNodeX = x.head;
                    boolean check = false;
                    for (int j = 0; j < size; j++, currNodeX = currNodeX.next) {
                        if (currNodeX.id.equals(currNode.id)) {
                            check = true;
                            break;
                        }
                    }
                    if (!check) {
                        return false;
                    }
                }
                // Check 2nd time
                SLLNode REcurrNode = x.head;
                for (int i = 0; i < size; i++, REcurrNode = REcurrNode.next) {
                    SLLNode REcurrNodeX = head;
                    boolean check = false;
                    for (int j = 0; j < size; j++, REcurrNodeX = REcurrNodeX.next) {
                        if (REcurrNodeX.id.equals(REcurrNode.id)) {
                            check = true;
                            break;
                        }
                    }
                    if (!check) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}