/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ALOK
 */
public class NewClass {
     public static void main(String[] args) {
        List list = new ArrayList();
        list.add(" Pankaj...");
        list.add(" Subhendu..");
        
         System.out.println(" Size : "+ list.size());

        Iterator itr = list.iterator();

        while(itr.hasNext()){
            String  str = (String) itr.next();
            System.out.println(" Name : " + str);

        }


          List<String> list1 = new ArrayList<String>();
        list1.add(" Amzad...");
        list1.add(" Somnath..");

         System.out.println(" Size : "+ list1.size());
         for(String str : list1){
             System.out.println(" Name : " + str);
         }



    }


}
