/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testraf;

import java.io.*;

/**
 *
 * @author Student
 */
public class RAFmanager {
    String fName;
    RandomAccessFile fPointer;

    public RAFmanager(String name) {
        this.fName=name;
    }
    
    public boolean writeTofile(info obj){
        try{
            fPointer = new RandomAccessFile(fName, "rw");
            fPointer.seek(fPointer.length());
            fPointer.writeByte(obj.objRank);
            String objWord = obj.word;
            objWord+="                                                         ";
            fPointer.write(objWord.getBytes(),0,info.max_word);
            
        }catch(Exception e){
            System.out.println("Something error");
            return false;
        }
        return true;
    }
    public boolean readAllInfo(){
        try {
            fPointer = new RandomAccessFile(fName, "r");
            int taskNumber=0;
            fPointer.seek(1);
            while (fPointer.getFilePointer()<fPointer.length()) {                
                byte[] infoByte = new byte[info.max_word];
                fPointer.read(infoByte,0,info.max_word);
                System.out.println(new String(infoByte).trim());
                taskNumber++;
                fPointer.seek(taskNumber*40+1);
                //System.out.println(fPointer.getFilePointer());
            }
        } catch (Exception e) {
            System.out.println("Something error");
            return false;
        }
        return true;
    }
    public boolean printAll(){
        try {
            fPointer = new RandomAccessFile(fName,"r");
            byte[] infoByte = new byte[info.max_word];
            int task=0;
            while (fPointer.getFilePointer()<fPointer.length()) {                
                System.out.print(fPointer.readByte()+". ");
                fPointer.read(infoByte,0,info.max_word);
                System.out.println(new String(infoByte).trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something error");
            return false;
        }
        return true;
    }
    public boolean readAtRankInfo(int x){
        try {
            fPointer = new RandomAccessFile(fName,"r");
            int counter=0;
            while(fPointer.getFilePointer()<fPointer.length()){
                fPointer.seek(counter*41);
                //System.out.println(fPointer.getFilePointer());
                if((int)fPointer.readByte()==x){
                    byte[] infoByte = new byte[info.max_word];
                    fPointer.read(infoByte,0,info.max_word);
                    System.out.println(new String(infoByte).trim());
                }
                counter++;
            }
        } catch (Exception e) {
            System.out.println("Something error");
            return false;
        }
        return true;
    }
    
    
}
