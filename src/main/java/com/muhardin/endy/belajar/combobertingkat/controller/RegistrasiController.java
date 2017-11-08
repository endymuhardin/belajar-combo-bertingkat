package com.muhardin.endy.belajar.combobertingkat.controller;

import com.muhardin.endy.belajar.combobertingkat.editor.KelurahanEditor;
import com.muhardin.endy.belajar.combobertingkat.dao.RegistrasiDao;
import com.muhardin.endy.belajar.combobertingkat.entity.Kelurahan;
import com.muhardin.endy.belajar.combobertingkat.entity.Registrasi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class RegistrasiController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrasiController.class);

    @Autowired private RegistrasiDao registrasiDao;
    @Autowired private KelurahanEditor kelurahanEditor;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Kelurahan.class, kelurahanEditor);
    }

    @GetMapping("/")
    public String homepage(){
        return "redirect:/registrasi.html";
    }

    @PostMapping("/registrasi")
    public String prosesForm(@ModelAttribute @Valid Registrasi reg, BindingResult errors, SessionStatus status){
        if(errors.hasErrors()) {
            logger.debug(errors.toString());
            return "redirect:/registrasi.html";
        }

        logger.debug("Email : {}", reg.getEmail());
        logger.debug("Password : {}", reg.getPassword());
        logger.debug("Nama : {}", reg.getNama());
        logger.debug("Alamat : {}", reg.getAlamat());
        logger.debug("Kelurahan : {}", reg.getKelurahan());

        registrasiDao.save(reg);

        return "redirect:selesai.html";
    }
}
