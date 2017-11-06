package com.muhardin.endy.belajar.combobertingkat.dao;

import com.muhardin.endy.belajar.combobertingkat.entity.KabupatenKota;
import com.muhardin.endy.belajar.combobertingkat.entity.Provinsi;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface KabupatenKotaDao extends PagingAndSortingRepository<KabupatenKota, String> {
    List<KabupatenKota> findByProvinsiAndNamaContainingIgnoreCaseOrderByNama(Provinsi p, String nama);
}
