/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testraf;

/**
 *
 * @author Student
 */
public class TestRAF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        info a1 = new info("1");
        info a2 = new info("2");
        info a3 = new info("3");
        info a4 = new info("4");
        info a5 = new info("5");
        info a6 = new info("6");
        RAFmanager r1 = new RAFmanager("file1");
//        r1.writeTofile(a1);
//        r1.writeTofile(a2);
//        r1.writeTofile(a3);
//        r1.writeTofile(a4);
//        r1.writeTofile(a5);
//        r1.writeTofile(a6);
        r1.readAtRankInfo(6);
    }
    
}
