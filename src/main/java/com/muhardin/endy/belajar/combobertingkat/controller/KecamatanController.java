package com.muhardin.endy.belajar.combobertingkat.controller;

import com.muhardin.endy.belajar.combobertingkat.dao.KabupatenKotaDao;
import com.muhardin.endy.belajar.combobertingkat.dao.KecamatanDao;
import com.muhardin.endy.belajar.combobertingkat.entity.Kecamatan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KecamatanController {
    @Autowired private KabupatenKotaDao kabupatenKotaDao;
    @Autowired private KecamatanDao kecamatanDao;

    @GetMapping({"/api/kabupaten/{kabupatenkota}/kecamatan","/api/kota/{kabupatenkota}/kecamatan"})
    public List<Kecamatan> findByName(@PathVariable("kabupatenkota") String k, @RequestParam String nama){
        return kecamatanDao.findByKabupatenKotaAndNamaContainingIgnoreCaseOrderByNama(kabupatenKotaDao.findById(k).get(),nama);
    }
}
