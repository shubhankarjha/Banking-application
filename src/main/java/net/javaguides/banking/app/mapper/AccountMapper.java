package net.javaguides.banking.app.mapper;

import net.javaguides.banking.app.dto.AccountDto;
import net.javaguides.banking.app.entity.Account;


public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){

        return Account.builder().id(accountDto.getId())
                .accountHolderName(accountDto.getAccountHolderName())
                .balance(accountDto.getBalance()).build();
    }

    public static AccountDto mapToAccountDto(Account account){
        return AccountDto.builder().id(account.getId())
                .accountHolderName(account.getAccountHolderName())
                .balance(account.getBalance()).build();
    }


}
