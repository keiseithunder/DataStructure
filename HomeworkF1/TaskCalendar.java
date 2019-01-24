/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskcalendar;

/**
 *
 * @author Student
 */
public class TaskCalendar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Task t = new Task(24, "Feb", 2019, 10, 24, "Feb", 2019, 11, "Learning Data Structure", "Learn Random Access File");
        System.out.println(t);
        TaskFile f =new TaskFile("task.dat");
        f.writeToFile(t);
        f.readFromFile();
        Task t2 = new Task(24, "Feb", 2019, 10, 24, "Feb", 2019, 11, "Learning Data Structure 2nd time", "not Learn Random Access File 2nd time");
        Task t3 = new Task(24, "Feb", 2020, 10, 24, "Feb", 2019, 11, "Learning Algoriths", "Learn B-tree");
        Task t4 = new Task(15, "Feb", 2019, 10, 24, "Feb", 2019, 11, "Learning Java", "Learn OOP");
        f.writeToFile(t2);
        f.writeToFile(t3);
        f.writeToFile(t4);
        f.showAllTitle();
        
        
    }

}
