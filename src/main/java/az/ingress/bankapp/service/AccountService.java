package az.ingress.bankapp.service;


import az.ingress.bankapp.dto.AccountDto;
import az.ingress.bankapp.entity.Account;

import java.util.List;

public interface AccountService {
     List<Account> getAccountDto();

     AccountDto getAccount(Long id);

     AccountDto updateAccount(Long id, Double amount);
     AccountDto updateAccountWithWait( Long id, Double amount);
     AccountDto updateAccountWithPropagation( Long id, Double amount);

}
