/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.test;

import com.pcs.ptutors.model.TutorModel;
import com.pcs.ptutors.vo.LocationVO;
import com.pcs.ptutors.vo.ResultVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ibm
 */
public class TestCreateLocation {

    public static void main(String[] args){

        List<LocationVO> listOfLocation = new ArrayList<LocationVO>();

         LocationVO  locationVO = new LocationVO();
         locationVO.setCountryName("India");
         locationVO.setCityName("Digha");
         
          listOfLocation.add(locationVO);
/*
         LocationVO  locationVO2 = new LocationVO();
         locationVO2.setCountryName("India");
         locationVO2.setCityLocation("Kolkata");

         listOfLocation.add(locationVO2);
 * 
 */

         TutorModel tutorModel = new TutorModel();
         ResultVO resultVO = tutorModel.createLocation(listOfLocation);
         System.out.print("Validation Message ::"+ resultVO.getValidationMessage());


    }

}
