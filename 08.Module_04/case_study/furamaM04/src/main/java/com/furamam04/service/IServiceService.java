package com.furamam04.service;

import com.furamam04.entity.Customer;
import com.furamam04.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    void save (Service service);

    void delete (Long id);

    List<Service> findAll();

    Page<Service> findAllWithPagingAndSort(Pageable pageable);

    Service findById(Long id);

}
