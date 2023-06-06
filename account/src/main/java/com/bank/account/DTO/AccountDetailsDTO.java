package com.bank.account.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Schema(name = "AccountDetailsDTO", description = "DTO объект для сущности AccountDetails")
@Table(
        name = "account_details",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"account_number", "bank_details_id"})
        }
)
public class AccountDetailsDTO implements Serializable {
    private Long id;

    @NotNull(message = "Account number is required")
    private Long accountNumber;

    @NotNull(message = "Bank details ID is required")
    private Long bankDetailsId;

    @NotNull(message = "Money amount is required")
    @PositiveOrZero(message = "Money amount must be positive or zero")
    private BigDecimal money;

    @NotNull(message = "Negative balance status is required")
    private Boolean negativeBalance;

    @NotNull(message = "Profile ID is required")
    private Long profileId;

    public boolean isNegativeBalance() {
        boolean b = false;
        return b;
    }
}
