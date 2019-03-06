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
public class info {
    static byte rank =1;
    byte objRank;
    String word;
    static final int max_word=40;

    public info(String word) {
        objRank = rank++;
        this.word = word;
    }
    
    public String toString(){
        return objRank+". "+word;
    } 
    
    
}
