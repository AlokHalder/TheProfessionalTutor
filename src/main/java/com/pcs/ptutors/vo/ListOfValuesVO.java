/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.vo;
import java.io.Serializable;



/**
 *
 * @author ibm
 */
public class ListOfValuesVO  implements Serializable {
   
    private String labelName;
    private String labelValue;
   

    /**
     * @return the labelName
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * @param labelName the labelName to set
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    /**
     * @return the labelValue
     */
    public String getLabelValue() {
        return labelValue;
    }

    /**
     * @param labelValue the labelValue to set
     */
    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }

    



}
