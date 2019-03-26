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
public class Node {
    int id;
    String name;
    double salary;
    
    Node next;

    public Node() {
        this(0,"",0,null);
    }

    
    public Node(int id, String name, double salary, Node next) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    

    
    
}
