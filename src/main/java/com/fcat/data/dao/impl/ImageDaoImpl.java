package com.fcat.data.dao.impl;

import com.fcat.data.dao.ImageDao;
import com.fcat.data.model.Image;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDaoImpl extends GenericDaoImpl<Image, Integer> implements ImageDao {
    public ImageDaoImpl() {
        super(Image.class);
    }
}
