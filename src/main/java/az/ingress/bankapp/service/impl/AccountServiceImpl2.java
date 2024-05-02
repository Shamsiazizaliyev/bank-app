package az.ingress.bankapp.service.impl;

import az.ingress.bankapp.dto.AccountDto;
import az.ingress.bankapp.entity.Account;
import az.ingress.bankapp.mapper.AccountMapper;
import az.ingress.bankapp.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl2 {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;



    @Transactional(propagation = Propagation.MANDATORY)
    public AccountDto updateAccountWithPropagation(Long id, Double amount) {

        Account account=  accountRepository.findById(1L).orElseThrow();
        account.setBalance(amount);
       AccountDto accountDto= accountMapper.entityToDto(account);

        return accountDto;
    }


}
