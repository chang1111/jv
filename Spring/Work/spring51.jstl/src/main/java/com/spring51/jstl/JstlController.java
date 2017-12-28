package com.spring51.jstl;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class JstlController {
    
    private static final Logger logger = LoggerFactory
            .getLogger(HomeController.class);
    
    @RequestMapping(value = "/jstl/jstl01", method = RequestMethod.GET)
    public String jstl01(Model model) {
        logger.info("jstl01");
        return "jstl/jstl01";
    }
}
