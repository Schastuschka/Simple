package com.bank.account.mapper;

import com.bank.account.DTO.AccountDetailsDTO;
import com.bank.account.entity.AccountDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


@Mapper
public interface AccountDetailsMapper {

    AccountDetailsMapper INSTANCE = Mappers.getMapper(AccountDetailsMapper.class);

    @Mapping(target = "negativeBalance", source = "negativeBalance")
    AccountDetailsDTO accountDetailsToDto(AccountDetails accountDetails);

    @Mapping(target = "negativeBalance", expression = "java(accountDetailsDTO.isNegativeBalance())")
    AccountDetails accountDetailsDtoToEntity(AccountDetailsDTO accountDetailsDTO);

    void updateEntityFromDto(AccountDetailsDTO dto, @MappingTarget AccountDetails entity);
}

