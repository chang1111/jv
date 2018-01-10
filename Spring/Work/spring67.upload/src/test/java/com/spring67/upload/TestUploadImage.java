package com.spring67.upload;

import static org.junit.Assert.*;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring67.upload.inf.IServiceUploadImage;
import com.spring67.upload.model.ModelUploadImage;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.Base64;

public class TestUploadImage {
    private static ApplicationContext  context = null;
    private static IServiceUploadImage service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext(
                "file:src/main/webapp/WEBINF/spring/appServlet/servlet-context.xml");
        service = context.getBean(IServiceUploadImage.class);
    }
    
    @Test
    public void test_insertPhoto() {
        // convert image to byte
        try {
            File file = new File("src/test/resources/image.png");
            BufferedImage originalImage = ImageIO.read(file.getAbsoluteFile());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "jpg", baos);
            baos.flush();
            byte[] photoBytes = baos.toByteArray();
            ModelUploadImage fileupload = new ModelUploadImage();
            fileupload.setFileName(file.getName());
            fileupload.setFileSize(file.length());
            fileupload.setContentType(Files.probeContentType(file.toPath()));
            fileupload.setImageBytes(photoBytes);
            fileupload.setImageBase64(
                    Base64.getEncoder().encodeToString(baos.toByteArray()));
            int result = service.insertPhoto(fileupload);
            assertNotSame(-1, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void test_getImageByte() {
        // convert byte to image
        try {
            int attachfileno = 1;
            ModelUploadImage result = service.getImageByte(attachfileno);
            // convert byte array back to BufferedImage
            InputStream in = new ByteArrayInputStream(result.getImageBytes());
            BufferedImage bImageFromConvert = ImageIO.read(in);
            File file = new File("c:\\" + result.getFileName());
            File dir = new File(file.getAbsolutePath());
            if (!dir.exists()) {
                dir.mkdir();
            }
            ImageIO.write(bImageFromConvert,
                    FilenameUtils.getExtension(file.getName()), file);
            assertSame(1, result.getUploadImageNo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
