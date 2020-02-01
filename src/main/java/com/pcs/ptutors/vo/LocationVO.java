/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.vo;
import java.util.List;
/**
 *
 * @author ibm
 */
public class LocationVO implements java.io.Serializable{
  private String countryCode;
  private String cityCode;
  private String countryName;
  private String cityName ;
  private List<String> cityListOfCountry;



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
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * @return the cityListOfCountry
     */
    public List<String> getCityListOfCountry() {
        return cityListOfCountry;
    }

    /**
     * @param cityListOfCountry the cityListOfCountry to set
     */
    public void setCityListOfCountry(List<String> cityListOfCountry) {
        this.cityListOfCountry = cityListOfCountry;
    }

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
     * @return the cityCode
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode the cityCode to set
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
  
    

}
