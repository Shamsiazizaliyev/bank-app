package az.ingress.bankapp.controller;


import az.ingress.bankapp.dto.AccountDto;
import az.ingress.bankapp.entity.Account;
import az.ingress.bankapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accouts")
public class AccountController {
    private final AccountService accountService;

    public List<Account> getAccountDto() {

        return accountService.getAccountDto();
    }
    @GetMapping("/{id}")

    public AccountDto getAccount(@PathVariable Long id){
        return accountService.getAccount(id);
    }
    @PutMapping("/{id}")
    public AccountDto updateAccount(@PathVariable Long id,
                                    @RequestParam Double amount) {
        return    accountService.updateAccount(id, amount);
    }
    @PutMapping("/wait/{id}")
    public AccountDto updateAccountWait(@PathVariable Long id, @RequestParam Double amount) {
        return    accountService.updateAccountWithWait(id, amount);
    }



    @GetMapping("/propagation/{id}")
    public AccountDto updateAccountWithPropagation(@PathVariable Long id, @RequestParam Double amount) {
        return  accountService.updateAccountWithPropagation(id, amount);
    }
}
