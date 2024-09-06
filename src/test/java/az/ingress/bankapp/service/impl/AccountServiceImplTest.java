package az.ingress.bankapp.service.impl;

import az.ingress.bankapp.dto.AccountDto;
import az.ingress.bankapp.entity.Account;
import az.ingress.bankapp.mapper.AccountMapper;
import az.ingress.bankapp.repository.AccountRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

class AccountServiceImplTest {

    @InjectMocks // abyekti yaradir
    private AccountServiceImpl accountService;

    @Mock // fake datalar yaradir
    private AccountRepository accountRepository;


    @Mock
    private AccountMapper accountMapper;

    @Mock
    private AccountServiceImpl2 accountServiceImpl2;
    @Mock

    private Account account;
    @Mock
    private AccountDto accountDto;

    String st=null;


    @Before("test")
    void setUpp(){

        st="sout";
        System.out.println("sagol");

    }
    @BeforeEach
    void setUp(){
        //arange
        this.account=new Account();
        account.setAccountNumber("iba1234");
        account.setBalance(800);
        account.setId(1l);

        this.accountDto=new AccountDto();
        accountDto.setId(1L);
        accountDto.setAccountNumber("iba1234");
        accountDto.setBalance(500);

    }



    @Test
    void getAccountDto() {

        System.out.println(st);

        when(accountRepository.findById(1l)).thenReturn(Optional.of(account));
        when(accountMapper.entityToDto(account)).thenReturn(accountDto);

        //asert
        assertEquals(accountDto.getAccountNumber(),accountService.getAccount(1L).getAccountNumber());
    }
    @Test
    void updateAccount() {
        when(accountRepository.findById(1l)).thenReturn(Optional.of(this.account));
        when(accountMapper.entityToDto(this.account)).thenReturn(this.accountDto);
        AccountDto result = accountService.updateAccount(1L, 300.00);
        //  verify(accountService, times(1)).updateAccount(1l, 300.00);
        verify(accountRepository, times(1)).save(any());

    }


}