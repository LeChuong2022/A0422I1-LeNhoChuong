package com.phone_management.repository;

import com.phone_management.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ISmartphoneRepository extends JpaRepository<Smartphone, Long> {
}
