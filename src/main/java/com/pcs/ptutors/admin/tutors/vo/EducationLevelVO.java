/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.admin.tutors.vo;
/**
 *
 * @author ibm
 */
public class EducationLevelVO implements java.io.Serializable{
    private String countryName;
    private String cityName;
    private String educationLevel;
    private String educationid;

    

    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * @return the educationLevel
     */
    public String getEducationLevel() {
        return educationLevel;
    }

    /**
     * @param educationLevel the educationLevel to set
     */
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    /**
     * @return the educationid
     */
    public String getEducationid() {
        return educationid;
    }

    /**
     * @param educationid the educationid to set
     */
    public void setEducationid(String educationid) {
        this.educationid = educationid;
    }
    


}
