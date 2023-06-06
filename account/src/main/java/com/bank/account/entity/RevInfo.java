package com.bank.account.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import com.bank.account.util.AuditListener;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@RevisionEntity(AuditListener.class)
@Table(name = "REVINFO", schema = "account")

public class RevInfo {

    @Id
    @RevisionNumber
    @GeneratedValue (generator = "CustomerAuditRevisionSeq")
    @SequenceGenerator(name = "CustomerAuditRevisionSeq", sequenceName = "customer_audit_revision_seq", schema = "account",
    allocationSize = 1)
    private int id;

    @RevisionTimestamp
    private long timestamp;

    private String username;

    @OneToOne
    @JoinColumn( name = "audit_id", referencedColumnName = "id")
    private Audit audit;
}
