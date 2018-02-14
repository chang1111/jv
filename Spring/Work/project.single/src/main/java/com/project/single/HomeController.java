package com.project.single;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.single.inf.IServicePost;
import com.project.single.model.ModelAttachImage;
import com.project.single.model.ModelComments;
import com.project.single.model.ModelPost;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
    private final String TOPIC = "JavaSampleApproach";
    
    @Autowired
    AndroidPushNotificationsService androidPushNotificationsService;
    
	@Autowired
	private IServicePost srvpost;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "forward:/postview";
	}

   @RequestMapping(value = "/postview", method = RequestMethod.GET)
    public String postview(Model model) {
        logger.info("postview:get");
        
        List<ModelPost> post = srvpost.getPostList(1, 1);
        
        for (ModelPost i : post) {
            List<ModelComments> comment = srvpost.getCommentList(i.getPostno());
            ModelAttachImage image = srvpost.getAttachImage(i.getPostno());
            i.setComment(comment);
            i.setImage(image);
        }
//        List<ModelPost> postsrv2 = srvpost.getPostList(1, 10000);
        
        model.addAttribute("item", post);
//        model.addAttribute("servercommentcount", postsrv2.size() );
        
        return "postview";
    }
   
   @RequestMapping(value = "/rest/scrollautoadd", method = RequestMethod.POST)
// @ResponseBody
 public String scrollautoadd(Model model, Integer num) {
     logger.info("/rest/scrollautoadd:post");
     
     ModelPost post = srvpost.getPostList(num, num).get(0);
     
     List<ModelComments> comment = srvpost.getCommentList(post.getPostno());
     ModelAttachImage image = srvpost.getAttachImage(post.getPostno());
     post.setComment(comment);
     post.setImage(image);
     
     model.addAttribute("post", post);
     return "scrollautoadd";
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
       post.setContent(content);
       
       Integer postno = srvpost.insertPost(post);
       
       if (image.getImage().getContentType().contains("image")) {
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
       }
       
       JSONObject body = new JSONObject();
       body.put("to", "/topics/" + TOPIC);
       body.put("priority", "high");

       HttpEntity<String> request = new HttpEntity<>(body.toString());

       CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
       CompletableFuture.allOf(pushNotification).join();

       try {
           String firebaseResponse = pushNotification.get();
           
           new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
       } catch (InterruptedException e) {
           e.printStackTrace();
       } catch (ExecutionException e) {
           e.printStackTrace();
       }

       new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);

       return "redirect:/";
   }
   
   @RequestMapping(value= "/rest/insertcomment", method = RequestMethod.POST)
// @ResponseBody
    public String insertcomment(Model model, Integer postno, String memo) {
        logger.info("/rest/insertcomment");
        
        ModelComments comment = new ModelComments();
        comment.setPostno(postno);
        comment.setMemo(memo);
        comment.setRegdate(new Date());
        
        // pk값을 반환
        int commentno = srvpost.insertComment(comment);
        
        ModelComments result = srvpost.getComment(commentno);
        model.addAttribute("comment", result);
        
        return "commentlistbody";
    }
   
    @RequestMapping(value= "/rest/addcountgood", method = RequestMethod.POST)
    @ResponseBody
    public int addcountgood(Integer postno) {
        logger.info("/rest/addcountgood");
        
        srvpost.addCountGood(postno);
        
        return srvpost.getPostOne(postno).getCountgood();
    }

    @RequestMapping(value= "/rest/addcountbad", method = RequestMethod.POST)
    @ResponseBody
    public int addcountbad(Integer postno) {
        logger.info("/rest/addcountbad");
        
        srvpost.addCountBad(postno);
        
        return srvpost.getPostOne(postno).getCountbad();
    }
    
    @RequestMapping(value= "/rest/updatecomment", method = RequestMethod.POST)
    @ResponseBody
    public int updatecomment(Integer commentno, String memo) {
        logger.info("/rest/updatecomment");
        
        ModelComments searchValue = new ModelComments();
        ModelComments updateValue = new ModelComments();
        searchValue.setCommentno(commentno);
        updateValue.setMemo(memo);
        updateValue.setRegdate(new Date());
        
        int result = srvpost.updateComment(updateValue, searchValue);
        
        return result;
    }
    
    @RequestMapping(value= "/rest/commentdelete", method = RequestMethod.POST)
    @ResponseBody
    public int commentdelete(Integer commentno) {
        logger.info("/rest/commentdelete");
        
        ModelComments comment = new ModelComments();
        comment.setCommentno(commentno);
        
        int result = srvpost.deleteComment(comment);
        
        return result;
    }
    
}
