<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.IOException" %>
<%@ page import="org.springframework.util.FileCopyUtils" %>
<%
    //request.setCharacterEncoding("UTF-8");//이 작업은 필터가 한다.
    String filenameorig = request.getParameter("filenameorig");
    String filenametemp = request.getParameter("filenametemp");
    
    File file = new File("c:\\upload\\" + filenametemp);
    
    String filetype = filenameorig.substring(filenameorig.indexOf(".") + 1,
            
    filenameorig.length());
    
    if (filetype.trim().equalsIgnoreCase("txt")) {
        response.setContentType("text/plain");
    }
    else {
        response.setContentType("application/octet-stream");
    }
    
    response.setContentLength((int) file.length());
    
    boolean ie = request.getHeader("User-Agent").indexOf("MSIE") != -1;
    
    if (ie) {
        filenameorig = URLEncoder.encode(filenameorig, "UTF-8").replaceAll("\\+", " ");
    }
    else {
        filenameorig = new String(filenameorig.getBytes("UTF-8"), "8859_1");
    }
    
    response.setHeader("Content-Disposition", "attachment; filename=\"" + filenameorig + "\"");
    
    OutputStream outputStream = response.getOutputStream();
    FileInputStream fis = null;
    
    try {
        fis = new FileInputStream(file);
        FileCopyUtils.copy(fis, outputStream);
    }
    finally {
        if (fis != null) {
            try {
                fis.close();
            }
            catch (IOException e) {
            }
        }
    }
    out.flush();
%>