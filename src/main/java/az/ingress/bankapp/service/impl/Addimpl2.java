package az.ingress.bankapp.service.impl;

import az.ingress.bankapp.dto.AccountDto;
import az.ingress.bankapp.entity.Ac;
import az.ingress.bankapp.entity.Account;
import az.ingress.bankapp.repository.Are;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class Addimpl2 {


    private final Are are;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Ac updateAccountWithPropagation(Long id, Double amount) {

        log.info("method 2");
        System.out.println("m 2 begin");
        Ac account=  are.findById(1L).orElseThrow();
        account.setBalance(amount);
        System.out.println("m 2 end");


        return account;
    }

}
