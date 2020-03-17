package com.pcs.ptutors.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import com.pcs.ptutors.model.TutorRegistration;
import org.apache.struts.action.ActionForward;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pcs.ptutors.exception.ProfessionalTutorsException;
import com.pcs.ptutors.model.AllSearchResultAction;
import com.pcs.ptutors.model.Contact;
import com.pcs.ptutors.model.HomeWorkHelp;
import com.pcs.ptutors.model.Mambersubscription;
import com.pcs.ptutors.model.MemberShipPaymentModel;

import com.pcs.ptutors.model.TutorMembershipSubscription;
import com.pcs.ptutors.model.TutorModel;
import com.pcs.ptutors.model.studentRegistration;
import com.pcs.ptutors.model.studentUpgardeMamber;
import com.pcs.ptutors.model.tutorProfileRegistration;
import com.pcs.ptutors.form.TutorEduAndTeachingProcRegistrationActionForm;
import com.pcs.ptutors.form.TutorProfileRegistrationActionForm;
import com.pcs.ptutors.form.TutorTutoringProcedureActionForm;
import com.pcs.ptutors.vo.ResultVO;
import com.pcs.ptutors.vo.SearchVOO;
import com.pcs.ptutors.vo.StudentRegistrationVO;
import com.pcs.ptutors.vo.TutorRegistrationVO;
import com.pcs.ptutors.vo.HomeWorkHelpVO;
import com.pcs.ptutors.vo.InstantTutorServiceVO;
import com.pcs.ptutors.vo.MembershipSubscriptionVO;
import com.pcs.ptutors.model.PostTutionRequirement;
import com.pcs.ptutors.model.SearchVO;
@Controller
public class TutorsController {
	
	@RequestMapping("/")  
    public String helloWorld() {     
        return "index";   
    } 
	
	
	// done by manjuri and shinjan
	@RequestMapping("/searchTutorbyid")
	public String search(Model m) {
		m.addAttribute("command", new TutorRegistrationVO());
		return "tutorProfileById";
	}

	@RequestMapping(value = "/searchTutorProfilebyid", method = RequestMethod.GET)
	public ModelAndView populateTutorProfileByTutorId(@RequestParam("tutorId") String tutorId)
			throws ProfessionalTutorsException, Exception {
		ModelAndView mv = new ModelAndView();
		TutorModel tutorModel = new TutorModel();
		TutorRegistrationVO tutorRegistrationVO = tutorModel.populateTutorProfileByTutorId(tutorId);
		mv.addObject("tutorProfile", tutorRegistrationVO);
		mv.setViewName("data");

		return mv;
	}
	
	@RequestMapping("/searchTutor")
	public ModelAndView search(ModelAndView mv) {
		mv.addObject("command", new tutorProfileRegistration());
		mv.setViewName("totalTutorProfile");
		return mv;
	}
	
	

	@RequestMapping(value = "/totalTutorProfilebyid", method = RequestMethod.GET)
	public ModelAndView totalTutorprofile(@ModelAttribute("totalTutorprofile") tutorProfileRegistration tutorregistration)
			throws ProfessionalTutorsException, Exception {
		ModelAndView mv = new ModelAndView();
		TutorModel tutorModel = new TutorModel();
		LoginVO loginvo = new LoginVO();
		loginvo.setTutorId(tutorregistration.getTutorId());
		loginvo.setTutorNameOrEmailAddress(tutorregistration.getTutorEmailId());
		loginvo.setTutorPassword(tutorregistration.getTutorPassword());
		TutorRegistrationVO tutorRegistrationVO = tutorModel.populateTutorFullProfile(loginvo);
		mv.addObject("tutorProfile", tutorRegistrationVO);
		mv.setViewName("data");

		return mv;
	}
	
	
	
	
	@RequestMapping("/in")  
    public String helloWorldw() {     
        return "indexw";   
    } 
	
