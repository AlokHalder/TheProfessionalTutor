/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcs.ptutors.vo;

/**
 *
 * @author RitZ26
 */
public class TutorialCenterVo {

    private int locationId;
    private String locationName;
    private int tutorialCenterCount;

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
     * @return the tutorialCenterCount
     */
    public int getTutorialCenterCount() {
        return tutorialCenterCount;
    }

    /**
     * @param tutorialCenterCount the tutorialCenterCount to set
     */
    public void setTutorialCenterCount(int tutorialCenterCount) {
        this.tutorialCenterCount = tutorialCenterCount;
    }
}
