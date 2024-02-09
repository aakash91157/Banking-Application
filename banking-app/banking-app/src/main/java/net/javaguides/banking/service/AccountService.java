package net.javaguides.banking.service;

import net.javaguides.banking.dto.AccountDto;

import java.util.List;

public interface AccountService {

  AccountDto createAccount(AccountDto accountDto);

  AccountDto getAccountById(Long id);

  AccountDto deposit(Long id, double money);

  AccountDto withdraw(Long id,double money);

  List<AccountDto> getAllAccounts();

  void  deleteAccount(Long id);

  void userInactive(Long id);

  void userActive(Long id);
}
