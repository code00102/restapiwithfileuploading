package com.myrestapp.restapp.filehelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class FileUploadHelper {


    public final String UPLOAD_DIR = new ClassPathResource("static/images").getFile().getAbsolutePath();


    public FileUploadHelper() throws IOException{

    }

    public boolean uploadMyFile(MultipartFile file){
        try{
            
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;

        }
        
    }
    
}
