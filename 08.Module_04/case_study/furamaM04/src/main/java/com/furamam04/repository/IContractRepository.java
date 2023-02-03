package com.furamam04.repository;

import com.furamam04.entity.Contract;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IContractRepository extends PagingAndSortingRepository<Contract, Long> {
}
