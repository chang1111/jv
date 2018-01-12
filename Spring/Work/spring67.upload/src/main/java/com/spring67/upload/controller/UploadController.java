package com.spring67.upload.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring67.upload.inf.IServiceUpload;
import com.spring67.upload.model.ModelUploadFile;
import com.spring67.upload.model.RepositoryFiles;
import com.spring67.upload.service.ServiceUpload;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@Autowired
	private IServiceUpload service;
	
	@RequestMapping(value = "/upload/fileupload", method = RequestMethod.GET)
	public String fileupload(Model model) {
		logger.info("fileupload");
		
		return "upload/fileupload";
	}
	
    @RequestMapping(value = "/upload/fileuploadone", method = RequestMethod.POST)
    public String fileuploadone(Model model
                                   , @RequestParam(value="upDir") String upDir
                                   , @RequestParam(value="file") MultipartFile clientFile) throws IllegalStateException, IOException {
        logger.info("fileuploadone");
        
        // 클라이언트의 파일을 서버로 복사
        
        // Table insert 작업
        if (!clientFile.getOriginalFilename().isEmpty()) {
            
            // 업로드 폴더 존재 여부 체크. 없으면 폴더 생성.
            java.io.File uploadDir = new java.io.File(upDir);
            
            if (!uploadDir.exists())
                uploadDir.mkdir();
            
            // 클라이언트의 첨부 파일을 서버로 복사
            String fileName = clientFile.getOriginalFilename();
            String tempName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String filepath = upDir + tempName;
            java.io.File f = new java.io.File(filepath);
            clientFile.transferTo(f); // 파일 카피하는 메서드
            
            // DB insert 처리를 위한 코드
            ModelUploadFile attachfile = new ModelUploadFile();
            attachfile.setFileNameOrig(fileName);
            attachfile.setFileNameTemp(tempName);
            attachfile.setFileSize((Long) f.length());
            attachfile.setContentType(clientFile.getContentType()); // 파일 확장자
            
            // DB insert
            service.insertUploadFile(attachfile);
        }
        // 결과 출력
        List<ModelUploadFile> result = service.getUploadFile(null);
        model.addAttribute("files", result);
        
        return "upload/fileuploadlist";
    }
    
    @RequestMapping(value = "/upload/fileuploadmulti", method = RequestMethod.POST)
    public String fileuploadmulti(Model model
                                   , @RequestParam(value="upDir") String upDir
                                   , @ModelAttribute RepositoryFiles uploadForm) throws IllegalStateException, IOException {
        logger.info("fileuploadmulti");
        
        // 클라이언트의 파일을 서버로 복사
        // step2. 로컬 첨부 파일을 서버로 올리기 위한 코드
        if (uploadForm != null && uploadForm.getFiles().size() > 0) {
            // 업로드 폴더 존재 여부 체크. 없으면 폴더 생성.
            java.io.File uploadDir = new java.io.File(upDir);
            if (!uploadDir.exists())
                uploadDir.mkdir();
            // DB 에 insert 할 데이터를 닫는 list
            List<ModelUploadFile> listfile = new ArrayList<>();
            List<MultipartFile> files = uploadForm.getFiles();
            if (files != null && files.size() > 0) {
                int index = 0;
                for (MultipartFile file : files) {
                    // 클라이언트의 첨부 파일을 서버로 복사
                    String fileName = file.getOriginalFilename();
                    String tempName = LocalDateTime.now().format(
                            DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
                            + String.format("%04d", ++index);
                    String filepath = upDir + "/" + tempName;
                    java.io.File f = new java.io.File(filepath);
                    file.transferTo(f);
                    // DB insert 처리를 위한 코드
                    ModelUploadFile attachfile = new ModelUploadFile();
                    attachfile.setFileNameOrig(fileName);
                    attachfile.setFileNameTemp(tempName);
                    attachfile.setFileSize((Long) f.length());
                    attachfile.setContentType(file.getContentType()); // 확장자
                    //
                    listfile.add(attachfile);
                }
            }
            // DB insert
            service.insertUploadFileList(listfile);
        }

        // Table insert 작업
        
        // 결과 출력
        List<ModelUploadFile> result = service.getUploadFile(null);
        model.addAttribute("files", result);
        
        return "upload/fileuploadlist";
    }
    
    @RequestMapping(value = "/upload/uploadfilelist", method = RequestMethod.GET)
    public String uploadfilelist(Model model) {
        logger.info("uploadfilelist");
        
        
        // 결과 출력
        List<ModelUploadFile> result = service.getUploadFile(null);
        model.addAttribute("files", result);
        
        return "upload/fileuploadlist";
    }
    
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public String download(Model model
                            , @RequestParam String filenametemp
                            , @RequestParam String filenameorig) {
        
        logger.info("download");
        
        model.addAttribute("filenameorig", filenameorig);
        model.addAttribute("filenametemp", filenametemp);
        
        return "upload/download";
    }
    
}
