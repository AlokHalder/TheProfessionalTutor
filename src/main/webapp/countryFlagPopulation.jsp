
<%--
<%

                            List<CountryVO> listOfCountryNationalFlag = null;
                            if(null != session.getAttribute("listOfCountryNationalFlag")){
                                  listOfCountryNationalFlag = (List<CountryVO>)session.getAttribute("listOfCountryNationalFlag");
                                }else{
                                  listOfCountryNationalFlag = lovDataServiceTeaser.populateCountryNationalFlagList();
                                  session.setAttribute("listOfCountryNationalFlag",listOfCountryNationalFlag);
                                }

                            for (CountryVO countryVO : listOfCountryNationalFlag) {
                                if (null != countryVO.getNationalFlag() && !"".equalsIgnoreCase(countryVO.getNationalFlag())) {
                %>

                <a href="<%=countryVO.getCountryName()%>"><img src="NationalFlagIcons/<%=countryVO.getNationalFlag()%>.png" alt="" border="0" style="padding-left: 5px; padding-right: 5px" title="<%=countryVO.getCountryName()%>" ></a>
                    <%}
                                }%>
--%>