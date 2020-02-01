/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.util;


class Person {
    private String firstName;
    private String lastName;

    public Person(){
    }
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return Returns the firstName.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName The firstName to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return Returns the lastName.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName The lastName to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
    public String toString(){
       // return "## Firstname : "+this.firstName+", Lastname : "+this.lastName;
        return this.lastName;
    }*/

}