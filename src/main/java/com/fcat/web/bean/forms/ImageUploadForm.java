package com.fcat.web.bean.forms;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.Serializable;

public class ImageUploadForm implements Serializable {
    private com.fcat.data.model.Image image;
    private CommonsMultipartFile file;

    public com.fcat.data.model.Image getImage() {
        return image;
    }

    public void setImage(com.fcat.data.model.Image image) {
        this.image = image;
    }

    public CommonsMultipartFile getFile() {
        return file;
    }

    public void setFile(CommonsMultipartFile file) {
        this.file = file;
    }
}
