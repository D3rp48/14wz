package com.fcat.service;

import com.fcat.data.model.Image;
import com.fcat.web.bean.forms.ImageUploadForm;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

public interface ImageService {
    List<Image> getImages();

    List<Image> findByExpressionsPaged(Integer rows, Integer page);

    String uploadImage(CommonsMultipartFile file, String label, String caption, String tag);

    void removeImage(String fileName);

    void removeImage(Image image);

    void removeImage(CommonsMultipartFile file);

}
