/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;
import java.awt.*;
import java.util.*;

/**
 *
 * @author mao
 */
public class Model {
    Model(){
        
    }
    String output;
    public int[] convertToList(String input){
        String[] liStr={};
        System.out.println("input: " + input);
	liStr = input.split("");
        int[] liInt=new int[25]; 
        for(int i = 0; i<liStr.length;i++){
            try {
                liInt[i] = Integer.parseInt(liStr[i]);
            }
            catch (NumberFormatException e) {
                liInt[i]=liStr[i].charAt(0)+1;
            }
        }
        return liInt;
    }
    
    public int[] hashF(int[] li){
        li[0] = ((li[0]*li[0]+li[24])%li.length)+li[24];
        System.out.print(li[0]);
        for (int i=1; i<25;i++){
            li[i]=((li[i]*li[i]+li[i-1])%li.length)+li[i-1];
        } 
        for (int i=0; i<25;i++){
            li[i]=(li[24-i]+i)%li[i];  
            if(li[i]>9){
                li[i]=li[i]%9;
            }
        }
        return li;
    }
            
    public String printList(int[] li){
        output="";
        for(int i=0;i<li.length;i++){
            if(li[i]>5){
                output= output+String.valueOf((char)(i%7 + 'a' ));
            }
            else{
                output=output+li[i];
            }
            
            
        }
        return output;
    }

}

