/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.util;

import com.pcs.ptutors.vo.ListOfValuesVO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ALOK
 */
public class ObjectComparator {

    public static ArrayList compareListOfValues(ArrayList list){

    Collections.sort(list, new Comparator(){
            public int compare(Object o1, Object o2) {
                ListOfValuesVO listOfValuesVO1 = (ListOfValuesVO) o1;
                ListOfValuesVO listOfValuesVO2 = (ListOfValuesVO) o2;
               return listOfValuesVO1.getLabelName().compareToIgnoreCase(listOfValuesVO2.getLabelName());
              // return p1.getLastName().compareToIgnoreCase(p2.getLastName());
            }

        });

        for (Object obj : list){
        ListOfValuesVO listOfValuesVO = (ListOfValuesVO)obj;

        System.out.println( " Level Name : " + listOfValuesVO.getLabelName()  + " Level Value : " + listOfValuesVO.getLabelValue());

        }
        return list;
    }

    public static void main(String[] args){

        ListOfValuesVO  listOfValuesVO1 = new ListOfValuesVO();

        listOfValuesVO1.setLabelName("AZN");
        listOfValuesVO1.setLabelValue("Kolkata");

         ListOfValuesVO  listOfValuesVO2 = new ListOfValuesVO();
        listOfValuesVO2.setLabelName("BNG");
        listOfValuesVO2.setLabelValue("Dhaka");



        ArrayList list = new ArrayList();
        list.add(listOfValuesVO1);
        list.add(listOfValuesVO2);
     
        compareListOfValues(list);
    }
}

