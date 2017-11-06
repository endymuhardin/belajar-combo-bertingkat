package com.muhardin.endy.belajar.combobertingkat.dao;

import com.muhardin.endy.belajar.combobertingkat.entity.KabupatenKota;
import com.muhardin.endy.belajar.combobertingkat.entity.Kecamatan;
import com.muhardin.endy.belajar.combobertingkat.entity.Kelurahan;
import com.muhardin.endy.belajar.combobertingkat.entity.Provinsi;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class AllControllerTests {

    @LocalServerPort
    private Integer localPort;

    @Autowired
    private TestRestTemplate template;

    private String serverUrl = "http://localhost";

    @Test
    public void testFindProvinsiByName(){
        String url = serverUrl + ":" + localPort + "/api/provinsi?nama=jak";

        Provinsi[] hasil = template.getForEntity(url, Provinsi[].class).getBody();
        Assert.assertTrue(hasil.length == 1);

        Provinsi p = hasil[0];
        Assert.assertEquals("DKI Jakarta", p.getNama());
    }

    @Test
    public void testFindKabupatenByProvinsiAndNama(){
        String url = serverUrl + ":" + localPort + "/api/provinsi/jabar/kabupaten?nama=bog";
        KabupatenKota[] hasil = template.getForEntity(url, KabupatenKota[].class).getBody();
        Assert.assertNotNull(hasil);
        Assert.assertTrue(hasil.length == 2);

        Assert.assertTrue(template.getForEntity(serverUrl + ":" + localPort
                        + "/api/provinsi/jabar/kabupaten?nama=xx",
                KabupatenKota[].class).getBody().length == 0);
    }

    @Test
    public void testFindKecamatanByKabupatenAndNama(){
        String url = serverUrl + ":" + localPort + "/api/kota/surabaya/kecamatan?nama=won";
        Kecamatan[] hasil = template.getForEntity(url, Kecamatan[].class).getBody();
        Assert.assertNotNull(hasil);
        Assert.assertTrue(hasil.length == 1);

        String url2 = serverUrl + ":" + localPort + "/api/kabupaten/kabbogor/kecamatan?nama=ci";
        Kecamatan[] hasil2 = template.getForEntity(url2, Kecamatan[].class).getBody();
        Assert.assertNotNull(hasil2);
        Assert.assertTrue(hasil2.length == 1);
    }

    @Test
    public void testFindKelurahanByKecamatanAndNama(){
        String url = serverUrl + ":" + localPort + "/api/kecamatan/gnputri/kelurahan?nama=ci";
        Kelurahan[] hasil = template.getForEntity(url, Kelurahan[].class).getBody();
        Assert.assertNotNull(hasil);
        Assert.assertTrue(hasil.length == 2);
    }
}
