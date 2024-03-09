package net.javaguides.banking.app.service;

import lombok.Getter;
import lombok.Setter;
import net.javaguides.banking.app.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id,double amount);
    AccountDto withdraw(Long id,double amount);

    List<AccountDto> getAllAccount();
}
