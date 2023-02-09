package com.mehdilagdimi.itsgovhealthcareservice.repository;

import com.mehdilagdimi.itsgovhealthcareservice.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
