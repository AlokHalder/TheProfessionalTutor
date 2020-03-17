/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcs.ptutors.vo;

/**
 *
 * @author ALOK
 */
public class TutorsInIndiaVO {
    private int locationId;
    private String locationName;
    private int tutorCount;

    
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
     * @return the tutorCount
     */
    public int getTutorCount() {
        return tutorCount;
    }

    /**
     * @param tutorCount the tutorCount to set
     */
    public void setTutorCount(int tutorCount) {
        this.tutorCount = tutorCount;
    }

    /**
     * @return the locationId
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    
    
}
