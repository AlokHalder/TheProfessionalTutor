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
public class CountryVO implements Serializable {
    private String countryCode;
    private String countryName;
    private String shortName;
    private String nationalFlag;
    private String locationName;
    private String locationId;


    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

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
     * @return the shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName the shortName to set
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * @return the nationalFlag
     */
    public String getNationalFlag() {
        return nationalFlag;
    }

    /**
     * @param nationalFlag the nationalFlag to set
     */
    public void setNationalFlag(String nationalFlag) {
        this.nationalFlag = nationalFlag;
    }

    /**
     * @return the locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * @param locationName the locationName to set
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * @return the locationId
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    
}
