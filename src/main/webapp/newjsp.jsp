<div class="ourToutorWrapper">
    <div class="tutorHeader">Find Tutor based upon following criteria</div>
    <div class="tutorBoxBody">
        <html:form action="searchTutor">
            <div class="profileListingSearch">
                <div class="fieldSectionWrapper">
                    <div class="labelNameSearch"> Tutor Id :</div>
                    <div class="searchTextBox">
                        <html:text property="tutorId" style="width:120px; margin-left:10px;  border:1px solid #59a7f5; color:#666; font:13px/20px Arial, Helvetica, sans-serif;" />
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldSectionWrapper">
                    <div class="labelNameSearch">Tutor Location :</div>
                    <div class="searchTextBox">

                   <html:select property="tutorCityLocation" style="width:125px; border:1px solid #59a7f5; color:#666; font:13px/20px Arial, Helvetica, sans-serif; height:20px; margin:0 5px 0 10px;">
                        <html:option value="">-:Select Location :-</html:option>
                        <html:optionsCollection name="tutorRegistrationActionForm" property="listOfLocation" label="labelName" value="labelValue"/>
                        <html:option value="9997">Other</html:option>
                    </html:select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldSectionWrapper">
                    <div class="labelNameSearch">Subject</div>
                    <div class="searchTextBox">
                        <html:select  property="mainsubject" style="width:125px; border:1px solid #59a7f5; color:#666; font:13px/20px Arial, Helvetica, sans-serif; height:20px; margin:0 5px 0 10px;">
                            <html:option value="">-:Select Subject :-</html:option>
                            <html:optionsCollection name="tutorRegistrationActionForm" property="listOfSubjectSubCategory" label="labelName" value="labelValue"/>
                           <html:option value="9997">Other</html:option>
                        </html:select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldSectionWrapper">
                    <div class="labelNameSearch"> Tutor Level :</div>
                    <div class="searchTextBox">
                        <html:select  property="teachingLevel" style="width:125px; border:1px solid #59a7f5; color:#666; font:13px/20px Arial, Helvetica, sans-serif; height:20px; margin:0 5px 0 10px;">
                            <html:option value="">-:Select Level :-</html:option>
                             <html:optionsCollection name="tutorRegistrationActionForm" property="listOfEducationSegmentLevel" label="labelName" value="labelValue"/>
                            <html:option value="9997">Other</html:option>
                        </html:select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="searchButton">
                    <html:image src="images/search_button.jpg" alt="" />
                </div>

            </div>
        </html:form>
    </div>
</div>
