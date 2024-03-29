package az.ingress.bankapp.repository;



import az.ingress.bankapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
   Optional<Account> findByAccountNumber(String accoountNumber);


   @Query("select a from Account a join fetch a.user u join fetch a.cards c where a.id=1L")
   Optional<Account> findByCustom();

}
