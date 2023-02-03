package com.furamam04.service;

import com.furamam04.entity.Contract;
import com.furamam04.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    void save (Contract contract);

    void delete (Long id);

    List<Contract> findAll();

    Contract findById(Long id);

}
