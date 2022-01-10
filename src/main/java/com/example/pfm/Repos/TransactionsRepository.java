package com.example.pfm.Repos;

import com.example.pfm.Models.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionEntity, Long> {
}
