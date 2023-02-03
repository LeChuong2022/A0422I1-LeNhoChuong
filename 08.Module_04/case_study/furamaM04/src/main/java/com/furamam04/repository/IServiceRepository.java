package com.furamam04.repository;

import com.furamam04.entity.Service;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IServiceRepository extends PagingAndSortingRepository<Service, Long> {
}
