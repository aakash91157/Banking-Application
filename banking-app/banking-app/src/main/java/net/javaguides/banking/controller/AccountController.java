package net.javaguides.banking.controller;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")

public class AccountController {

    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    //add account rest api
    @PostMapping()
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountDetail(@PathVariable Long id)
    {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.CREATED);
    }

    //deposit rest api
    @PutMapping("{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String ,Double> request)
    {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //withdraw restApi
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody  Map<String,Double> request)
    {
        double amount=request.get("amount");

        AccountDto accountdto=accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountdto);

    }

    //Status Inactive restApi
    @PutMapping("/{id}/inactive")
    public ResponseEntity<String> statusInactive(@PathVariable Long id)
    {
        accountService.userInactive(id);

        return ResponseEntity.ok("Account is Deactivated successfully");

    }

    //active api
    @PutMapping("/{id}/active")
    public ResponseEntity<String> statusActive(@PathVariable Long id)
    {
        accountService.userActive(id);
        return ResponseEntity.ok("Account id is activated successfully");
    }

    //getAllAccountRestApi
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts()
    {
        List<AccountDto> accounts=accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //delete accountApi
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount( @PathVariable Long id)
    {

           accountService.deleteAccount(id);
           return ResponseEntity.ok("Account is delete successfully");
    }
}
