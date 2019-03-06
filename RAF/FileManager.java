import java.io.*;
import java.util.*;
class FileManager{
    String FileName;
    RandomAccessFile FilePointer;

    public FileManager(String name){
        FileName=name;
    }
    public boolean writeToFile(Student s){
        try{
            FilePointer = new RandomAccessFile(FileName, "rw");
            FilePointer.seek(FilePointer.length());
            FilePointer.writeInt(s.id);
            String SName = s.name;
            SName+="                                                                                    ";
            FilePointer.write(SName.getBytes(), 0, Student.max_name);
            FilePointer.close();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean readFromFile(){
        try{
            FilePointer = new RandomAccessFile(FileName, "r");
            int counter=0;
            FilePointer.seek(3);
            while(FilePointer.getFilePointer()<FilePointer.length()){
                byte[] sName = new byte[Student.max_name];
                FilePointer.read(sName,0,Student.max_name);
                System.out.println(new String(sName).trim());
                counter++;
                FilePointer.seek(counter*54+4);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
}