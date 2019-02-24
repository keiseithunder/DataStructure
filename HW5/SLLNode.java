
public class SLLNode {
    String id;         //info

    SLLNode next;

    public SLLNode(String id, SLLNode n) {
        this.id = id;
        next=n;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public SLLNode getNext() {
        return next;
    }
    public void setNext(SLLNode next) {
        this.next = next;
    }
    
    
    
}
