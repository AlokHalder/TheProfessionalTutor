/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ibm
 */
public class RegistrationDateCalculation {

    public static String getExpiryDate(int duration){
        Date  today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        int dayOfYr = calendar.get(Calendar.DAY_OF_YEAR);

        int result =  dayOfYr+(duration*30);
        
        calendar.set(Calendar.DAY_OF_YEAR, result);

        System.out.println(calendar.getTime());

        Date output = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String returnStr  = sdf.format(output);

        return returnStr;

    }

    public static String getExpiryWarningDate(int duration){

        Date  today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        int dayOfYr = calendar.get(Calendar.DAY_OF_YEAR);
        int result =  dayOfYr+((duration*30)-15);

        calendar.set(Calendar.DAY_OF_YEAR, result);

        System.out.println(calendar.getTime());

        Date output = calendar.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        String returnStr  = sdf.format(output);
        
        return returnStr;

    }

    public static void main(String[] args){
        getExpiryDate(12);
    }

}
