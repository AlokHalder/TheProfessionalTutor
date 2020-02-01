
package com.pcs.ptutors.vo;

import com.pcs.ptutors.tutorialcenter.vo.TutorialCenterDataVO;
import com.pcs.ptutors.vo.StudentRegistrationVO;
import com.pcs.ptutors.vo.TutorRegistrationVO;
import java.util.List;

/**
 *
 * @author CHANDAN
 */
public class SearchResultVO {
    private List<StudentRegistrationVO>listOfSearchedStudent;
    
     private List<TutorRegistrationVO> listOfSearchedTutors;
    
    private List<TutorRegistrationVO> listOfSearchedTutoringJobs;
    
    private List<TutorRegistrationVO> listOfSearchedOnlineTutors;
    
    private List<TutorialCenterDataVO> listofsearchedTutorial;

    /**
     * @return the listOfSearchedStudent
     */
    public List<StudentRegistrationVO> getListOfSearchedStudent() {
        return listOfSearchedStudent;
    }

    /**
     * @param listOfSearchedStudent the listOfSearchedStudent to set
     */
    public void setListOfSearchedStudent(List<StudentRegistrationVO> listOfSearchedStudent) {
        this.listOfSearchedStudent = listOfSearchedStudent;
    }

    /**
     * @return the listOfSearchedTutors
     */
    public List<TutorRegistrationVO> getListOfSearchedTutors() {
        return listOfSearchedTutors;
    }

    /**
     * @param listOfSearchedTutors the listOfSearchedTutors to set
     */
    public void setListOfSearchedTutors(List<TutorRegistrationVO> listOfSearchedTutors) {
        this.listOfSearchedTutors = listOfSearchedTutors;
    }

    /**
     * @return the listOfSearchedTutoringJobs
     */
    public List<TutorRegistrationVO> getListOfSearchedTutoringJobs() {
        return listOfSearchedTutoringJobs;
    }

    /**
     * @param listOfSearchedTutoringJobs the listOfSearchedTutoringJobs to set
     */
    public void setListOfSearchedTutoringJobs(List<TutorRegistrationVO> listOfSearchedTutoringJobs) {
        this.listOfSearchedTutoringJobs = listOfSearchedTutoringJobs;
    }

    /**
     * @return the listOfSearchedOnlineTutors
     */
    public List<TutorRegistrationVO> getListOfSearchedOnlineTutors() {
        return listOfSearchedOnlineTutors;
    }

    /**
     * @param listOfSearchedOnlineTutors the listOfSearchedOnlineTutors to set
     */
    public void setListOfSearchedOnlineTutors(List<TutorRegistrationVO> listOfSearchedOnlineTutors) {
        this.listOfSearchedOnlineTutors = listOfSearchedOnlineTutors;
    }

    /**
     * @return the listofsearchedTutorial
     */
    public List<TutorialCenterDataVO> getListofsearchedTutorial() {
        return listofsearchedTutorial;
    }

    /**
     * @param listofsearchedTutorial the listofsearchedTutorial to set
     */
    public void setListofsearchedTutorial(List<TutorialCenterDataVO> listofsearchedTutorial) {
        this.listofsearchedTutorial = listofsearchedTutorial;
    }
}
