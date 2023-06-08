package com.bank.account.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "AuditDTO", description = "DTO объект для Audit")
public class AuditDTO {
    private Long id;

    @NotBlank(message = "Entity type must not be blank")
    private String entityType;

    @NotBlank(message = "Operation type must not be blank")
    private String operationType;

    private String createdBy;
    private String modifiedBy;

    @NotNull(message = "Created at must not be null")
    private ZonedDateTime createdAt;

    @NotNull(message = "Modified at must not be null")
    private ZonedDateTime modifiedAt;

    private String newEntityJson;

    @NotBlank(message = "Entity JSON must not be blank")
    private String entityJson;
}