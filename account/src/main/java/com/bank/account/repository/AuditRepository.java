package com.bank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.account.entity.Audit;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {

}