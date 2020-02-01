/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ObjectSorting {

public static void main(String[] args){

        Person p = new Person("Bruce", "Willis");
        Person p1  = new Person("Tom", "Hanks");
        Person p2 = new Person("Nicolas","Cage");
        Person p3 = new Person("John","Travolta");
        Person p4 = new Person("Alok","Halder");

        ArrayList list = new ArrayList();
        list.add(p);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        Collections.sort(list, new Comparator(){
            public int compare(Object o1, Object o2) {
                Person p1 = (Person) o1;
                Person p2 = (Person) o2;
               return p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
              // return p1.getLastName().compareToIgnoreCase(p2.getLastName());
            }

        });

        for (Object obj : list){
        Person person = (Person)obj;

        System.out.println( " First Name : " + person.getFirstName()  + " Last Name : " + person.getLastName());

        }

       // System.out.println(list);


}

}
