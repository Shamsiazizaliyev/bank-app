package az.ingress.bankapp.repository;



import az.ingress.bankapp.dto.AccountDto;
import az.ingress.bankapp.entity.Account;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Override
    Optional<Account> findById(Long aLong);

     Account findByBalance(double balance);

   @Query("select a from Account a join fetch a.user u join fetch u.address ad join fetch a.cards c join fetch c.benefits b")
   List<Account> findByCustom(); //hamsi ucun umumi bir join atir qeyd burada list icinde list yazmaq olmur set ist etmek lazim

   @Query("select a from Account a")
   Set<Account> findByCust();// findAll ile eyni selecti atir


   @Query(value = "\n" +
           "  SELECT a.id  account_id, u.id  user_id, c.id  card_id, b.id Abenefit_id\n" +
           "               FROM banks.accounts a\n" +
           "               JOIN banks.user u ON u.id = a.user_id\n" +
           "               JOIN banks.card c ON a.id = c.account_id\n" +
           "               JOIN banks.card_benefit b ON c.id = b.card_id;", nativeQuery = true)
   List<Account> findByCustomNative();
   @Query("select new az.ingress.bankapp.dto.AccountDto(a.id, a.accountNumber, a.balance, u.username, u.password, c.cardNumber, c.cardType, c.expirationDate,b.description) from Account a join  a.user u join  a.cards c join  c.benefits b")
   List<AccountDto> findAllCustom();//hamsi ucun umumi bir left join atir. bunu dto ya yigir ve multi list xetasin hell edir



//   @EntityGraph(value = "account-user",type = EntityGraph.EntityGraphType.LOAD)
//   List<Account> findByAccountNumber(String accountNumber);


//   @Query( name = "test")
//   List<Account> findByA();

  @EntityGraph(attributePaths = {"user","user.address","cards", "cards.benefits"})  //paths da olanlar hamsi eagr olaraq gelir left join
                                                                     // paths da olmuyan elaqesi olan filed ucun select atir
  List<Account> findByAccountNumber(String accountNumber);

//   @EntityGraph(value = "account-with-user-cards-benefits")
//   @Query("select a from Account a")
//   List<Account> findByCustomGraph();





}

