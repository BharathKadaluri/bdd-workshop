package com.nineleaps.bdd.controllers;

import com.nineleaps.bdd.dto.File;
import com.nineleaps.bdd.dto.UploadStatus;
import com.nineleaps.bdd.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProductCsvUploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/api/v1/uploadFile")
    public UploadStatus uploadCSVFile(@RequestParam("file") MultipartFile file){
        return uploadService.storeFile(file);
    }

    @GetMapping("/api/v1/files")
    public File getFiles(){
        return uploadService.getFiles();
    }

    @DeleteMapping("/api/v1/files")
    public void deleteFiles(){
        uploadService.flushFiles();
    }
}
