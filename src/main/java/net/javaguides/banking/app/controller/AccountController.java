package net.javaguides.banking.app.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.banking.app.dto.AccountDto;
import net.javaguides.banking.app.service.AccountService;
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
    private ObjectMapper objectMapper;
    private AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

//    add account rest api
    @PostMapping("")
    public ResponseEntity<AccountDto> addAccount(@RequestBody String accountDtoString){

        try {
            AccountDto accountDto = objectMapper.readValue(accountDtoString, new TypeReference<AccountDto>() {
            });
            return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body(null);

    }


// get account rest api
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto= accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //deposit Rest Api
@PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
          Double amount=request.get("amount");
        AccountDto accountDto=accountService.deposit(id,amount);
        return  ResponseEntity.ok(accountDto);


    }

    @PutMapping("/{id}/transaction")
    public ResponseEntity<AccountDto> transaction(@PathVariable Long id, @RequestBody Map<String,Double> request){

        if (request.containsKey("deposit")) {
            Double amount=request.get("deposit");
            AccountDto accountDto=accountService.deposit(id,amount);
            return  ResponseEntity.ok(accountDto);
        }
        if (request.containsKey("withdraw")) {
            Double amount=request.get("withdraw");
            AccountDto accountDto=accountService.withdraw(id,amount);
            return  ResponseEntity.ok(accountDto);
        }

        return ResponseEntity.badRequest().build();

    }

    //withdraw rest api
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        AccountDto accountDto=accountService.withdraw(id,amount);
        return  ResponseEntity.ok(accountDto);
    }

    //getAllAccount rest api

    @GetMapping
    public ResponseEntity<List<AccountDto>>getAllAccount(){
        List<AccountDto> accounts =accountService.getAllAccount();
        return ResponseEntity.ok(accounts);
    }

}
