package com.muhardin.endy.belajar.combobertingkat.controller;

import com.muhardin.endy.belajar.combobertingkat.dao.KecamatanDao;
import com.muhardin.endy.belajar.combobertingkat.dao.KelurahanDao;
import com.muhardin.endy.belajar.combobertingkat.entity.Kelurahan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KelurahanController {
    @Autowired private KecamatanDao kecamatanDao;
    @Autowired private KelurahanDao kelurahanDao;

    @GetMapping("/api/kecamatan/{kecamatan}/kelurahan")
    public List<Kelurahan> findByKecamatanAndNama(@PathVariable String kecamatan, @RequestParam String nama){
        return kelurahanDao.findByKecamatanAndNamaContainingIgnoreCaseOrderByNama(kecamatanDao.findById(kecamatan).get(), nama);
    }
}
