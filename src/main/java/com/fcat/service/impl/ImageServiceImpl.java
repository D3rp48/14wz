package com.fcat.service.impl;

import com.fcat.data.dao.ImageDao;
import com.fcat.data.model.Image;
import com.fcat.service.ImageService;
import com.fcat.web.bean.forms.ImageUploadForm;
import com.google.common.base.Strings;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;


    private final static String FILE_BASE = ""; //TODO filebase
    private final static List<String> IMAGE_FORMATS = new ArrayList<String>() {{
        add("jpg");
        add("jpeg");
        add("png");
    }};

    private String getName(CommonsMultipartFile file) {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        return FILE_BASE + "/images/items/" + file.getName() + "." + extension;
    }

    @Override
    public List<Image> getImages() {
        return imageDao.list();
    }

    @Override
    public List<Image> findByExpressionsPaged(Integer rows, Integer page) {
        return imageDao.findByExpressionsPaged(rows, page);
    }

    @Override
    public String uploadImage(CommonsMultipartFile file, String label, String caption, String tag) {
        Image image = new Image();
        image.setUrl(getName(file));
        image.setLabel(label);
        image.setCaption(caption);
        image.setTag(tag);
        image.setAddedDate(LocalDateTime.now());
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            if (!IMAGE_FORMATS.contains(extension.toLowerCase())) {
                return null;
            }
            File outputFile = new File(image.getUrl());
            if (!outputFile.exists()) {
                try {
                    outputFile.getParentFile().mkdirs();
                    outputFile.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            outputStream = new FileOutputStream(outputFile);
            inputStream = new BufferedInputStream(file.getInputStream());
            byte[] buf = new byte[64 * 1024];
            int read;
            while ((read = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, read);
            }
            return extension;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        }
        imageDao.save(image);
        return image.getUrl();
    }

    @Override
    public void removeImage(String fileName) {
        Optional<Image> imageOptional = Optional.of(imageDao.getById(fileName));
        if (imageOptional.isPresent()) {
            removeImage(imageOptional.get());
        }
    }

    @Override
    public void removeImage(Image image) {
        if (!Strings.isNullOrEmpty(image.getUrl())) {
            imageDao.delete(image);
        }
    }

    @Override
    public void removeImage(CommonsMultipartFile file) {
        removeImage(getName(file));
    }

}