	@RequestMapping("/hellos")  
    public String helloWorlds() {     
        return "indexs";   
    }
	
	
	@RequestMapping("/hellosande")  
    public String helloWorldsg() {     
        return "indexsande";   
    }
	@RequestMapping(value = "/postTutionRequirement",method = RequestMethod.POST)  
	public String postRequirement(@ModelAttribute("posttutionrequirement") PostTutionRequirement posttutionrequirement,BindingResult result) {
		
		TutorModel tutormodel=new TutorModel();
		InstantTutorServiceVO instantTutorServiceVO = new InstantTutorServiceVO();
		instantTutorServiceVO.setTutionTitle(posttutionrequirement.getTutionTitle());
		instantTutorServiceVO.setAreaName(posttutionrequirement.getAreaName());
		instantTutorServiceVO.setClassStandard(posttutionrequirement.getClassStandard());
		instantTutorServiceVO.setContactNumber(posttutionrequirement.getContactNumber());
		instantTutorServiceVO.setContactPerson(posttutionrequirement.getContactPerson());
		instantTutorServiceVO.setCountryCode(posttutionrequirement.getCountryCode());
		instantTutorServiceVO.setEmailAddesss(posttutionrequirement.getEmailAddesss());
		instantTutorServiceVO.setLocationId(posttutionrequirement.getLocationId());
		instantTutorServiceVO.setSubjectTitle(posttutionrequirement.getSubjectTitle());
		
		ResultVO resultvo= tutormodel.postTutionService(instantTutorServiceVO);
		
		return "redirect:/helloPostsuccess";
		
	}
	
	@RequestMapping("/requirement")  
    public String helloPriya(Model m) {  
         
        m.addAttribute("command", new PostTutionRequirement());  
        return "helloPost";   
	}
	
	@RequestMapping("/helloPostsuccess")  
    public String helloPriyaa() {   
        return "helloPostt";   
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)  
	public String user() {
		  return "redirect:/";
		
	}
	@RequestMapping("/registration")  
    public String helloPriyaaa() {  
        return "helloUser";   
	}
	
	@RequestMapping(value = "/posthomework",method = RequestMethod.POST)  
	public String postHomeWork(@ModelAttribute("homework") HomeWorkHelp homework ,BindingResult result) {
		  return "redirect:/";
		
	}
	
	@RequestMapping(value = "/home")  
	public String homeWork(Model m) {
		
		 m.addAttribute("command", new HomeWorkHelp());  
		return "helloHome";
		
	}
	

	@RequestMapping(value ="/check_avails") 
	@ResponseBody
	public String checkAvailabilitys(@RequestParam String username) {
		
		
		TutorModel tutormodel=new TutorModel();
		
		 boolean availabilityFlag=tutormodel.checkStudentUserAvailability(username);
		 System.out.println("check availability method is called");
		 if (availabilityFlag) {
			 return "Available";
		    } else {
		      return "Not Available";
		    }
		 }
	
	
	
	
	
