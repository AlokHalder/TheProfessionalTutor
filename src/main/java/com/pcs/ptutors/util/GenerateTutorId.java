/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcs.ptutors.util;

import com.pcs.ptutors.model.DbConnectionPool;

/**
 *
 * @author ALOK
 */
public class GenerateTutorId {

    public static String generateTutorId() {
        String tutorId=null;
        try {
            DbConnectionPool.dbConnectOne();
            
            
        } catch (Exception exception) {
        }
        return tutorId;
    }
    
    public static void main(String[] args) {
        generateTutorId();
    }
}
