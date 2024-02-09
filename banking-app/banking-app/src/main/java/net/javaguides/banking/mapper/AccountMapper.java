package net.javaguides.banking.mapper;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.enums.ProfileStatus;


import java.util.Date;
import java.util.Optional;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto) {

        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance(),
                accountDto.getAccountType(),
                accountDto.getEmail(),
                accountDto.getPhoneNumber(),
                accountDto.getPanCard(),
                accountDto.getAadharCard()
        );

        account.setAccountOpened(new Date());
        account.setStatus(ProfileStatus.IS_ACTIVE);
        return account;
    }


    public static AccountDto mapToAccountDto(Account account)
    {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance(),
                account.getAccountType(),
                account.getEmail(),
                account.getPhoneNumber(),
                account.getPanCard(),
                account.getAadharCard()
        );
       accountDto.setId(accountDto.getId());
       accountDto.setUpdateAt(new Date());
       accountDto.setAccountOpened(new Date());
       return accountDto;
    }
}
