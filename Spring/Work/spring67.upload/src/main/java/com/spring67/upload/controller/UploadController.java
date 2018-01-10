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

import com.spring67.upload.inf.IServiceUpload;
import com.spring67.upload.model.ModelUploadFile;
import com.spring67.upload.repository.RepositoryFiles;

@Controller
public class UploadController {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    
    @Autowired
    private IServiceUpload serviceupload;
    
    /**
     * http://localhost/upload/uploadfile
     */
    @RequestMapping(value = "/upload/uploadfile", method = RequestMethod.GET)
    public String uploadfile(Model model) {
        logger.info("uploadfile");
        return "upload/uploadfile";
    }
    
    /**
     * http://localhost/upload/uploadone
     */
    @RequestMapping(value = "/upload/uploadfileone", method = RequestMethod.POST)
    public String uploadfileone(Model model,
            @RequestParam(value = "file") MultipartFile file,
            @RequestParam(value = "upDir") String upDir)
            throws IllegalStateException, IOException {
        logger.info("uploadfile");
        // 폴더 존재 여부 검사
        java.io.File dir = new java.io.File(upDir);
        if (!dir.exists())
            dir.mkdir();
        // 로컬 파일을 서버로 올리기 위한 코드
        String fileName = file.getOriginalFilename();
        String tempName = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String filepath = upDir + "/" + tempName;
        java.io.File f = new java.io.File(filepath);
        file.transferTo(f);
        // DB insert 처리를 위한 코드
        ModelUploadFile attachfile = new ModelUploadFile();
        attachfile.setFileNameOrig(fileName);
        attachfile.setFileNameTemp(f.getName());
        attachfile.setFileSize((Long) f.length());
        attachfile.setContentType(file.getContentType()); // 확장자
        // DB insert
        serviceupload.insertUploadFile(attachfile);
        // uploadsuccess.jsp 에 출력할 파일이름 저장
        List<String> filelist = new ArrayList<String>();
        filelist.add(fileName);
        model.addAttribute("files", filelist);
        model.addAttribute("upDir", upDir);
        model.asMap().clear(); // Redirect without parameters being added to my url
        return "redirect:uploadfilelist";
    }
    
    /**
     * http://localhost/upload/uploadfilemulti
     */
    @RequestMapping(value = "/upload/uploadfilemulti", method = RequestMethod.POST)
    public String uploadfilemulti(Model model,
            @ModelAttribute RepositoryFiles uploadForm,
            @RequestParam(value = "upDir") String upDir)
            throws IllegalStateException, IOException {
        logger.info("uploadfilemulti");
        List<MultipartFile> files = uploadForm.getFiles();
        if (files != null && files.size() > 0) {
            for (MultipartFile file : files) {
                // 클라이언트의 첨부 파일을 서버로 복사
                String fileName = file.getOriginalFilename();
                String tempName = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                String filepath = upDir + "/" + tempName;
                java.io.File f = new java.io.File(filepath);
                file.transferTo(f);
                // DB insert 처리를 위한 코드
                ModelUploadFile attachfile = new ModelUploadFile();
                attachfile.setFileNameOrig(fileName);
                attachfile.setFileNameTemp(f.getName());
                attachfile.setFileSize((Long) f.length());
                attachfile.setContentType(file.getContentType()); // 확장자
                // DB insert
                serviceupload.insertUploadFile(attachfile);
            }
        }
        // uploadsuccess.jsp 에 출력할 파일이름 저장
        List<String> filelist = new ArrayList<String>();
        for (MultipartFile file : files) {
            filelist.add(file.getOriginalFilename());
        }
        model.addAttribute("files", filelist);
        model.addAttribute("upDir", upDir);
        model.asMap().clear(); // Redirect without parameters being added to my url
        return "redirect:uploadfilelist";
    }
    
    /**
     * http://localhost/upload/uploadlist
     */
    @RequestMapping(value = "/upload/uploadfilelist", method = RequestMethod.GET)
    public String uploadfilelist(Model model) {
        logger.info("uploadfilelist");
        ModelUploadFile file = null;
        List<ModelUploadFile> files = serviceupload.getUploadFile(file);
        model.addAttribute("files", files);
        return "upload/uploadfilelist";
    }
    
    /**
     * http://localhost/download
     */
    @RequestMapping(value = "upload/download", method = RequestMethod.POST)
    public String download(Model model, @RequestParam String filenametemp,
            @RequestParam String filenameorig) {
        logger.info("download");
        model.addAttribute("filenameorig", filenameorig);
        model.addAttribute("filenametemp", filenametemp);
        return "upload/download";
    }
}
