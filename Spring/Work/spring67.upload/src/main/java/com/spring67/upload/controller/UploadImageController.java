package com.spring67.upload.controller;

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
import org.springframework.web.multipart.MultipartFile;

import com.spring67.upload.inf.IServiceUploadImage;
import com.spring67.upload.model.ModelUploadImage;

@Controller
public class UploadImageController {
    private static final Logger logger = LoggerFactory
            .getLogger(UploadController.class);
    @Autowired
    private IServiceUploadImage svcupload;
    
    /**
     * 사진 업로드를 위한 화면
     */
    @RequestMapping(value = "/upload/imageupload", method = RequestMethod.GET)
    public String saveImage() {
        return "upload/imageupload";
    }
    
    /**
     * 사진 파일 업로드 후 DB 저장
     */
    @RequestMapping(value = "/upload/imageupload", method = RequestMethod.POST)
    public String saveImage(Model model, @RequestParam String upDir,
            @ModelAttribute ModelUploadImage vo) {
        logger.info("imageupload");
        Integer attachfileno = null;
        try {
            vo.setFileName(vo.getImage().getOriginalFilename());
            vo.setFileSize((Long) vo.getImage().getSize());
            vo.setContentType(vo.getImage().getContentType()); // 확장자
            vo.setImageBytes(vo.getImage().getBytes());
            vo.setImageBase64(Base64.getEncoder()
                    .encodeToString(vo.getImage().getBytes()));
            attachfileno = svcupload.insertPhoto(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/upload/imageview/" + Integer.toString(attachfileno);
    }
    
    /**
     * 임의의 뷰페이지
     */
    @RequestMapping(value = "/upload/imageview/{attachfileno}", method = RequestMethod.GET)
    public String imageview(Model model, @PathVariable int attachfileno) {
        logger.info("imageview");
        ModelUploadImage result = svcupload.getImageByte(attachfileno);
        model.addAttribute("attachfileno", attachfileno);
        model.addAttribute("contentType", result.getContentType());
        model.addAttribute("imageBase64", result.getImageBase64());
        return "upload/imageview";
    }
    
    /** img 태그의 src 에 이미지를 출력하기 위한 메서드 */
    @RequestMapping(value = "/upload/getphoto/{attachfileno}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImageByte(@PathVariable int attachfileno) {
        logger.info("getImageByte");
        ModelUploadImage result = svcupload.getImageByte(attachfileno);
        byte[] imageContent = result.getImageBytes();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(result.getContentType()));
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }
}
