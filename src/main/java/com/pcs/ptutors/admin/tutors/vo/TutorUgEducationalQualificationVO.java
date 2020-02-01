/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.admin.tutors.vo;
import java.io.Serializable;

/**
 *
 * @author ibm
 */
public class TutorUgEducationalQualificationVO implements Serializable{
    private String tutorId;
    private String qualifyingDegree;
    private String specialization;
    private String schoolBoardUniversityInstitute;
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
     * @return the schoolBoardUniversityInstitute
     */
    public String getSchoolBoardUniversityInstitute() {
        return schoolBoardUniversityInstitute;
    }

    /**
     * @param schoolBoardUniversityInstitute the schoolBoardUniversityInstitute to set
     */
    public void setSchoolBoardUniversityInstitute(String schoolBoardUniversityInstitute) {
        this.schoolBoardUniversityInstitute = schoolBoardUniversityInstitute;
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



}
