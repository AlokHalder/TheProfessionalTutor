/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ibm
 */
public class UserValidation {

    public static void main(String[] args ){
       try{
        String dateStr = "20/09/2010";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date =sdf.parse(dateStr);

        Calendar dbdate = new GregorianCalendar();
        dbdate.setTime(date);

        Date currentDate = new Date();

        Calendar cal = new GregorianCalendar();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        
        int year1 = dbdate.get(Calendar.YEAR);
        int month1 = dbdate.get(Calendar.MONTH);
        int day1 = dbdate.get(Calendar.DAY_OF_MONTH);

   


       }catch(Exception e){
           e.printStackTrace();
       }
    }


}
