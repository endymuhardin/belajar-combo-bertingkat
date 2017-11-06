package com.muhardin.endy.belajar.combobertingkat.dao;

import com.muhardin.endy.belajar.combobertingkat.entity.Kecamatan;
import com.muhardin.endy.belajar.combobertingkat.entity.Kelurahan;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface KelurahanDao extends PagingAndSortingRepository<Kelurahan, String> {
    List<Kelurahan> findByKecamatanAndNamaContainingIgnoreCaseOrderByNama(Kecamatan k, String nama);
}
