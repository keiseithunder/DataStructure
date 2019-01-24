/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskcalendar;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Student
 */
public class TaskFile {

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
            filePointer.writeInt(t.getStartDate());
            filePointer.write(t.getStartMonth().getBytes(), 0, 3);
            filePointer.writeInt(t.getStartYear());
            filePointer.writeInt(t.getStartHour());

            filePointer.writeInt(t.getEndDate());
            filePointer.write(t.getEndMonth().getBytes(), 0, 3);
            filePointer.writeInt(t.getEndYear());
            filePointer.writeInt(t.getEndHour());
            String title = t.getTitle();
            title += "                                                           ";
            filePointer.write(title.getBytes(), 0, t.TITLE_SIZE);
            String detail = t.getDetail();
            detail += "                                                           ";
            detail += "                                                           ";
            filePointer.write(detail.getBytes(), 0, t.DETAIL_SIZE);
            filePointer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TaskFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(TaskFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean readFromFile() {
        try {
            RandomAccessFile fPointer = new RandomAccessFile(fileName, "r");
            int date = fPointer.readInt();
            byte[] month = new byte[3];
            fPointer.read(month, 0, 3);
            int year = fPointer.readInt();
            int time = fPointer.readInt();
            System.out.println("Date : "+date+"/"+(new String(month))+"/"+year+" at "+time+".");
            fPointer.seek(fPointer.getFilePointer()+(4+3+4+4));
            byte[] title = new byte[Task.TITLE_SIZE];
            fPointer.read(title, 0, Task.TITLE_SIZE);
            byte[] detail = new byte[Task.DETAIL_SIZE];
            fPointer.read(detail, 0, Task.DETAIL_SIZE);
            System.out.println("Title : "+(new String(title)).trim()+" ||Detail : "+(new String(detail)).trim());
            fPointer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TaskFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(TaskFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public void showAllTitle(){
        try {
            RandomAccessFile fPointer = new RandomAccessFile(fileName, "r");
            fPointer.seek(30);
            byte[] title= new byte[Task.TITLE_SIZE];
            int taskNumber=0;
            while(fPointer.getFilePointer()<=fPointer.length()){
                fPointer.read(title, 0, Task.TITLE_SIZE);
                System.out.println((new String(title)).trim());
                taskNumber++;
                fPointer.seek(taskNumber*170+(4+3+4+4)+(4+3+4+4));
            }
            fPointer.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
