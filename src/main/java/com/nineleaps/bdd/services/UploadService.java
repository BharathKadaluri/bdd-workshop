package com.nineleaps.bdd.services;

import com.nineleaps.bdd.dto.File;
import com.nineleaps.bdd.dto.UploadStatus;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    UploadStatus storeFile(MultipartFile file);
    File getFiles();
    void flushFiles();
}
