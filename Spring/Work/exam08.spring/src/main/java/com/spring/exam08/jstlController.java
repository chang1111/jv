package com.spring.exam08;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class jstlController {
	
	private static final Logger logger = LoggerFactory.getLogger(jstlController.class);
	
	@RequestMapping(value = "/jstl/jstl11", method = RequestMethod.GET)
	public String jstl11(Model model
	        , @RequestParam(defaultValue="-1") Integer val ) {
		logger.info("jstl11");
		
		model.addAttribute("val", val);
		
		return "jstl11";
	}
	
    @RequestMapping(value = "/jstl/jstlforeach", method = RequestMethod.GET)
    public String jstlforeach(Model model) {
        logger.info("jstlforeach");
        
        List<String> list = new ArrayList<String>();
        
        list.add("순두부");
        list.add("된장찌개");
        list.add("제육덮밥");
        
        model.addAttribute("list", list);
        
        return "jstlforeach";
    }
    
}
