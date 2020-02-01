/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.util;

import java.util.StringTokenizer;

/**
 *
 * @author ibm
 */
public class SQLQueryCalculator {

    public static void main(String[] args){
       // String  str = "insert  into tutor_details(ug_basic_graduation_qualification,ug_specialization,ug_board_university_institute,ug_year_of_passout,pg_qualification,pg_specialization,pg_university_institute,pg_year_of_passout,pref_subject_to_teach,years_of_tutoring_experience,preferred_tutoring_area,teaching_patteren,tutoring_options,teaching_medium,teaching_segment_level,expected_fees,tutoring_experience,registration_date)";
      String str2 = "TUTOR_QUERY002 = update tutor_details set ug_basic_graduation_qualification =?,ug_specialization=?,ug_board_university_institute =?,ug_year_of_passout =?,pg_qualification =?,pg_specialization =?,pg_university_institute=?,pg_university_institute =?,pg_year_of_passout=?,pref_subject_to_teach=?,years_of_tutoring_experience=?,preferred_tutoring_area=?,teaching_patteren =?,tutoring_options = ?, teaching_medium  =?,teaching_segment_level = ?,expected_fees=?,tutoring_experience =?,registration_date=? where tutor_id =?";


        StringTokenizer token = new StringTokenizer(str2, "?");
        int counter  = 0;
        while(token.hasMoreElements()){
            counter +=1;
            System.out.println(" Token Value : " + token.nextToken());
        }
         System.out.println(" Total Token  : "+ counter);
    }

}
