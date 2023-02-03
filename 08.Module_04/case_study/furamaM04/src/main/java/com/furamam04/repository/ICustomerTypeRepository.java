package com.furamam04.repository;

import com.furamam04.entity.CustomerType;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerTypeRepository extends CrudRepository<CustomerType, Long> {
}
