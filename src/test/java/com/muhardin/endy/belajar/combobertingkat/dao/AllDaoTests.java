package com.muhardin.endy.belajar.combobertingkat.dao;

import com.muhardin.endy.belajar.combobertingkat.entity.KabupatenKota;
import com.muhardin.endy.belajar.combobertingkat.entity.Kecamatan;
import com.muhardin.endy.belajar.combobertingkat.entity.Provinsi;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AllDaoTests {
    @Autowired private ProvinsiDao provinsiDao;
    @Autowired private KabupatenKotaDao kabupatenKotaDao;
    @Autowired private KecamatanDao kecamatanDao;
    @Autowired private KelurahanDao kelurahanDao;

    @Test
    public void testFindProvinsiByNama(){
        List<Provinsi> hasil = provinsiDao.findByNamaContainingIgnoreCaseOrderByNama("ja");
        Assert.assertFalse(hasil.isEmpty());
        Assert.assertTrue(hasil.size() == 3);

        Assert.assertTrue(provinsiDao.findByNamaContainingIgnoreCaseOrderByNama("jak").size() == 1);
        Assert.assertTrue(provinsiDao.findByNamaContainingIgnoreCaseOrderByNama("xxx").isEmpty());
    }

    @Test
    public void testFindKabupatenByProvinsiAndNama(){
        Provinsi p = new Provinsi();
        p.setId("jabar");
        Assert.assertTrue(kabupatenKotaDao.findByProvinsiAndNamaContainingIgnoreCaseOrderByNama(p, "xx").isEmpty());
        Assert.assertFalse(kabupatenKotaDao.findByProvinsiAndNamaContainingIgnoreCaseOrderByNama(p, "bo").isEmpty());
        Assert.assertTrue(kabupatenKotaDao.findByProvinsiAndNamaContainingIgnoreCaseOrderByNama(p, "bo").size() == 2);
    }

    @Test
    public void testFindKecamatanByKabupatenKotaAndNama(){
        KabupatenKota x = new KabupatenKota();
        x.setId("kabbogor");
        Assert.assertTrue(kecamatanDao.findByKabupatenKotaAndNamaContainingIgnoreCaseOrderByNama(x, "xx").isEmpty());
        Assert.assertFalse(kecamatanDao.findByKabupatenKotaAndNamaContainingIgnoreCaseOrderByNama(x, "gunung").isEmpty());
        Assert.assertTrue(kecamatanDao.findByKabupatenKotaAndNamaContainingIgnoreCaseOrderByNama(x, "ci").size() == 1);
    }

    @Test
    public void testFindKelurahanByKecamatanAndNama(){
        Kecamatan x = new Kecamatan();
        x.setId("gnputri");
        Assert.assertTrue(kelurahanDao.findByKecamatanAndNamaContainingIgnoreCaseOrderByNama(x, "xx").isEmpty());
        Assert.assertFalse(kelurahanDao.findByKecamatanAndNamaContainingIgnoreCaseOrderByNama(x, "ke").isEmpty());
        Assert.assertTrue(kelurahanDao.findByKecamatanAndNamaContainingIgnoreCaseOrderByNama(x, "ci").size() == 2);
    }
}
