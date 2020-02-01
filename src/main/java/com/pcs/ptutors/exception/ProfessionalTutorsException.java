/**
 * 
 */
package com.pcs.ptutors.exception;

import java.io.Serializable;

/**
 * @author 
 *
 */
public class ProfessionalTutorsException  extends Exception implements Serializable{

	
	
	private String professionalTutorsErrorCode = null;
        private String professionalTutorsErrorMessage =null;

	/**
	 * @param message
	 */
	public ProfessionalTutorsException(String professionalTutorsErrorCode, String professionalTutorsErrorMessage) {
		super(professionalTutorsErrorMessage);
		this.professionalTutorsErrorCode = professionalTutorsErrorCode;
                this.professionalTutorsErrorMessage = professionalTutorsErrorMessage;
	}

    /**
     * @return the professionalTutorsErrorCode
     */
    public String getProfessionalTutorsErrorCode() {
        return professionalTutorsErrorCode;
    }

    /**
     * @param professionalTutorsErrorCode the professionalTutorsErrorCode to set
     */
    public void setProfessionalTutorsErrorCode(String professionalTutorsErrorCode) {
        this.professionalTutorsErrorCode = professionalTutorsErrorCode;
    }

    /**
     * @return the professionalTutorsErrorMessage
     */
    public String getProfessionalTutorsErrorMessage() {
        return professionalTutorsErrorMessage;
    }

    /**
     * @param professionalTutorsErrorMessage the professionalTutorsErrorMessage to set
     */
    public void setProfessionalTutorsErrorMessage(String professionalTutorsErrorMessage) {
        this.professionalTutorsErrorMessage = professionalTutorsErrorMessage;
    }


	
}
