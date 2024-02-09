package net.javaguides.banking.service;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.enums.ProfileStatus;
import net.javaguides.banking.mapper.AccountMapper;
import net.javaguides.banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Optional<Account> optionalAccount = accountRepository.findByIdAndStatus(id, ProfileStatus.IS_ACTIVE);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            return AccountMapper.mapToAccountDto(account);
        } else {
            throw new RuntimeException("No user exists or User deactivated!");
        }
    }

    @Override
    public AccountDto deposit(Long id, double money) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("User Does not exist ! Open a Bank Account first !"));
        double total =+ account.getBalance() + money;
        account.setBalance(total);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double money) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("User Does not exist ! Open a Bank Account first !"));
       if(account.getBalance() < money)
       {
           throw new RuntimeException("Insufficient amount");
       }
       double total = account.getBalance() - money;
       account.setBalance(total);
       Account savedAccount= accountRepository.save(account);
       return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
       List<Account> accounts = accountRepository.findAllByStatus(ProfileStatus.IS_ACTIVE);

       //because list has stream method
       return  accounts.stream()
               .map(AccountMapper::mapToAccountDto)
               .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("User Does not exist ! Open a Bank Account first !"));
        account.setStatus(ProfileStatus.IN_ACTIVE);
        accountRepository.save(account);
    }

    @Override
    public void userInactive(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("User Does not exist ! Open a Bank Account first !"));
        account.setStatus(ProfileStatus.IN_ACTIVE);
        accountRepository.save(account);

    }

    @Override
    public void userActive(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("User Does not exist ! Open a bank Account first !"));
        account.setStatus(ProfileStatus.IS_ACTIVE);
        accountRepository.save(account);
    }


}

    // user check krna hai exist krta hai ya nahi
    // if user exist toh update bank balance to user account at particular id
    // return to dto

    // Other service methods...

