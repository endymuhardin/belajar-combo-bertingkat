package com.muhardin.endy.belajar.combobertingkat.dao;

import com.muhardin.endy.belajar.combobertingkat.entity.Provinsi;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProvinsiDao extends PagingAndSortingRepository<Provinsi, String> {
    List<Provinsi> findByNamaContainingIgnoreCaseOrderByNama(String nama);
}
