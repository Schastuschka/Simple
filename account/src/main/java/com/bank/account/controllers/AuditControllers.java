package com.bank.account.controllers;

import com.bank.account.DTO.AuditDTO;
import com.bank.account.exception.ArgumentNotValidException;
import com.bank.account.mapper.AuditMapper;
import com.bank.account.service.AuditService;
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

@RestController
@RequestMapping("/audits")
@Tag(name = "AuditControllers", description = "REST контролер для сущности Audit (объект Audit представляет собой " +
        "запись CRUD операции с основными сущностями).")
public class AuditControllers {
    private final AuditService auditService;

    @Autowired
    public AuditControllers(AuditService auditService) {

        this.auditService = auditService;
    }

    @GetMapping("/")
    @Operation(
            summary = "Получение всех объектов Audit в формате AuditDTO.",
            description = "Получение всех объектов AuditDTO. В методе через Stream.api каждый объект " +
                    "Audit приводится к AuditDTO."
    )
    public ResponseEntity<List<AuditDTO>> getAllAudit() {
        List<AuditDTO> allAuditDTO;

        allAuditDTO = auditService
                .getAllAudit()
                .stream()
                .map(AuditMapper.INSTANCE::toAuditDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allAuditDTO, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получение конкретного объекта Audit в формате AuditDTO, через его id.",
            description = "Получение объекта AuditDTO через audit.id."
    )
    public ResponseEntity<AuditDTO> getAudit(@PathVariable Long id) {
        AuditDTO auditDTO = AuditMapper
                .INSTANCE
                .toAuditDTO(auditService.findAuditById(id));
        System.out.println(123456);
        System.out.println("createdBy: " + auditDTO.getCreatedBy());
        System.out.println("modifiedBy: " + auditDTO.getModifiedBy());

        return new ResponseEntity<>(auditDTO, HttpStatus.FOUND);
    }


    @PostMapping
    @Operation(
            summary = "Сохранение в бд нового объекта Audit.",
            description = "Сохранение в бд нового объекта Audit."
    )
    public ResponseEntity<AuditDTO> createAudit(@RequestBody @Valid AuditDTO auditDTO,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ArgumentNotValidException(bindingResult);
        }
        auditService.saveAudit( AuditMapper.INSTANCE.toAudit(auditDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Обновление существующего объекта Audit.",
            description = "Обновление существующего объекта Audit."
    )
    public ResponseEntity<AuditDTO> editAudit(@PathVariable Long id,
                                              @RequestBody @Valid AuditDTO auditDTO,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ArgumentNotValidException(bindingResult);
        }

        auditService.editAudit(id,
                AuditMapper.INSTANCE.toAudit(auditDTO));

        return new ResponseEntity<>(auditDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удаление существующего объекта Audit.",
            description = "Удаление существующего объекта Audit через audit.id."
    )
    public ResponseEntity<HttpStatus> deleteAudit(@PathVariable Long id) {
        auditService.deleteAudit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
