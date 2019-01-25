
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
    private double test;
    //int startDay;//0:sunday 1:mon ...,6:dat
    private int startDate;
    private String startMonth;//3-char months: jan, Feb
    private int startYear;
    private int startHour;
    //int startMinute;

    public Task(double test) {
        this.test = test;
    }

    private int endDate;
    private String endMonth;//3-char months: jan, Feb
    private int endYear;
    private int endHour;
    //int endMinute;
    private String title;
    private String detail;
    //task size is 4+3+4+4+4+3+4+4+40+100=170
    static final int TITLE_SIZE=40;
    static final int DETAIL_SIZE=100;

    public Task(int startDate, String startMonth, int startYear, int startHour, int endDate, String endMonth, int endYear, int endHour, String title, String detail) {
        this.startDate = startDate;
        this.startMonth = monthValidate(startMonth);
        this.startYear = startYear;
        this.startHour = startHour;
        this.endDate = endDate;
        this.endMonth = monthValidate(endMonth);
        this.endYear = endYear;
        this.endHour = endHour;
        this.title = title;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public int getStartDate() {
        return startDate;
    }
    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }
    public String getStartMonth() {
        return startMonth;
    }
    public void setStartMonth(String startMonth) {
        this.startMonth = monthValidate(startMonth);
    }
    public int getStartYear() {
        return startYear;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
    public int getStartHour() {
        return startHour;
    }
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }
    public int getEndDate() {
        return endDate;
    }
    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }
    public String getEndMonth() {
        return endMonth;
    }
    public void setEndMonth(String endMonth) {
        this.endMonth = monthValidate(endMonth);
    }
    public int getEndYear() {
        return endYear;
    }
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
    public int getEndHour() {
        return endHour;
    }
    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String monthValidate(String m) {
        String[] months = {"jan", "feb", "mar", "apr", "may", "jun",
            "jul", "aug", "sep", "oct", "nov", "dec"};
        for(String s: months){
            if(m.equalsIgnoreCase(s)){
                return m;
            }
        }
        System.out.println("This is not a valid month. We set to Jan.");
        return "Jan";
    }

    @Override
    public String toString() {
        return "Task{" + "Start " + startDate + "/" + startMonth + "/" + startYear + " at " + startHour + ", End " + endDate + "/" + endMonth + "/" + endYear + " at " + endHour + ", title=" + title + ", detail=" + detail + '}';
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

public class TaskCalendar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int count=1;
        while(true) {
        Task t = new Task(count);
        System.out.println(t);
        TaskFile f =new TaskFile("task.dat");
        f.writeToFile(t);
        count++;
        }
        
    }

}
