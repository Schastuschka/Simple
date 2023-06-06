package com.bank.account.service;

import com.bank.account.entity.Audit;

import java.util.List;

public interface AuditService {
    void saveAudit(Audit audit);

    Audit findAuditById(Long auditId);

    void editAudit(Long id, Audit audit);

    void deleteAudit(Long auditId);

    List<Audit> getAllAudit();
}
