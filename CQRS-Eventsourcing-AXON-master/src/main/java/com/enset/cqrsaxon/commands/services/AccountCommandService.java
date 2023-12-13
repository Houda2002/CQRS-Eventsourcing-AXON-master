package com.enset.cqrsaxon.commands.services;

import com.enset.cqrsaxon.commands.dto.CreateAccountRequestDTO;
import com.enset.cqrsaxon.commands.dto.CreditAccountRequestDTO;
import com.enset.cqrsaxon.commands.dto.DebitAccountRequestDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {
    CompletableFuture<String> createAccount(CreateAccountRequestDTO accountRequestDTO);
    CompletableFuture<String> debitAccount(DebitAccountRequestDTO debitAccountRequestDTO);
    CompletableFuture<String> creditAccount(CreditAccountRequestDTO creditAccountRequestDTO);
}
