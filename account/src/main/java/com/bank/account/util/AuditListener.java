package com.bank.account.util;

import com.bank.account.entity.AccountDetails;
import com.bank.account.entity.Audit;
import com.bank.account.entity.RevInfo;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionListener;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class AuditListener implements RevisionListener {

    @Override
    @Transactional
    public void newRevision(Object o) {
        EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        AuditQuery auditQuery = AuditReaderFactory.get(entityManager).createQuery()
                .forRevisionsOfEntity(AccountDetails.class, false, true);
        List<Object[]> resultList = auditQuery.getResultList();
        Object[] resultArr = resultList.get(resultList.size() - 1);
        AccountDetails modifyAccountDetails = (AccountDetails) resultArr[0];
        RevInfo revInfo = (RevInfo) resultArr[1];
        RevisionType revisionType = (RevisionType) resultArr[2];
        revInfo.setUsername("User");

        Audit audit = new Audit();

        ZonedDateTime zonedDateTimeOfRevision = ZonedDateTime.ofInstant(Instant.ofEpochMilli(revInfo.getTimestamp()),
                ZoneId.systemDefault());
        audit.setEntityType(modifyAccountDetails.getClass().getSimpleName());
        audit.setOperationType(revisionType.toString());
        if (revisionType.toString().equals("MOD")) {
            audit.setNewEntityJson(modifyAccountDetails.toString());
            audit.setModifiedAt(zonedDateTimeOfRevision.toLocalDateTime());
            audit.setModifiedBy(revInfo.getUsername());
            audit.setEntityJson(resultList.get(resultList.size() - 2)[0].toString());
        } else {
            audit.setEntityJson(modifyAccountDetails.toString());
        }
        audit.setCreatedBy(revInfo.getUsername());
        audit.setCreatedAt(zonedDateTimeOfRevision.toLocalDateTime());
        audit.setRevInfo(revInfo);
        entityManager.persist(audit);
        revInfo.setAudit(audit);
    }
}


