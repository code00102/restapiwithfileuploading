package com.myrestapp.restapp.controllers;

import com.myrestapp.restapp.filehelper.FileUploadHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileController {


    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-my-file")
    public ResponseEntity<String> handleMyFile(@RequestParam("myfile") MultipartFile file){

        boolean b = fileUploadHelper.uploadMyFile(file);
        if(b){

            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    

    
}
