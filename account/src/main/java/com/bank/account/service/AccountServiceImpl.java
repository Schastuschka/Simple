package com.bank.account.service;


import com.bank.account.entity.AccountDetails;
import com.bank.account.exception.EntityNotFoundException;
import com.bank.account.repository.AccountDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountDetailsRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountDetailsRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void saveAccount(AccountDetails account) {
        log.info("Attempt to save Account");
        accountRepository.save(account);
        log.info("Saved Account successfully: id = {}", account.getId());
    }

    @Override
    public AccountDetails findAccountById(Long accountId) throws EntityNotFoundException {
        log.info("Attempt to find Account: id = {}", accountId);
        AccountDetails account = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException(AccountDetails.class.getSimpleName(), accountId));
        log.info("Account found: id = {}", accountId);
        return account;
    }

    @Override
    public void updateAccount(Long id, AccountDetails account) throws EntityNotFoundException {
        log.info("Attempt to update Account: id = {}", id);
        account.setId(id);
        accountRepository.save(account);
        log.info("Updated Account successfully: id = {}", id);
    }

    @Override
    public void deleteAccount(Long accountId) throws EntityNotFoundException {
        log.info("Attempt to delete Account: id = {}", accountId);

        try {
            accountRepository.deleteById(accountId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(AccountDetails.class.getSimpleName(), accountId, e);
        }
        log.info("Deleted Account successfully: id = {}", accountId);
    }

    @Override
    public List<AccountDetails> getAllAccounts() throws EntityNotFoundException {
        log.info("Attempt to find all Accounts");
        List<AccountDetails> allAccounts = accountRepository.findAll();

        if (allAccounts.isEmpty()) {
            throw new EntityNotFoundException(AccountDetails.class.getSimpleName());
        }
        log.info("Found all Accounts successfully, size = {}", allAccounts.size());
        return allAccounts;
    }
}

