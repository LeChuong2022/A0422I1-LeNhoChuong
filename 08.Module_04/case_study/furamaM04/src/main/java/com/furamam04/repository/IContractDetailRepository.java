package com.furamam04.repository;

import com.furamam04.entity.ContractDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IContractDetailRepository extends CrudRepository<ContractDetail, Long> {
    @Modifying
    void deleteAllByContract_Id(Long id);
}
