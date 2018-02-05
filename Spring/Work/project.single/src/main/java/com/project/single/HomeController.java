package com.project.single;

import java.util.Base64;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.single.inf.IServicePost;
import com.project.single.model.ModelAttachImage;
import com.project.single.model.ModelPost;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IServicePost srvpost;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "forward:/postview";
	}

   @RequestMapping(value = "/postview", method = RequestMethod.GET)
    public String postview(Model model) {
        logger.info("postview:get");
        
        List<ModelPost> post = srvpost.getPostList(1, 5);
        
        model.addAttribute("item", post);
        
        return "postview";
    }
   
   @RequestMapping(value = "/writepost", method = RequestMethod.GET)
   public String writepost(Model model) {
       logger.info("writepost:get");
       
       return "writepost";
   }
   
   @RequestMapping(value = "/writepost", method = RequestMethod.POST)
   public String writepost(Model model
           , @RequestParam String author
           , @RequestParam String content
           , @ModelAttribute ModelAttachImage image ) {
       logger.info("writepost:post");
       
       ModelPost post = new ModelPost();
       post.setAuthor(author);
       post.setRegdate(new Date());
       content = content.replace("\n", "<br>");
       post.setContent(content);
       
       Integer postno = srvpost.insertPost(post);
       
       try {
           image.setFileName( image.getImage().getOriginalFilename() );
           image.setFileSize( (Long)image.getImage().getSize() );
           image.setContentType( image.getImage().getContentType() );
           image.setImageBytes( image.getImage().getBytes() );
           image.setImageBase64( Base64.getEncoder().encodeToString( image.getImage().getBytes() ) );
           image.setPostno(postno);
           srvpost.insertAttachImage(image);
       } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
           
       }

       return "redirect:/";
   }
   
   @RequestMapping(value = "/rest/imageload", method = RequestMethod.POST)
   @ResponseBody
   public ModelAttachImage imageload(Model model, Integer postno) {
       logger.info("/rest/imageload:post");
       
       ModelAttachImage image = new ModelAttachImage();
       
       image = srvpost.getAttachImage(postno);
       
       return image;
   }
   
   @RequestMapping(value = "/rest/scrollautoadd", method = RequestMethod.POST)
//   @ResponseBody
   public String scrollautoadd(Model model, Integer num) {
       logger.info("/rest/scrollautoadd:post");
       
       ModelPost post = srvpost.getPostList(num, num).get(0);
       
       model.addAttribute("post", post);
       return "scrollautoadd";
   }
   
}
