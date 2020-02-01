/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.test;

import com.pcs.ptutors.model.TutorModel;
import com.pcs.ptutors.vo.LocationVO;
import java.util.List;

/**
 *
 * @author ibm
 */
public class TestPopulateLocation {
    public static void main(String[] args){
        TutorModel tutorModel = new TutorModel();
        List<LocationVO> listOfLocation = tutorModel.populateLocation();
        for(LocationVO locationVO:listOfLocation){
            System.out.println("<------------------------------------------->");
            System.out.println(" Country Name :" + locationVO.getCountryName());
            System.out.println("City Name : " + locationVO.getCityName());

        }
    }

}
