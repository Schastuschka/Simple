package com.bank.account.entity;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountDetailsTest {

    @Test
    void testHashCode() {
        AccountDetails account1 = new AccountDetails(1L, 123456L, 7890L, new BigDecimal("1000.00"), false, 4567L);
        AccountDetails account2 = new AccountDetails(1L, 123456L, 7890L, new BigDecimal("1000.00"), false, 4567L);

        assertEquals(account1.hashCode(), account2.hashCode());
    }

    @Test
    void getId() {
        // Создаем экземпляр класса AccountDetails
        AccountDetails accountDetails = new AccountDetails();

        // Устанавливаем значение идентификатора
        Long expectedId = 1L;
        accountDetails.setId(expectedId);

        // Получаем значение идентификатора и сравниваем с ожидаемым значением
        Long actualId = accountDetails.getId();
        assertEquals(expectedId, actualId);
    }

    @Test
    void getAccountNumber() {
        // Создаем экземпляр класса AccountDetails
        AccountDetails accountDetails = new AccountDetails();

        // Устанавливаем значение номера счета
        Long expectedAccountNumber = 123456789L;
        accountDetails.setAccountNumber(expectedAccountNumber);

        // Получаем значение номера счета и сравниваем с ожидаемым значением
        Long actualAccountNumber = accountDetails.getAccountNumber();
        assertEquals(expectedAccountNumber, actualAccountNumber);

    }

    @Test
    void getBankDetailsId() {
        // Создаем экземпляр класса AccountDetails
        AccountDetails accountDetails = new AccountDetails();

        // Устанавливаем значение идентификатора банковских данных
        Long expectedBankDetailsId = 987654321L;
        accountDetails.setBankDetailsId(expectedBankDetailsId);

        // Получаем значение идентификатора банковских данных и сравниваем с ожидаемым значением
        Long actualBankDetailsId = accountDetails.getBankDetailsId();
        assertEquals(expectedBankDetailsId, actualBankDetailsId);
    }

    @Test
    void getMoney() {
        // Создаем экземпляр класса AccountDetails
        AccountDetails accountDetails = new AccountDetails();

        // Устанавливаем значение денежных средств
        BigDecimal expectedMoney = new BigDecimal("1000.00");
        accountDetails.setMoney(expectedMoney);

        // Получаем значение денежных средств и сравниваем с ожидаемым значением
        BigDecimal actualMoney = accountDetails.getMoney();
        assertEquals(expectedMoney, actualMoney);
    }

    @Test
    void isNegativeBalance() {
        // Создаем экземпляр класса AccountDetails
        AccountDetails accountDetails = new AccountDetails();

        // Устанавливаем значение флага negativeBalance
        boolean expectedNegativeBalance = true;
        accountDetails.setNegativeBalance(expectedNegativeBalance);

        // Проверяем, что флаг negativeBalance установлен на ожидаемое значение
        assertTrue(accountDetails.isNegativeBalance());

        // Устанавливаем значение флага negativeBalance на противоположное
        boolean expectedNegativeBalanceFalse = false;
        accountDetails.setNegativeBalance(expectedNegativeBalanceFalse);

        // Проверяем, что флаг negativeBalance установлен на ожидаемое значение
        assertFalse(accountDetails.isNegativeBalance());
    }

    @Test
    void getProfileId() {
        // Создаем экземпляр класса AccountDetails
        AccountDetails accountDetails = new AccountDetails();

        // Устанавливаем значение идентификатора профиля
        Long expectedProfileId = 1001L;
        accountDetails.setProfileId(expectedProfileId);

        // Получаем значение идентификатора профиля и сравниваем с ожидаемым значением
        Long actualProfileId = accountDetails.getProfileId();
        assertEquals(expectedProfileId, actualProfileId);
    }

    @Test
    void setId() {
        // Создаем экземпляр класса AccountDetails
        AccountDetails accountDetails = new AccountDetails();

        // Устанавливаем значение идентификатора
        Long expectedId = 1L;
        accountDetails.setId(expectedId);

        // Получаем значение идентификатора и сравниваем с ожидаемым значением
        Long actualId = accountDetails.getId();
        assertEquals(expectedId, actualId);
    }

    @Test
    void setAccountNumber() {
        // Создаем экземпляр класса AccountDetails
        AccountDetails accountDetails = new AccountDetails();

        // Устанавливаем значение номера счета
        Long expectedAccountNumber = 123456789L;
        accountDetails.setAccountNumber(expectedAccountNumber);

        // Получаем значение номера счета и сравниваем с ожидаемым значением
        Long actualAccountNumber = accountDetails.getAccountNumber();
        assertEquals(expectedAccountNumber, actualAccountNumber);
    }


    @Test
    void setBankDetailsId() {
        // Создаем экземпляр класса AccountDetails
        AccountDetails accountDetails = new AccountDetails();

        // Устанавливаем значение идентификатора банковских данных
        Long expectedBankDetailsId = 1001L;
        accountDetails.setBankDetailsId(expectedBankDetailsId);

        // Проверяем, что значение идентификатора банковских данных было успешно установлено
        Long actualBankDetailsId = accountDetails.getBankDetailsId();
        assertEquals(expectedBankDetailsId, actualBankDetailsId);
    }

    @Test
    void setMoney() {
        // Создаем экземпляр класса AccountDetails
        AccountDetails accountDetails = new AccountDetails();

        // Устанавливаем значение суммы денег
        BigDecimal expectedMoney = new BigDecimal("1000.50");
        accountDetails.setMoney(expectedMoney);

        // Проверяем, что значение суммы денег было успешно установлено
        BigDecimal actualMoney = accountDetails.getMoney();
        assertEquals(expectedMoney, actualMoney);
    }

    @Test
    void setNegativeBalance() {
        // Создаем экземпляр класса AccountDetails
        AccountDetails accountDetails = new AccountDetails();

        // Устанавливаем значение отрицательного баланса
        boolean expectedNegativeBalance = true;
        accountDetails.setNegativeBalance(expectedNegativeBalance);

        // Проверяем, что значение отрицательного баланса было успешно установлено
        boolean actualNegativeBalance = accountDetails.isNegativeBalance();
        assertEquals(expectedNegativeBalance, actualNegativeBalance);
    }

    @Test
    void setProfileId() {
        // Создаем экземпляр класса AccountDetails
        AccountDetails accountDetails = new AccountDetails();

        // Устанавливаем значение идентификатора профиля
        Long expectedProfileId = 1001L;
        accountDetails.setProfileId(expectedProfileId);

        // Проверяем, что значение идентификатора профиля было успешно установлено
        Long actualProfileId = accountDetails.getProfileId();
        assertEquals(expectedProfileId, actualProfileId);
    }
}
