package com.spring.exam09;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	@Autowired
	IServicePhone srvphone;
	
	@RequestMapping(value = "/phone/writeone", method = RequestMethod.GET)
	public String writeone(Model model) {
		logger.info("/phone/writeone:get");
		
		return "writeOneForm";
	}
	
    @RequestMapping(value = "/phone/writeonelist", method = RequestMethod.GET)
    public String writeonelist(Model model) {
        logger.info("/phone/writeonelist:get");
        
        List<ModelPhone> phone = srvphone.getPhoneList();
        model.addAttribute("phone", phone);
        
        return "writeOneResult";
    }
    
    @RequestMapping(value = "/phone/writeone", method = RequestMethod.POST)
    public String writeone1(Model model
            , @RequestParam(defaultValue="") String phname
            , @RequestParam(defaultValue="") String phfactory
            , @RequestParam(defaultValue="0") Integer phprice) {
        logger.info("/phone/writeone:post");
        
        ModelPhone phone = new ModelPhone();
        
        phone.setPhname(phname);
        phone.setPhfactory(phfactory);
        phone.setPhprice(phprice);
        
        srvphone.insertPhone(phone);
        
        return "redirect:/phone/writeonelist";
    }
//    
//    @RequestMapping(value = "/phone/writeone2", method = RequestMethod.POST)
//    public String writeone2(Model model
//            , @RequestParam(defaultValue="") String name
//            , @RequestParam(defaultValue="") String manufacturer
//            , @RequestParam(defaultValue="0") Integer price
//            , RedirectAttributes rttr) {
//        logger.info("/phone/writeone2");
//        
//        ModelPhone phone = new ModelPhone();
//        
//        phone.setName(name);
//        phone.setManufacturer(manufacturer);
//        phone.setPrice(price);
//        
//        int result = srvphone.insertPhone(phone);
//        
//        if (result <= 0) {
//            rttr.addFlashAttribute("msg", WebConstant.MSG_FAIL_INSERT);
//            return "redirect:/phone/writemain";
//        } else {
//            return "redirect:/phone/writeoneresult";
//            
//        }
//    }
//    
//    @RequestMapping(value = "/phone/writeone3", method = RequestMethod.POST)
//    public String writeone3(Model model, @ModelAttribute ModelPhone phone
//            , RedirectAttributes rttr) {
//        logger.info("/phone/writeone3");
//        
//        int result = srvphone.insertPhone(phone);
//        
//        if (result <= 0) {
//            rttr.addFlashAttribute("msg", WebConstant.MSG_FAIL_INSERT);
//            return "redirect:/phone/writemain";
//        } else {
//            return "redirect:/phone/writeoneresult";
//            
//        }
//    }
//    
//    @RequestMapping(value = "/phone/writeone4", method = RequestMethod.POST)
//    public String writeone4(Model model) {
//        logger.info("/phone/writeone4");
//        
//        return "phone/writeoneresult";
//    }
    
}
