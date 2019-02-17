public class DNode{
    String info;
    DNode next,prev;

    public DNode(String info,DNode next,DNode prev){
        this.info=info;
        this.next=next;
        this.prev=prev;
    }
    public String toString(){
        return info;
    }
}