package com.furamam04.repository;

import com.furamam04.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    @Query(value = "select c from Customer as c where c.name like %:search% or c.idCard like %:search% or c.phone like %:search%")
    Page<Customer> findAllWithPagingAndSortAndSearch(String search, Pageable pageable);

    //    Câu query join contract
    @Query(value = "select cu from Contract as co left join Customer as cu on cu.id = co.customer.id group by cu.id")
    Page<Customer> findAllJoinContract(Pageable pageable);

    @Query(value = "select cu from Contract as co left join Customer as cu on cu.id = co.customer.id where cu.name like %:search% or cu.idCard like %:search% or cu.phone like %:search% group by cu.id")
    Page<Customer> findAllJoinContractWithSearch(String search, Pageable pageable);
//    Page<Customer> findAllByNameContainingOrIdCardContainingOrPhoneContaining(String name, String idCard, String phone, Pageable pageable);

    //    Select hết cu
//    @Query(value = "select cu from Contract as co left join Customer as cu on cu.id = co.customer.id " +
//            "left join ContractDetail as coD on co.id = coD.contract.id " +
//            "left join AttachService  as at on at.id = coD.attachService.id ")
//    List<Customer> findAllJoinContractTotalMoney();

// tính tổng tiền hợp đồng
    @Query(value = "select sum(co.contractTotalMoney) from Contract as co left join Customer as cu on cu.id = co.customer.id group by cu.id")
    List<Double> calTotal();


}
