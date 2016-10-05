package com.fcat.web.bean.forms;

import com.fcat.data.model.Image;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ImageUploadForm implements Serializable {
    private CommonsMultipartFile file;
    private String label;
    private String tag;
    private String caption;
    private String url;

    public void fillForm(Image image) {
        setLabel(image.getLabel());
        setUrl(image.getUrl());
        setTag(image.getTag());
        setCaption(image.getCaption());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public CommonsMultipartFile getFile() {
        return file;
    }

    public void setFile(CommonsMultipartFile file) {
        this.file = file;
    }
}
