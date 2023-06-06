package com.bank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.account.entity.AccountDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {
}