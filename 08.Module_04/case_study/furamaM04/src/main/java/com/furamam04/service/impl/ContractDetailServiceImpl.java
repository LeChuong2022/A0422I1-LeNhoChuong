package com.furamam04.service.impl;

import com.furamam04.entity.ContractDetail;
import com.furamam04.repository.IContractDetailRepository;
import com.furamam04.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(Long id) {
        contractDetailRepository.deleteById(id);
    }

    @Override
    public List<ContractDetail> findAll() {
        return (List<ContractDetail>) contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(Long id) {
        return contractDetailRepository.findById(id).orElse(null);
    }
}
