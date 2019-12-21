package com.nineleaps.bdd.services;

import com.nineleaps.bdd.dto.File;
import com.nineleaps.bdd.dto.UploadStatus;
import com.nineleaps.bdd.exceptions.InvalidFileException;
import com.nineleaps.bdd.exceptions.InvalidPathException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductCsvUploadService implements UploadService{
    private Map<Long, String> fileMap = new HashMap<>();
    private static final String ERROR_STATUS = "error";
    private static final String SUCCESS_STATUS = "success";
    private static final String MSG_SUCCESS = "file has been uploaded";
    private static final String MSG_ERROR = "Error invalid file format";
    private static final String CSV_EXTENSION = "csv";
    private static final String WRONG_PATH = "WRONG_PATH";


    @Override
    public UploadStatus storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        UploadStatus status = null;
        if(fileName.contains(CSV_EXTENSION)){
            status = new UploadStatus(SUCCESS_STATUS, MSG_SUCCESS);
            fileMap.put(Instant.now().toEpochMilli(), fileName);
        }else if (fileName.contains(WRONG_PATH)){
            throw new InvalidPathException("the entered path is invalid");
        } else {
           throw new InvalidFileException("the entered path has no CSV files");
        }
        return status;
    }

    @Override
    public File getFiles() {
        return new File(new ArrayList<>(fileMap.values()));
    }

    @Override
    public void flushFiles() {
        this.fileMap.clear();
    }
}
