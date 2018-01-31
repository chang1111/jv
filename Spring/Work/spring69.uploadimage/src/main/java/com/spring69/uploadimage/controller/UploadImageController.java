package com.spring69.uploadimage.controller;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring69.uploadimage.inf.IServiceUploadImage;
import com.spring69.uploadimage.model.ModelUploadImage;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UploadImageController {
    
    private static final Logger logger = LoggerFactory.getLogger(UploadImageController.class);
    
    @Autowired
    private IServiceUploadImage srvuploadimage;
	
    @RequestMapping(value="/upload/uploadimage", method = RequestMethod.GET)
    public String imageupload () {
        logger.info("uploadimage:get");
        return "uploadimage";
    }
	
    @RequestMapping(value="/upload/uploadimage", method = RequestMethod.POST)
    public String imageupload (Model model
            , @RequestParam String upDir
            , @ModelAttribute ModelUploadImage image) {
        logger.info("uploadimage:post");
        
        Integer attachfileno = null;
        
        try {
            image.setFileName( image.getImage().getOriginalFilename() );
            image.setFileSize( (Long)image.getImage().getSize() );
            image.setContentType( image.getImage().getContentType() );
            image.setImageBytes( image.getImage().getBytes() );
            image.setImageBase64( Base64.getEncoder().encodeToString( image.getImage().getBytes() ) );
            attachfileno = srvuploadimage.insertPhoto(image);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        
        return "redirect:/upload/imageview/" + Integer.toString(attachfileno);
    }
    
    @RequestMapping(value="/upload/imageview/{attachfileno}", method = RequestMethod.GET)
    public String imageview(Model model , @PathVariable int attachfileno) {
        logger.info("imageview");
        
        ModelUploadImage result = srvuploadimage.getImageByte(attachfileno);
        
        model.addAttribute("attachfileno", attachfileno);
        model.addAttribute("contentType", result.getContentType() );
        model.addAttribute("imageBase64", result.getImageBase64() );
        
        return "imageview";
    }
    
    @RequestMapping(value="/upload/getphoto/{attachfileno}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImageByte(@PathVariable int attachfileno) {
        logger.info("getImageByte");
        
        ModelUploadImage result = srvuploadimage.getImageByte(attachfileno);
        
        byte[] imageContent = result.getImageBytes();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.valueOf( result.getContentType() ) );
        
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }
    
}
