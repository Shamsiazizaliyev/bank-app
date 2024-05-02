package az.ingress.bankapp.service.impl;

import az.ingress.bankapp.dto.AccountDto;
import az.ingress.bankapp.entity.Ac;
import az.ingress.bankapp.entity.Account;
import az.ingress.bankapp.repository.Are;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class Addimpl {


    private final Are are;
    @Transactional
    public Ac getAcc(Long id) {
        System.err.println("Begin get"+Thread.currentThread().getName());
        Ac ac= are.findById(id).orElseThrow();
        System.err.println("End get"+Thread.currentThread().getName());

        return ac;
    }


    @Transactional

    public Ac updateAccount(Long id, Double amount) {
        System.err.println("Begin update"+Thread.currentThread().getName());
        Ac ac = are.findById(id).orElseThrow(() -> new IllegalArgumentException());
        ac.setBalance(ac.getBalance() - amount);
        System.err.println("Begin update"+Thread.currentThread().getName());
        return ac;

    }
    @SneakyThrows
    @Transactional

    public Ac updateAccountWithWait(Long id, Double amount) {
        System.err.println("Begin update wait"+Thread.currentThread().getName());
        Ac ac = are.findById(id).orElseThrow(() -> new IllegalArgumentException());
        ac.setBalance(ac.getBalance() - amount);
        Thread.sleep(5000);

        System.err.println("Begin update wait"+Thread.currentThread().getName());


        return ac;

    }
}
