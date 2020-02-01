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
public class TutorPgEducationalQualificationVO implements Serializable{
    private String tutorId;
    private String qualifyingDegree;
    private String specialization;
    private String universityInstitute;
    private String yearOfPassout;
    


    /**
     * @return the tutorId
     */
    public String getTutorId() {
        return tutorId;
    }

    /**
     * @param tutorId the tutorId to set
     */
    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    /**
     * @return the qualifyingDegree
     */
    public String getQualifyingDegree() {
        return qualifyingDegree;
    }

    /**
     * @param qualifyingDegree the qualifyingDegree to set
     */
    public void setQualifyingDegree(String qualifyingDegree) {
        this.qualifyingDegree = qualifyingDegree;
    }

    /**
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    

    /**
     * @return the yearOfPassout
     */
    public String getYearOfPassout() {
        return yearOfPassout;
    }

    /**
     * @param yearOfPassout the yearOfPassout to set
     */
    public void setYearOfPassout(String yearOfPassout) {
        this.yearOfPassout = yearOfPassout;
    }

    /**
     * @return the universityInstitute
     */
    public String getUniversityInstitute() {
        return universityInstitute;
    }

    /**
     * @param universityInstitute the universityInstitute to set
     */
    public void setUniversityInstitute(String universityInstitute) {
        this.universityInstitute = universityInstitute;
    }



}
