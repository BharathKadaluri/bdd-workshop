package com.nineleaps.bdd.dto;

import java.util.List;

public class File {
    List<String> files;

    public File(List<String> files) {
        this.files = files;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }
}
