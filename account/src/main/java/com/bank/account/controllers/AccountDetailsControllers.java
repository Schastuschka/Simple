package com.bank.account.controllers;

import com.bank.account.DTO.AccountDetailsDTO;
import com.bank.account.exception.ArgumentNotValidException;
import com.bank.account.mapper.AccountDetailsMapper;
import com.bank.account.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для управления объектами AccountDetails.
 * Обеспечивает выполнение операций CRUD (Create, Read, Update, Delete) над объектами AccountDetails.
 */

@RestController
@RequestMapping("/account_details")
@Tag(name = "AccountDetailsControllers", description = "REST контролер для сущности Audit (объект Audit представляет" +
        " собой запись CRUD операции с основными сущностями).")
public class AccountDetailsControllers {


    private final AccountService accountService;
    /**
     * Конструктор контроллера AccountDetailsControllers.
     *
     * @param accountService сервис для работы с объектами AccountDetails
     */
    @Autowired
    public AccountDetailsControllers(AccountService accountService) {
        this.accountService = accountService;
    }


    /**
     * Получение всех объектов AccountDetails в формате AccountDetailsDTO.
     *
     * @return список объектов AccountDetailsDTO
     */
    @GetMapping("/")
    @Operation(
            summary = "Получение всех объектов AccountDetails в формате AccountDetailsDTO.",
            description = "Получение всех объектов AccountDetailsDTO. В методе через stream.api каждый объект " +
                    "AccountDetails приводится к AccountDetailsDTO."
    )
    public ResponseEntity<List<AccountDetailsDTO>>getAllAccounts() {
        List<AccountDetailsDTO>allAccountDetailsDTO;

        allAccountDetailsDTO =  accountService
                .getAllAccounts()
                .stream()
                .map(AccountDetailsMapper.INSTANCE::accountDetailsToDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allAccountDetailsDTO, HttpStatus.FOUND);
    }
    /**
     * Получение конкретного объекта AccountDetails в формате AccountDetailsDTO по его идентификатору.
     *
     * @param id идентификатор объекта AccountDetails
     * @return объект AccountDetailsDTO
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Получение конкретного объекта AccountDetails в формате AccountDetailsDTO, через его id.",
            description = "Получение объекта AccountDetailsDTO через account_details.id."
    )
    public ResponseEntity<AccountDetailsDTO>getAccountDetails(@PathVariable Long id) {
        AccountDetailsDTO accountDetailsDTO = AccountDetailsMapper
                .INSTANCE.accountDetailsToDto(accountService.findAccountById(id));
        return new ResponseEntity<>(accountDetailsDTO, HttpStatus.FOUND);
    }
    /**
     * Сохранение нового объекта AccountDetails в базе данных.
     *
     * @param accountDetailsDTO  Объект AccountDetailsDTO для сохранения.
     * @param bindingResult      Объект BindingResult для проверки валидации данных.
     * @return Объект ResponseEntity с HttpStatus.CREATED в случае успешного сохранения.
     * @throws ArgumentNotValidException В случае, если данные не прошли валидацию.
     */
    @PostMapping
    @Operation(
            summary = "Сохранение в бд нового объекта AccountDetails.",
            description = "Сохранение в бд нового объекта AccountDetails."
    )
    public ResponseEntity<AccountDetailsDTO>createAccount(@RequestBody @Valid AccountDetailsDTO accountDetailsDTO,
                                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ArgumentNotValidException(bindingResult);
        }
        accountService.saveAccount(AccountDetailsMapper.INSTANCE.accountDetailsDtoToEntity(accountDetailsDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    /**
     * Обновление существующего объекта AccountDetails.
     *
     * @param id                 Идентификатор объекта AccountDetails для обновления.
     * @param accountDetailsDTO  Объект AccountDetailsDTO с обновленными данными.
     * @param bindingResult      Объект BindingResult для проверки валидации данных.
     * @return Объект ResponseEntity с обновленным AccountDetailsDTO в теле ответа и HttpStatus.CREATED.
     * @throws ArgumentNotValidException В случае, если данные не прошли валидацию.
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Обновление существующего объекта AccountDetails.",
            description = "Обновление существующего объекта AccountDetails."
    )
    public ResponseEntity<AccountDetailsDTO>updateAccount(@PathVariable Long id,
                                                          @RequestBody @Valid AccountDetailsDTO accountDetailsDTO,
                                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ArgumentNotValidException(bindingResult);
        }
        accountService.updateAccount(id, AccountDetailsMapper.INSTANCE.accountDetailsDtoToEntity(accountDetailsDTO));
        return new ResponseEntity<>(accountDetailsDTO, HttpStatus.CREATED);
    }
    /**
     * Удаление существующего объекта AccountDetails по его идентификатору.
     *
     * @param id Идентификатор объекта AccountDetails для удаления.
     * @return Объект ResponseEntity с HttpStatus.NO_CONTENT в случае успешного удаления.
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удаление существующего объекта AccountDetails.",
            description = "Удаление существующего объекта AccountDetails через account_details.id."
    )
    public ResponseEntity<HttpStatus>deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
