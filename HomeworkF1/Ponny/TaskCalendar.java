
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */

class Task {
    public double test;
    public Task(double test) {
        this.test = test;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
class TaskFile {

    String fileName;
    RandomAccessFile filePointer;

    public TaskFile(String fileName) {
        this.fileName = fileName;

    }

    public boolean writeToFile(Task t) {
        try {
            filePointer = new RandomAccessFile(fileName, "rw");
            filePointer.seek(filePointer.length());//move to end of file
                                                   //before start writing
            filePointer.writeDouble(t.test);
            filePointer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TaskFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(TaskFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}

public class TaskCalendar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int count=1;
        double memory=0;
        while(true) {
            Task t = new Task(count);
            TaskFile f =new TaskFile("task.dat");
            f.writeToFile(t);
            memory +=8;
            System.out.println("Loop : "+ count + " Writen : " +(memory/1024)/1024 +" MB");
            count++;
        }
        
    }

}
