/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlistlab;

/**
 *
 * @author Student
 */
public class SinglyLinkedList {
    Node head, tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    public void addToTail(int id,String name,double salary){
        //Add new node after the tail
        Node newNode = new Node(id, name, salary,null);
        if(head==null){
            head=newNode;
        }else{
            tail.setNext(newNode);
        }
        tail = newNode;
    }
    public void addToHead(int id,String name,double salary){
        Node newNode =new Node(id, name, salary, null);
        if(head==null){
            head =tail=  newNode;
        }else{
            newNode.setNext(head);
            head=newNode;
        }
    }
    public void addToHead2(int id,String name,double salary){
        Node newNode =new Node(id, name, salary, null);
        if(head==null){
            head =tail=  newNode;
        }else{
            head=newNode;
            newNode.setNext(head);
            
        }
    }
    public void addToHead3(int id,String name,double salary){
        if(head==null){
            head =tail=  new Node(id, name, salary, null);
        }else{
            head =new Node(id, name, salary, head);
        }
    }
    public void printAllNodeName(){
        Node n = head;
        while(head!=null&&n!=null){
            System.out.print(n.getName()+ (n==tail?" ":" -> "));
            n=n.getNext();
        }
        
    }
    
}
