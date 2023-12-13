package com.enset.cqrsaxon.commands.controllers;

import com.enset.cqrsaxon.commands.dto.CreateAccountRequestDTO;
import com.enset.cqrsaxon.commands.dto.CreditAccountRequestDTO;
import com.enset.cqrsaxon.commands.dto.DebitAccountRequestDTO;
import com.enset.cqrsaxon.commands.excepetions.InsufficientBalanceException;
import com.enset.cqrsaxon.commands.services.AccountCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path="/commands")
public class AccountCommandRestController {

    private final AccountCommandService accountCommandService;

    public AccountCommandRestController(AccountCommandService accountCommandService) {
        this.accountCommandService = accountCommandService;
    }
    @PostMapping(path = "/accounts/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateAccountRequestDTO accountRequestDTO){
       return accountCommandService.createAccount(accountRequestDTO);
    }
    @PutMapping(path = "/accounts/debit")
    public CompletableFuture<String> debitAccount(@RequestBody DebitAccountRequestDTO debitAccountRequestDTO){
        return accountCommandService.debitAccount(debitAccountRequestDTO);
    }
    @PutMapping(path = "/accounts/credit")
    public CompletableFuture<String> creditAccount(@RequestBody CreditAccountRequestDTO creditAccountRequestDTO){
        return accountCommandService.creditAccount(creditAccountRequestDTO);
    }
    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<String> exceptionHandler(InsufficientBalanceException exception){
        return new ResponseEntity<String>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
