package com.bank.account.repository;

import com.bank.account.repository.AccountDetailsRepository;
import com.bank.account.entity.AccountDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AccountDetailsRepositoryTest {

    @Autowired
    private AccountDetailsRepository accountDetailsRepository;

    @Test
    void testSaveAccountDetails() {
        // Создаем экземпляр AccountDetails
        AccountDetails accountDetails = new AccountDetails();
        // Задаем значения свойств accountDetails

        // Сохраняем accountDetails в репозиторий
        AccountDetails savedAccountDetails = accountDetailsRepository.save(accountDetails);

        // Проверяем, что accountDetails был успешно сохранен
        assertNotNull(savedAccountDetails.getId());
    }

    @Test
    void testFindAccountDetailsById() {
        // Создаем тестовый AccountDetails
        AccountDetails accountDetails = new AccountDetails();
        // Задаем значения свойств accountDetails

        // Сохраняем accountDetails в репозиторий
        AccountDetails savedAccountDetails = accountDetailsRepository.save(accountDetails);

        // Ищем accountDetails по его id
        AccountDetails foundAccountDetails = accountDetailsRepository.findById(savedAccountDetails.getId())
                .orElse(null);

        // Проверяем, что accountDetails был найден
        assertNotNull(foundAccountDetails);
        assertEquals(savedAccountDetails.getId(), foundAccountDetails.getId());
    }

    // Добавьте другие тесты по необходимости

}
