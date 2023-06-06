package com.bank.account.mapper;



import com.bank.account.DTO.AuditDTO;
import com.bank.account.entity.Audit;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuditMapper {

    AuditMapper INSTANCE = Mappers.getMapper(AuditMapper.class);

    AuditDTO toAuditDTO(Audit audit);

    Audit toAudit(AuditDTO auditDTO);
}


