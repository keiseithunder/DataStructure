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
public class SinglyLinkedListLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Node node1 =new Node(1,"Tom",20000,null);
        Node node2 =new Node(2,"Jack",30000,null);
        node1.setNext(node2);
        Node node3 =new Node(3,"Ann",40000,node1);
        Node node4 =new Node(4,"Jim",20000,null);
        node2.setNext(node4);
 //     System.out.println(node1.getName());
   //   System.out.println(node1.getNext().getName());
   //   System.out.println(node3.getNext().getNext().getName());
//        System.out.println(node4.next.getName());
        
        SinglyLinkedList list = new SinglyLinkedList();
        list.addToTail(101, "Tony", 20000);
//      System.out.println(list.head.getName());
//      System.out.println(list.tail.getName());
        list.addToTail(102,"Sunny",5000);
        list.addToTail(103,"Sung Kong Chen",68000);
        list.addToTail(104,"Cherprang",16000000);
//      System.out.println("Last node is "+list.tail.getName());
 ///    System.out.println("Last node from the head is "+list.head.next.next.next.getName());
        list.addToHead(201,"OptimusPrime",100000);
//      System.out.println(list.head.getName());
//      System.out.println(list.head.getNext().getName());
        list.addToHead3(202,"Bubble Bee",1000);
//      System.out.println(list.head.getName());
//      System.out.println(list.head.getNext().getName());
        list.printAllNodeName();
        
    }
    
}
