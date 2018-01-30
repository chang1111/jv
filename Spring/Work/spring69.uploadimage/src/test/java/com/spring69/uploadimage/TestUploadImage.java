package com.spring69.uploadimage;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring69.uploadimage.inf.IServiceUploadImage;
import com.spring69.uploadimage.model.ModelUploadImage;

public class TestUploadImage {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private static IServiceUploadImage service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean(IServiceUploadImage.class);
    }
    
    @Test
    public void testInsertPhoto() {
        int result = -1;
        try {
            File file = new File("src/test/resources/image.png");
            BufferedImage originalImage = ImageIO.read(file.getAbsoluteFile());
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "jpg", baos);
            baos.flush();
            byte[] photoBytes = baos.toByteArray();
            
            ModelUploadImage fileupload = new ModelUploadImage();
            fileupload.setFileName( file.getName() );
            fileupload.setFileSize( file.length() );
            fileupload.setContentType( Files.probeContentType( file.toPath() ) );
            fileupload.setImageBytes(photoBytes);
            fileupload.setImageBase64( Base64.getEncoder().encodeToString(baos.toByteArray()) );
            
            result = service.insertPhoto(fileupload);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        assertNotSame(-1, result);
    }
    
    @Test
    public void testGetImageByte() {
        
        ModelUploadImage result = null;
        
        try {
            int uploadImageNo = 1;
            result = service.getImageByte(uploadImageNo);
            
            // convert byte array back to BufferedImage
            InputStream in = new ByteArrayInputStream( result.getImageBytes() );
            BufferedImage bImageFromConvert = ImageIO.read(in);
            
            File file = new File( "c:\\" + result.getFileName() );
            
            File dir = new File(file.getAbsolutePath());
            if (!dir.exists()) {
                dir.mkdir();
            }
            
            ImageIO.write(bImageFromConvert, FilenameUtils.getExtension(file.getName()), file );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        
        assertSame(1, result.getUploadImageNo() );
    }
    
}
