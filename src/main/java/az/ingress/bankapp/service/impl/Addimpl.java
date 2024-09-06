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

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class Addimpl {


    private final Are are;
    private final  Addimpl2 addimpl2;
    @Transactional
    public Ac getAcc(Long id) {
        System.err.println("Begin get"+Thread.currentThread().getName());
        Ac ac= are.findById(id).orElseThrow();
        System.err.println("End get"+Thread.currentThread().getName());

        return ac;
    }


    @Transactional

    public Ac updateAccount(Long id, Double amount) {

        log.info("method start");
     // if  (amount == 1) throw new RuntimeException("xeta bas verdi");
     //   System.err.println("Begin update"+Thread.currentThread().getName());
        Ac ac = are.findById(id).orElseThrow(() -> new IllegalArgumentException());
        ac.setBalance(ac.getBalance() - amount);
     //   System.err.println("endd update"+Thread.currentThread().getName());
        log.info("update");
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

  @Transactional(propagation = Propagation.REQUIRED)
    public Ac updateAccountWithPropagation(Long id, Double amount) {


        log.info("method 1");
       System.out.println("m 1 begin");
        amount+=amount;
      Ac ac=addimpl2.updateAccountWithPropagation(id,amount);
      Random random=new Random();
      boolean c=random.nextBoolean();
      System.out.println("c= "+c);
      if(c){
          throw new RuntimeException(" xeta atdi");
      }
        return ac;
    }

}
