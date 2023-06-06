package com.bank.account.service;


import com.bank.account.entity.AccountDetails;
import com.bank.account.exception.EntityNotFoundException;

import java.util.List;

public interface AccountService {
    void saveAccount(AccountDetails account);

    AccountDetails findAccountById(Long accountId) throws EntityNotFoundException;

    void updateAccount(Long id, AccountDetails account) throws EntityNotFoundException;

    void deleteAccount(Long accountId) throws EntityNotFoundException;

    List<AccountDetails> getAllAccounts() throws EntityNotFoundException;
}

