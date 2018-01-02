package com.spring51.jstl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ElController {
	
	private static final Logger logger = LoggerFactory.getLogger(jstlController.class);
	
	@RequestMapping(value = "/el/el01", method = RequestMethod.GET)
	public String el01(Model model) {
		logger.info("el01");
		
		return "el/el01";
    }
    
    @RequestMapping(value = "/el/el02", method = RequestMethod.GET)
    public String el02(Model model) {
        logger.info("el02");
        
        return "el/el02";
    }

    @RequestMapping(value = "/el/el02sub", method = RequestMethod.GET)
    public String el02sub(Model model) {
        logger.info("el02sub");
        
        return "el/el02sub";
    }
}
