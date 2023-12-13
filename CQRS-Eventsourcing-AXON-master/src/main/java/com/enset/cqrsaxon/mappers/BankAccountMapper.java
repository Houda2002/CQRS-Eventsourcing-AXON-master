package com.enset.cqrsaxon.mappers;

import com.enset.cqrsaxon.queries.dto.AccountOperationResponseDTO;
import com.enset.cqrsaxon.queries.dto.BankAccountResponseDTO;
import com.enset.cqrsaxon.queries.entities.AccountOperation;
import com.enset.cqrsaxon.queries.entities.BankAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {
    BankAccountResponseDTO bankAccountToBankAccountDTO(BankAccount bankAccount);
    AccountOperationResponseDTO accountOperationToAccountOperationDTO(AccountOperation accountOperation);
}
