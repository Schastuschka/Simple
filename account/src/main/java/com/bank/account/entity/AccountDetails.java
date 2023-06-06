package com.bank.account.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.math.BigDecimal;

@Slf4j
@Entity(name = "account_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Audited
@Schema(name = "AccountDetails", description = "Сущность, содержащая информацию о деталях банковского счета.")
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "bank_details_id")
    private Long bankDetailsId;

    @Column(name = "money", precision = 20, scale = 2)
    private BigDecimal money;

    @Column(name = "negative_balance")
    private boolean negativeBalance;

    @Column(name = "profile_id")
    private Long profileId;
}