	@RequestMapping(value = "/check_avail") 
	@ResponseBody
	public String checkAvailability(@RequestParam String username) {
		
		
		TutorModel tutormodel=new TutorModel();
		
		 boolean availabilityFlag=tutormodel.checkTutorUserAvailability(username);
		 System.out.println("check availability method is called");
		 if (availabilityFlag) {
			 return "Available";
		    } else {
		      return "Not Available";
		    }
		 
		
	}
	@RequestMapping(value = "/addregister", method = RequestMethod.POST)  
    public String addtt(@ModelAttribute("ress") tutorProfileRegistration TutorProfileRegistartion, BindingResult result) {  
        //write the code here to add contact 
		TutorModel tutormodel=new TutorModel();
		TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();
		tutorRegistrationVO.setTutorLoginName(TutorProfileRegistartion.getTutorLoginName());
		tutorRegistrationVO.setTutorPassword(TutorProfileRegistartion.getTutorPassword());
		tutorRegistrationVO.setTutorSecretQuestionAnswer(TutorProfileRegistartion.getTutorSecretQuestionAnswer());
		tutorRegistrationVO.setTutorEmailId(TutorProfileRegistartion.getTutorEmailId());
		tutorRegistrationVO.setContactNumber(TutorProfileRegistartion.getTutorContactNumber());
		tutorRegistrationVO.setTutorAge(TutorProfileRegistartion.getTutorAge());
		tutorRegistrationVO.setTutorAddress(TutorProfileRegistartion.getTutorAddress());
		tutorRegistrationVO.setTutorCountryLocation(TutorProfileRegistartion.getTutorCountryLocation());
		tutorRegistrationVO.setTutorArea(TutorProfileRegistartion.getTutorArea());
		tutorRegistrationVO.setTutorSecretQuestion(TutorProfileRegistartion.getTutorSecretQuestion());
		
		try {
			ResultVO resultVO=tutormodel.tutorProfileRegistration(tutorRegistrationVO);
		} catch (ProfessionalTutorsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
		 
		return "redirect:EduAndTeaching";
	}
	@RequestMapping("/edy")  
    public String helloWorldss() {     
        return "indexss";   
    }
		
	/*
	 * Map<String,String> map= new HashMap();
	 * map.put("tutorLoginName",TutorProfileRegistartion.getTutorLoginName());
	 * map.put("tutorPassword",TutorProfileRegistartion.getTutorPassword());
	 * map.put("tutorSecretQuestion",TutorProfileRegistartion.getTutorSecretQuestion
	 * ()); map.put("tutorSecretQuestionAnswer",TutorProfileRegistartion.
	 * getTutorSecretQuestionAnswer());
	 * map.put("tutorAge",TutorProfileRegistartion.getTutorAge());
	 * map.put("tutorSex",TutorProfileRegistartion.getTutorSex());
	 * map.put("tutorAddress",TutorProfileRegistartion.getTutorAddress());
	 * map.put("tutorCountryLocation",TutorProfileRegistartion.
	 * getTutorCountryLocation());
	 * map.put("tutorCityLocation",TutorProfileRegistartion.getTutorCityLocation());
	 * map.put("tutorCityLocationId",TutorProfileRegistartion.getTutorCityLocationId
	 * ());
	 * map.put("tutorPostalCode",TutorProfileRegistartion.getTutorPostalCode());
	 * map.put("tutorArea",TutorProfileRegistartion.getTutorArea());
	 * map.put("tutorEmailId",TutorProfileRegistartion.getTutorEmailId());
	 * map.put("tutorContactNumber",TutorProfileRegistartion.getTutorContactNumber()
	 * ); for (Map.Entry<String, String> entry : map.entrySet()) { String k =
	 * entry.getKey(); String v = entry.getValue(); System.out.println( k + " -> " +
	 * v); } return "redirect:/"; }
	 */
      
	
	@RequestMapping("/hello")  
    public String helloWorld(Model m) {  
         
        m.addAttribute("command", new tutorProfileRegistration());  
        return "helloGovind";   
    } 
	
	
 
	@RequestMapping(value = "/studentregister", method = RequestMethod.POST)  
	
	public ModelAndView studentRegister(@ModelAttribute("studentRegistration") studentRegistration StudentRegistration,BindingResult result,HttpServletResponse response , HttpServletRequest request)throws IOException { 
	   
		/*
		 * if(result.hasErrors()) { //attr.addFlashAttribute( //
		 * "org.springframework.validation.BindingResult.tutorregistration", result); //
		 * attr.addFlashAttribute("tutorregistration", tutorregistration);
		 * //logger.debug("=====has errors messages");
		 * //logger.info("Add Contact is Being Executing"); ModelAndView mv = new
		 * ModelAndView("redirect:hello1"); mv.addObject(StudentRegistration);
		 * 
		 * return mv;
		 * 
		 * } else {
		 */
			 
		 try {
		TutorModel tutormodel=new TutorModel();
		StudentRegistrationVO studentRegistrationVO=new StudentRegistrationVO();
		studentRegistrationVO.setEmail(StudentRegistration.getEmail());
		studentRegistrationVO.setUserLoginName(StudentRegistration.getUserLoginName());
		
		
		
		studentRegistrationVO.setPassword(StudentRegistration.getPassword());
		studentRegistrationVO.setSecretQuestion(StudentRegistration.getSecretQuestion());
		studentRegistrationVO.setSecretQuestionAnswer(StudentRegistration.getSecretQuestionAnswer());
		 
		studentRegistrationVO.setName(StudentRegistration.getName());
		studentRegistrationVO.setGuardianname(StudentRegistration.getGuardianname());
		studentRegistrationVO.setSchoolOrBoard(StudentRegistration.getSchoolOrBoard());
		 
		studentRegistrationVO.setOtherSchoolOrBoard(StudentRegistration.getOtherSchoolOrBoard());
		studentRegistrationVO.setOtherUniversityOrInstitute(StudentRegistration.getOtherUniversityOrInstitute());
		studentRegistrationVO.setUniversityOrInstitute(StudentRegistration.getUniversityOrInstitute());
		 
		studentRegistrationVO.setClassstandard(StudentRegistration.getClassstandard());
	 
		studentRegistrationVO.setOtherClassstandard(StudentRegistration.getOtherClassstandard());
		studentRegistrationVO.setMedium(StudentRegistration.getMedium());
	 
		studentRegistrationVO.setOtherMedium(StudentRegistration.getOtherMedium());
 
		studentRegistrationVO.setOtherSubject(StudentRegistration.getOtherSubject());
		studentRegistrationVO.setAddress(StudentRegistration.getAddress());
		studentRegistrationVO.setAddress2(StudentRegistration.getAddress2());
		studentRegistrationVO.setCountryName(StudentRegistration.getCountryName());
		studentRegistrationVO.setCityName(StudentRegistration.getCityName());
		studentRegistrationVO.setArea(StudentRegistration.getArea());
		studentRegistrationVO.setLandmark(StudentRegistration.getAddress2());
		studentRegistrationVO.setAge(StudentRegistration.getAge());

			 ResultVO resultVO=tutormodel.studentRegistration(studentRegistrationVO);
			
		 }catch (ProfessionalTutorsException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView ("redirect:studentmamberf");
	
		 }
	
		
	
	@RequestMapping("/hello1")  
    public String helloWorld3(Model m)
	{  
         
        m.addAttribute("command", new studentRegistration());  
        return "helloPriya";   
    } 
	
    @RequestMapping(value = "/studentmamberf", method = RequestMethod.POST)  
	
	public String studentRegister(@ModelAttribute("studentmem") Mambersubscription Mambersubscriptions,BindingResult result) { 
	   
    	MemberShipPaymentModel tutormodel=new MemberShipPaymentModel();
		MembershipSubscriptionVO membershipSubscriptionVO=new MembershipSubscriptionVO();
		
		membershipSubscriptionVO.setUserLoginName(Mambersubscriptions.getUserLoginName());
		membershipSubscriptionVO.setPassword(Mambersubscriptions.getPassword());
		membershipSubscriptionVO.setEmailAddress(Mambersubscriptions.getEmailAddress());
		membershipSubscriptionVO.setMembershipCategory(Mambersubscriptions.getMembershipCategory());
		membershipSubscriptionVO.setDuration(Mambersubscriptions.getDuration());
		 
		membershipSubscriptionVO.setPaymentAmount(Mambersubscriptions.getPaymentAmount());
		membershipSubscriptionVO.setMembershipBegindate(Mambersubscriptions.getMembershipBegindate());
		membershipSubscriptionVO.setMembershipExpiredate(Mambersubscriptions.getMembershipExpireWarningDate());
		 
		try {
			ResultVO resultVO=tutormodel.studentMembershipPayment(membershipSubscriptionVO);
		} catch (ProfessionalTutorsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:hello4";
		
	}
	
	@RequestMapping("/studentmamberf")  
    public String helloWorld11(Model m) {  
         
        m.addAttribute("command", new Mambersubscription());  
        return "helloStudentmamber";   
    } 
	
	@RequestMapping("/hello4")  
    public String helloWorldsa(Model m) {  
         
        m.addAttribute("command", new studentUpgardeMamber());  
        return "helloPriyas";   
    } 
	
	@RequestMapping("/hello5")  
    public String helloWorldsaa(Model m) {  
         
        m.addAttribute("command", new studentUpgardeMamber());  
        return "helloPriyas";   
    } 
	
	
	
	 @RequestMapping(value = "/allsearchresult", method = RequestMethod.POST)  
		
		public String studentRegistersw(@ModelAttribute("modelsearchh") SearchVO searchmain,BindingResult result) { 
		   
		 AllSearchResultAction tutormodel=new AllSearchResultAction();
		 
		 
		SearchVOO searchheadervo = new SearchVOO();
		searchheadervo.setSearchoptions(searchmain.getSearchoptions());
		System.out.println(searchmain.getSearchoptions());
		
		
			return"redirect:/";
	 }

	 @RequestMapping("/searchmodelser")  
	    public String sandeepwa() 
	 {   
	        return "modelwaswearch";   
		}
	 
	 @RequestMapping("/helloPostsuccesss")  
	    public String helloPriyaaas() 
	 {   
	        return "helloPostt";   
		}
	 
	 @RequestMapping(value = "/tutorTutoringProcedure", method =RequestMethod.POST) 
	  public String tutorTutoringProcedure(@ModelAttribute("tutoringProcedure") TutorRegistration tutorTutoringProcedureActionForm,BindingResult result) { 
		 TutorModel tutorModel = new TutorModel(); 
		 TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();
	  tutorRegistrationVO.setFeeExpected(tutorTutoringProcedureActionForm.getFeeExpected());
	  tutorRegistrationVO.setPreferenceToTeaching(tutorTutoringProcedureActionForm.getPreferenceToTeaching());
	  tutorRegistrationVO.setOtherTeachingMedium(tutorTutoringProcedureActionForm.
	  getOtherTeachingMedium());
	  tutorRegistrationVO.setPreferenceToTeaching(tutorTutoringProcedureActionForm.
	  getPreferenceToTeaching());
	  tutorRegistrationVO.setTutoringExperience(tutorTutoringProcedureActionForm.
	  getTutoringExperience());
	  tutorRegistrationVO.setMainsubject(tutorTutoringProcedureActionForm.
	  getMainsubject()); tutorRegistrationVO.setTutorYearsOfExperience(
	  tutorTutoringProcedureActionForm.getTutorYearsOfExperience());
	  tutorRegistrationVO.setTutorMonthsOfExperience(
	  tutorTutoringProcedureActionForm.getTutorMonthsOfExperience());
	  tutorRegistrationVO.setTutorYearsOfExperience(
	  tutorTutoringProcedureActionForm.getTutorYearsOfExperience());
	  
	  try { 
		  ResultVO resultVO=tutorModel.registerTutorTutoringProcedure(tutorRegistrationVO); 
		  }
	  catch (ProfessionalTutorsException e) { 
		  // TODO Auto-generated catch block
	  e.printStackTrace(); 
	  } catch (Exception e) { 
		  // TODO Auto-generated catch
	   e.printStackTrace();
	  
	  }
	  
	  return "redirect:/tutormembership";
	  
	  }
	/*
	 * @RequestMapping("tutormembership") public String helloWorld1() { return
	 * "index1"; }
	 */
	  	
	 
	  @RequestMapping("/tutorprocedure") 
	  public String helloWorld1(Model m) {
	  
	  m.addAttribute("command", new TutorTutoringProcedureActionForm()); 
	  return "helloPrivi"; 
	  }
	  
	  @RequestMapping("/EduAndTeaching") 
	  public String EduAndTeachingProcedure(Model m) {
		  m.addAttribute("command", new TutorEduAndTeachingProcRegistrationActionForm());
		return "eduandteaching";
		  
	  }
	  
	/*
	 * @PostMapping("/confirmTutorMemberShip") public String
	 * tutorMembership(BindingResult result) { return
	 * "redirect:cmplttutorregistration";
	 * 
	 * }
	 */
	  
	  
	  @PostMapping("/tutorEduAndTeachingProcRegistration") 
	  public String tutorEduAndTeachingProcRegistration(@ModelAttribute("eduAndTeachingProcedureRegn") TutorEduAndTeachingProcRegistrationActionForm tutorEduAndTeachingProcRegistrationActionForm,BindingResult result,RedirectAttributes redirectAttributes) {
	  ModelAndView m = new ModelAndView();
	  
	  TutorModel tm = new TutorModel();
	  
	  System.out.println("start....action tutorEduAndTeachingProcRegistration");
	  
	  //String tutorId = (String) request.getSession().getAttribute("tutorId");
	  TutorModel tutorModel = new TutorModel(); TutorRegistrationVO
	  tutorRegistrationVO = new TutorRegistrationVO();
	  
	  tutorRegistrationVO.setOtherUgQualifyingDegree(tutorEduAndTeachingProcRegistrationActionForm.getOtherUgQualifyingDegree()); 
	  tutorRegistrationVO.setUgQualifyingDegree(tutorEduAndTeachingProcRegistrationActionForm.getUgQualifyingDegree());
	  
	  tutorRegistrationVO.setUgSpecialization(tutorEduAndTeachingProcRegistrationActionForm.getUgSpecialization());
	  tutorRegistrationVO.setOtherUgSpecialization(tutorEduAndTeachingProcRegistrationActionForm.getOtherUgSpecialization());
	  
	  tutorRegistrationVO
	  .setUgBoardOrUniversity(tutorEduAndTeachingProcRegistrationActionForm.
	  getUgBoardOrUniversity()); tutorRegistrationVO.setOtherUgBoardOrUniversity(
	  tutorEduAndTeachingProcRegistrationActionForm.getOtherUgBoardOrUniversity());
	  
	  tutorRegistrationVO.setUgPassoutYear(
	  tutorEduAndTeachingProcRegistrationActionForm.getUgPassoutYear());
	  System.out.println("uuuuuuuuuuuuggggggg  year of pass==" +
	  tutorEduAndTeachingProcRegistrationActionForm.getUgPassoutYear());
	  tutorRegistrationVO
	  .setPgQualifyingDegree(tutorEduAndTeachingProcRegistrationActionForm.
	  getPgQualifyingDegree()); tutorRegistrationVO
	  .setOtherPgQualifyingDegree(tutorEduAndTeachingProcRegistrationActionForm.
	  getOtherPgQualifyingDegree());
	  
	  tutorRegistrationVO.setPgSpecialization(
	  tutorEduAndTeachingProcRegistrationActionForm.getPgSpecialization());
	  tutorRegistrationVO
	  .setOtherPgSpecialization(tutorEduAndTeachingProcRegistrationActionForm.
	  getOtherPgSpecialization());
	  
	  tutorRegistrationVO
	  .setPgBoardOrUniversity(tutorEduAndTeachingProcRegistrationActionForm.
	  getPgBoardOrUniversity()); tutorRegistrationVO.setOtherPgBoardOrUniversity(
	  tutorEduAndTeachingProcRegistrationActionForm.getOtherPgBoardOrUniversity());
	  tutorRegistrationVO.setPgPassoutYear("1995");
	  
	  tutorRegistrationVO.setTeachingLevelList(
	  tutorEduAndTeachingProcRegistrationActionForm.getTeachingLevelList());
	  tutorRegistrationVO.setTeachingSubjectList(
	  tutorEduAndTeachingProcRegistrationActionForm.getTeachingSubjects());
	  tutorRegistrationVO.setTeachingBoardList(
	  tutorEduAndTeachingProcRegistrationActionForm.getTeachingBoards());
	  tutorRegistrationVO.setTeachingMediumLis(
	  tutorEduAndTeachingProcRegistrationActionForm.getTeachingMediumList());
	  //tutorRegistrationVO.setTutorId(tutorId);
	  
	  try { ResultVO resultVO =
	  tutorModel.registerTutorEduAndTeachingProc(tutorRegistrationVO);
	  
	  
	  //request.setAttribute("tutorId", resultVO.getTutorId());
	  //request.setAttribute("validationMessage", resultVO.getValidationMessage());
	  //m.addObject("eduAndTeachingProcedureRegn", new TutorEduAndTeachingProcRegistrationActionForm());
	  //m.setViewName("eduAndTeachingProcedureRegn"); 
	   } 
	  catch(ProfessionalTutorsException pte) { 
		  pte.printStackTrace();
	  
	  //m.setViewName("error"); return "Priya";
	  
	  } catch (Exception exception) { exception.printStackTrace();
	  //m.setViewName("error"); 
	  //return "Priya"; }
	  }
	return "redirect:/tutorprocedure";
	  
	  }
	  
	  @RequestMapping(value = "/confirmTutorMemberShip", method =RequestMethod.POST) 
	  public String confirmTutormembership(@ModelAttribute("confirmtutormemberShip") TutorMembershipSubscription tutormembershipsubscription, BindingResult result,HttpServletRequest request) {
		  
		 // String tutorId = (String) request.getSession().setAttribute("tutorId", tutorId);
		  MemberShipPaymentModel msp= new MemberShipPaymentModel();
		  MembershipSubscriptionVO mspvo=new MembershipSubscriptionVO();
		  mspvo.setDuration(tutormembershipsubscription.getDuration());
		  mspvo.setPaymentMode(tutormembershipsubscription.getPaymentMode());
		  mspvo.setPaymentAmount(tutormembershipsubscription.getPaymentAmount());
		  
		  try {
			TutorRegistrationVO tutorregistrationvo=msp.tutorMembershipPayment(mspvo);
		} catch (ProfessionalTutorsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		return "redirect:cmpltregistration";
		  
	  }
	  
	  @RequestMapping("/tutormembership") 
	  public String helloWorld5(Model m) {
	  
	  m.addAttribute("command", new TutorMembershipSubscription()); 
	  return "helloPrivii"; 
	  }
	  
	  
	  @RequestMapping("/cmpltregistration") 
	  public String helloWorld6() {
	  
	  //m.addAttribute("command", new TutorMembershipSubscription()); 
	  return "helloTutor"; 
	  }
	  
	  
	/*
	 * 
	 * 
	 * 
	 * @RequestMapping(value = "/addContact", method = RequestMethod.POST) public
	 * String addContact(@ModelAttribute("contact") Contact contact, BindingResult
	 * result) { //write the code here to add contact return "redirect:/"; }
	 * 
	 * @RequestMapping("/contact") public String showContacts(Model m) {
	 * m.addAttribute("command", new Contact()); return "contact"; }
	 */
}
