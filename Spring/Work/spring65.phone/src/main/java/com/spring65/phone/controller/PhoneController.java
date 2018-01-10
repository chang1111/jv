package com.spring65.phone.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring65.phone.inf.IServicePhone;
import com.spring65.phone.model.ModelPhone;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PhoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	@Autowired
	private IServicePhone service;
	
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
        
        service.insertPhone(phone);
        
        model.addAttribute("phone", phone);
        
        return "phone/writeOneResult";
    }
    
    @RequestMapping(value = "/phone/writeone2", method = RequestMethod.POST)
    public String writeone2(Model model, @RequestParam(defaultValue="") String name, @RequestParam(defaultValue="") String manufacturer, @RequestParam(defaultValue="0") Integer price) {
        
        ModelPhone phone = new ModelPhone(name, manufacturer, price);
        
        service.insertPhone(phone);
        
        model.addAttribute("phone", phone);
        
        return "phone/writeOneResult";
    }
    
    @RequestMapping(value = "/phone/writeone3", method = RequestMethod.POST)
    public String writeone3(Model model, @ModelAttribute ModelPhone phone) {
        
        service.insertPhone(phone);
        
        model.addAttribute("phone", phone);
        
        return "phone/writeOneResult";
    }
    
    @RequestMapping(value = "/phone/writeone4", method = RequestMethod.POST)
    public String writeone4(Model model) {
        
        return "phone/writeOneResult";
    }
    
    @RequestMapping(value = "/phone/writelist", method = RequestMethod.GET)
    public String writelist(Model model) {
        logger.info("writelist");
        
        return "phone/writeListForm";
    }

    @RequestMapping(value = "/phone/writelist", method = RequestMethod.POST)
    public String writelist(Model model, @ModelAttribute(value="phoneItems") RepositoryPhone phones) {
        logger.info("writelist");
        
        List<ModelPhone> list = phones.getPhoneItems();
        
        model.addAttribute("list", list);
        
        service.insertPhoneList(list);
        
        return "phone/writeListResult";
    }
    
    @RequestMapping(value = "/phone/test", method = RequestMethod.GET)
    public String test(Model model) {
        logger.info("test");
        
        List<ModelPhone> list = service.getPhoneList();
        
        model.addAttribute("list", list);
        
        return "phone/test";
    }

    @RequestMapping(value = "/phone/test1", method = RequestMethod.POST)
    public String test1(Model model, HttpServletRequest request) {
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
        
        service.insertPhone(phone);
        
        List<ModelPhone> list = service.getPhoneList();
        
        model.addAttribute("list", list);
        
        return "phone/test";
    }
    
    @RequestMapping(value = "/phone/test2", method = RequestMethod.POST)
    public String test2(Model model, @RequestParam(defaultValue="") String name, @RequestParam(defaultValue="") String manufacturer, @RequestParam(defaultValue="0") Integer price) {
        
        ModelPhone phone = new ModelPhone(name, manufacturer, price);
        
        service.insertPhone(phone);
        
        List<ModelPhone> list = service.getPhoneList();
        
        model.addAttribute("list", list);
        
        return "phone/test";
    }
    
    @RequestMapping(value = "/phone/test3", method = RequestMethod.POST)
    public String test3(Model model, @ModelAttribute ModelPhone phone) {
        
        service.insertPhone(phone);
        
        List<ModelPhone> list = service.getPhoneList();
        
        model.addAttribute("list", list);
        
        return "phone/test";
    }
    
}
