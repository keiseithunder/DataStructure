/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sll2ndlab;

/**
 *
 * @author Student
 */
public class SinglyLinkedList {

    int size = 0;
    SLLNode head, tail;

    public SinglyLinkedList() {
        head = null;  //creating an empty list;
        tail = null;  //head and tail do not point to any node.
    }

    public void addToTail(int id, String name, double salary) {
        SLLNode newNode = new SLLNode(id, name, salary, null);
        size++;
        //case1: list is empty
        if (head == null) {
            tail = head = newNode;  //both head and tail will point to the new node
        } else {
            //case2: list is not empty 
            //node->node->node-> ...  ->node
            //head                      tail        
            //add a new node after the tail (add after the last node).
            //node->node->node-> ...  ->node  -> newNode
            //head                                tail            
            tail.next = newNode;  //make the current last node to point to the new node
            tail = newNode;  //move tail pointer to the new node
            // another word, tail will store the address of the new node
        }
    }

    public void addToHead(int id, String name, double salary) {
        SLLNode newNode = new SLLNode(id, name, salary, null);
        size++;
        //case1: empty list
        if (head == null) {
            head = tail = newNode;
        } else {
            //case2: general case when there is(are) node(s) in the list.
            //           node->node->node-> .... -> node
            //           head                       tail
            // newNode-> node->node->node-> .... -> node
            //           head                       tail
            newNode.next = head;
            // newNode-> node->node->node-> .... -> node
            head = newNode;
            //  head                                tail            
        }

    }

    public void addToHead2(int id, String name, double salary) {
        SLLNode newNode = new SLLNode(id, name, salary, null);
        size++;
        //case1: empty list
        if (head == null) {
            head = tail = newNode;
        } else {
            //case2: general case when there is(are) node(s) in the list.
            //           node->node->node-> .... -> node
            //           head                       tail
            // newNode   node->node->node-> .... -> node
            //  head                                tail
            head = newNode;
            // newNode-> node->node->node-> .... -> node
            newNode.next = head;
            //************** wrong solution
        }
    }

    public void addToHead3(int id, String name, double salary) {

        //case1: empty list
        if (head == null) {
            head = tail = new SLLNode(id, name, salary, null);
            size++;
        } else {
            //case2: general case when there is(are) node(s) in the list.
            //           601   825   556            951
            //           node->node->node-> .... -> node
            //  745      head                       tail
            // newNode -> node->node->node-> .... -> node
            //  head                                tail
            head = new SLLNode(id, name, salary, head);
            size++;
            // 745                                  601
            // newNode-> node->node->node-> .... -> node
            //newNode.next=head;       
            //************** wrong solution
        }
    }

    public void printAllNodeName() {
        //head                       tail
        //node->node->node-> .... -> node
        //  p
        //node->node->node-> .... -> node
        //       p
        //node->node->node-> .... -> node
        //             p
        //   ...
        //node->node->node-> .... -> node
        //                             p
        if (head == null) {
            System.out.println("No Node");
        } else {
            SLLNode n = head;
            while (head != null && n != null) {
                //System.out.print(n.getName() + (n.next==null ? " ||Size = "+size+"\n" : " -> "));
                System.out.print(n.getName() + (n.next==null ? "\n" : " -> "));
                n = n.getNext();
            }
            
        }

    }

    public void addAti(int id, String name, double salary, int index) {

        SLLNode temp = head;
        if (index <= 1) {
            addToHead3(id, name, salary);
        } else {
            for (int j = 1; temp != null && j < index - 1; j++) {
                temp = temp.next;
            }
            if (temp == null) {
                addToTail(id, name, salary);
            } else {
                SLLNode newNode = new SLLNode(id, name, salary, null);
                size++;
                newNode.next = temp.next;
                temp.next = newNode;
            }

        }

    }

    public void addAt(int id, String name, double salary, int index) {
        if (index <= 1) {
            addToHead3(id, name, salary);
        } else if (index <= size && index > 1) {
            SLLNode newNode = new SLLNode(id, name, salary, null);
            size++;
            SLLNode temp = head;
            for (int i = 1; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            addToTail(id, name, salary);
        }
    }

    public void deleteFromHead() {
        if (head == tail) {
            head = tail = null;
            size = 0;
        } else {
            head = head.next;
            size--;
        }
    }

    public void deleteFromTail() {
        SLLNode temp = head;
        if (head == tail) {
            head = tail = null;
            size=0;
        } else {
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
            size--;
        }
    }
    public void deleteAt(int i){
        if(i<=1){
            deleteFromHead();
        }else if(i>=size){
            deleteFromTail();
        }else{
            SLLNode temp = head;
            for(int j=1;j<i-1;j++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            size--;
        }
    }
    public void deleteAti(int i){
        if(i<=1){
            deleteFromHead();
        }else{
            SLLNode temp = head;
            for (int j = 1; temp!=null&&j < i-1; j++) {
                temp=temp.next;
            }
            if(temp==null){
                deleteFromTail();
            }else{
                temp.next=temp.next.next;
                size--;
            }
        }
    }
}
//email to narongrit@sit.kmutt.ac.th
//cc chamanee.boo@sit.kmutt.ac.th
//subject CSC209 lab3 61130500xxx
//attach three files: SinglyLinkedListlab.java, SLLNode.java, SinglyLinkedList.java
