package com.enset.cqrsaxon.queries.repository;

import com.enset.cqrsaxon.queries.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
