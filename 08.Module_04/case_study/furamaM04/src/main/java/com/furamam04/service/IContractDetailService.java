package com.furamam04.service;

import com.furamam04.entity.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    void save (ContractDetail contractDetail);

    void delete(Long id);

    List<ContractDetail> findAll();

    ContractDetail findById(Long id);
}
