package com.pcs.ptutors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcs.ptutors.model.Contact;

@Controller
public class TutorsController {
	
	@RequestMapping("/")  
    public String helloWorld() {     
        return "index";   
    }  
	
	@RequestMapping("/hello")  
    public String helloWorld(Model m) {  
        String message = "Hello World, Spring MVC @ Javatpoint";  
        m.addAttribute("message", message);  
        return "helloGovind";   
    }  
	


	
	
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)  
    public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {  
        //write the code here to add contact  
        return "redirect:/";  
    }  
      
    @RequestMapping("/contact")  
    public String showContacts(Model m) {  
        m.addAttribute("command", new Contact());  
        return "contact";  
    }  
}
