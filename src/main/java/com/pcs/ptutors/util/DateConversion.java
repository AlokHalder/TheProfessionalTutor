/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.util;

/**
 *
 * @author ibm
 */
public class DateConversion {

    public static String convertDate(String date){
         String returnDate= null;
          if(null != date){
           String year = date.substring(0, 4);
           String month = date.substring(5,7);
           String day = date.substring(8, 10);

           returnDate = day + "-"+ month + "-"+ year;
          }
           return returnDate;

    }
}
