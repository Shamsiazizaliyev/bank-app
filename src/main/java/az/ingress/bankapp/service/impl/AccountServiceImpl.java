package az.ingress.bankapp.service.impl;

import az.ingress.bankapp.dto.AccountDto;
import az.ingress.bankapp.entity.Account;
import az.ingress.bankapp.mapper.AccountMapper;
import az.ingress.bankapp.repository.AccountRepository;
import az.ingress.bankapp.service.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {



    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    private final AccountServiceImpl2 accountServiceImpl2;


    @Override
    public List<Account> getAccountDto() {
        return null;
    }

    @Override
    @Transactional
    public AccountDto getAccount(Long id) {
        System.err.println("Begin get"+Thread.currentThread().getName());
      Account account= accountRepository.findById(id).orElseThrow();
      AccountDto accountDto=accountMapper.entityToDto(account);
        System.err.println("End get"+Thread.currentThread().getName());

        return accountDto;
    }

    @Override
    @Transactional

    public AccountDto updateAccount(Long id, Double amount) {
        System.err.println("Begin update"+Thread.currentThread().getName());
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        account.setBalance(account.getBalance() - amount);
        AccountDto accountDto = accountMapper.entityToDto(account);
        accountRepository.save(account);
        System.err.println("Begin update"+Thread.currentThread().getName());
        return accountDto;

    }

    @Override
    @SneakyThrows
    @Transactional
    public AccountDto updateAccountWithWait(Long id, Double amount) {
        System.err.println("Begin update wait"+Thread.currentThread().getName());
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        account.setBalance(account.getBalance() - amount);
        Thread.sleep(5000);
        AccountDto accountDto = accountMapper.entityToDto(account);
        System.err.println("Begin update wait"+Thread.currentThread().getName());


        return accountDto;

    }

    @Override
    @Transactional
    public AccountDto updateAccountWithPropagation(Long id, Double amount) {

        amount+=amount;
        return accountServiceImpl2.updateAccountWithPropagation(id,amount);
    }


}
