package com.muhardin.endy.belajar.combobertingkat.dao;

import com.muhardin.endy.belajar.combobertingkat.entity.KabupatenKota;
import com.muhardin.endy.belajar.combobertingkat.entity.Kecamatan;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface KecamatanDao extends PagingAndSortingRepository<Kecamatan, String> {
    List<Kecamatan> findByKabupatenKotaAndNamaContainingIgnoreCaseOrderByNama(KabupatenKota p, String nama);
}
