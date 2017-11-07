package com.muhardin.endy.belajar.combobertingkat.editor;

import com.muhardin.endy.belajar.combobertingkat.dao.KelurahanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class KelurahanEditor extends PropertyEditorSupport {
    @Autowired
    private KelurahanDao kelurahanDao;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(kelurahanDao.findById(text).get());
    }
}
