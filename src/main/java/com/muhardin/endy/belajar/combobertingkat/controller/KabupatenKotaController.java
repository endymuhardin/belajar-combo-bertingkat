package com.muhardin.endy.belajar.combobertingkat.controller;

import com.muhardin.endy.belajar.combobertingkat.dao.KabupatenKotaDao;
import com.muhardin.endy.belajar.combobertingkat.dao.ProvinsiDao;
import com.muhardin.endy.belajar.combobertingkat.entity.KabupatenKota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KabupatenKotaController {

    @Autowired private KabupatenKotaDao kabupatenKotaDao;
    @Autowired private ProvinsiDao provinsiDao;

    @GetMapping({"/api/provinsi/{provinsi}/kabupaten", "/api/{provinsi}/kota"})
    public List<KabupatenKota> findByProvinsiAndName(@PathVariable String provinsi, @RequestParam String nama){
        return kabupatenKotaDao.findByProvinsiAndNamaContainingIgnoreCaseOrderByNama(provinsiDao.findById(provinsi).get(), nama);
    }
}
