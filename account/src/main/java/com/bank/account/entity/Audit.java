package com.bank.account.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.LocalDateTime;


    @Entity(name = "audit")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode

    @Schema(name = "Audit", description = "Сущность, объекты которой сохраняют в бд все CRUD операции с основными сущностями.")
    public class Audit {

        private static final Logger LOGGER = LoggerFactory.getLogger(com.bank.account.entity.Audit.class);

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "entity_type", length = 40)
        @NotBlank
        private String entityType;

        @Column(name = "operation_type", length = 255)
        @NotBlank
        private String operationType;

        @Column(name = "created_by", length = 255)
        private String createdBy;

        @Column(name = "modified_by", length = 255)
        private String modifiedBy;

        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @Column(name = "modified_at")
        private LocalDateTime modifiedAt;

        @Column(name = "new_entity_json", columnDefinition = "TEXT")
        private String newEntityJson;

        @Column(name = "entity_json", columnDefinition = "TEXT")
        @NotBlank
        private String entityJson;

        @OneToOne(mappedBy = "audit")
        private RevInfo revInfo;

        public void setRevInfo(RevInfo revInfo) {
            this.revInfo = revInfo;
        }

}
