package com.spring65.phone.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring65.phone.model.ModelPhone;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PhoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
    @RequestMapping(value = "/phone/writeone", method = RequestMethod.GET)
    public String writeone(Model model) {
        logger.info("writeone");
        
        return "phone/writeOneForm";
    }
    
    @RequestMapping(value = "/phone/writeone1", method = RequestMethod.POST)
    public String writeone1(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        String manufacturer = request.getParameter("manufacturer");
        String temp = request.getParameter("price");
        Integer price;
        if (temp.isEmpty()) {
            price = 0;
        }
        else {
            price = Integer.valueOf(request.getParameter("price"));
        }
        
        ModelPhone phone = new ModelPhone(name, manufacturer, price);
        
        model.addAttribute("phone", phone);
        
        return "phone/writeOneResult";
    }
    
    @RequestMapping(value = "/phone/writeone2", method = RequestMethod.POST)
    public String writeone2(Model model, @RequestParam(defaultValue="") String name, @RequestParam(defaultValue="") String manufacturer, @RequestParam(defaultValue="") Integer price) {
        
        ModelPhone phone = new ModelPhone(name, manufacturer, price);
        
        model.addAttribute("phone", phone);
        
        return "phone/writeOneResult";
    }
    
    @RequestMapping(value = "/phone/writeone3", method = RequestMethod.POST)
    public String writeone3(Model model, @ModelAttribute ModelPhone phone) {
        
        model.addAttribute("phone", phone);
        
        return "phone/writeOneResult";
    }
    
    @RequestMapping(value = "/phone/writeone4", method = RequestMethod.POST)
    public String writeone4(Model model, @ModelAttribute ModelPhone phone) {
        
        model.addAttribute("phone", phone);
        
        return "phone/writeOneResult";
    }
    
}
