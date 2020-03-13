
<%@page import="com.pcs.ptutors.model.EducationalCategories"%>
<%@page import="com.pcs.ptutors.model.TutorModel"%>
<%@page import="java.util.*"%>
<div id="leftSectionWrapper">
    <div class="categoryWrapper">
        <div class="categoryTop">Tutor Categories</div>
         <div class="categoryBody">
<%

    TutorModel tutorModel = new TutorModel();
    String msg="ok";
    ArrayList<EducationalCategories> al=tutorModel.checkEducationCategories();
    Iterator itr=al.iterator();
    out.println("<ul>");
    while(itr.hasNext()){
        EducationalCategories e=(EducationalCategories)itr.next();
      
        
        out.println("<li><a href=findYourTutor.do?tutorCategories="+e.getEducation_segment_id()+">"+e.getEducation_segment_name()+"</a></li>");
       
      
    }
    out.println("</ul>");

%>
         </div>
           <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" /></div>
    </div>
</div>

