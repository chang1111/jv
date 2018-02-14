package com.project.single;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.project.single.inf.IServicePost;
import com.project.single.model.ModelAttachImage;
import com.project.single.model.ModelComments;
import com.project.single.model.ModelPost;

@Controller
@RequestMapping(value = "/rest")
public class RestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	
	@Autowired
	private IServicePost srvpost;
	
	private Gson gson = new Gson();
	
	@RequestMapping(value = "/getpostlist", method = RequestMethod.POST)
	@ResponseBody
	public String getpostlist(@RequestParam(defaultValue="0") int start
	        , @RequestParam(defaultValue="100") int end) {
	    logger.info("/rest/getpostlist");
	    
		List<ModelPost> post = srvpost.getPostList(start, end);
		
//        for (ModelPost i : post) {
//            List<ModelComments> comment = srvpost.getCommentList(i.getPostno());
//            ModelAttachImage image = srvpost.getAttachImage(i.getPostno());
//            i.setComment(comment);
//            i.setImage(image);
//        }
        
		String result = gson.toJson(post);
		return result;
	}
	
    @RequestMapping(value = "/getpostone", method = RequestMethod.POST)
    @ResponseBody
    public String getpostone(@RequestParam int postno) {
        logger.info("/rest/getpostone");
        
        ModelPost post = srvpost.getPostOne(postno);
        
        List<ModelComments> comment = srvpost.getCommentList(postno);
        ModelAttachImage image = srvpost.getAttachImage(postno);
        if (comment == null) {
            post.setCommentNum(0);
        }
        else {
            post.setCommentNum(comment.size());
        }
        post.setCommentNum(comment.size());
        post.setComment(comment);
        post.setImage(image);
        
        String result = gson.toJson(post);
        return result;
    }
}
