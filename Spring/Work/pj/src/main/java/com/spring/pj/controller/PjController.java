package com.spring.pj.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.pj.common.WebConstants;
import com.spring.pj.inf.IServiceUser;
import com.spring.pj.model.ModelUser;

@Controller
public class PjController {
	
	private static final Logger logger = LoggerFactory.getLogger(PjController.class);
	
	@Autowired
	IServiceUser srvuser;
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        logger.info("login:get");
        
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @RequestParam String userid,
                                     @RequestParam String passwd,
                                     HttpSession session,
                                     RedirectAttributes rttr) {
        logger.info("/login : post");
        
        ModelUser result = srvuser.login(userid, passwd);
        
        if (result != null) {
            // 로그인 성공
            session.setAttribute(/* 세션명 */WebConstants.SESSION_NAME, /* 세션 */result);
            
            
            return "redirect:/"; // --> http://localhost:8080 페이지가 열림
        }
        else {
//            // 로그인 실패
//            // RedirectAttributes는 redirect시 사용되는 변수를 전달할 때 사용되는 객체다.
            rttr.addFlashAttribute("msg", "로그인 실패");
//            rttr.addFlashAttribute("url", url);
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
       logger.info("logout");
       
       return "redirect:/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        logger.info("register");
        
        return "register";
    }

}
