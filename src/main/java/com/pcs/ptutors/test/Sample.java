/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALOK
 */
public class Sample {

    public static void main(String []args){

        List<String> lst = new ArrayList<String>();
        
        lst.add("A");
        lst.add("B");
        lst.add("C");
        lst.add("D");
        lst.add("E");
        lst.add("F");
        lst.add("G");
        lst.add("H");
        lst.add("I");

        String []  str = new String[3];

         str[0] = lst.get(0) + lst.get(1) + lst.get(2);

         System.out.println(" Str 0 : " + str[0]);
       
      
    }
}
