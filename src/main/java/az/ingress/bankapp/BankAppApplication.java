package az.ingress.bankapp;

import az.ingress.bankapp.entity.User;
import az.ingress.bankapp.repository.AccountRepository;
import az.ingress.bankapp.repository.CardRepo;

import az.ingress.bankapp.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class BankAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
	}

	//private  final UserService userService;
	private final AccountRepository accountRepository;
	private final UserRepository userRepository;
//  private final EntityManagerFactory entityManagerFactory;
//  private final CardBeniftRepo cardBeniftRepo;
//  private final CardRepo cardRepo;
	@Override

	public void run(String... args) throws Exception {

	//accountRepository.findAll().forEach(System.out::println);
		//System.out.println(accountRepository.findById(1L));
		System.out.println(accountRepository.findByCustom().get());


		//Card card=cardRepo.findById(1L).get();
	//	System.out.println(card.getCardBenefits());

//		EntityManager entityManager=entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		Card card=entityManager.createQuery("select c from Card c where c.id=:id", Card.class)
//				.setParameter("id",3L).getSingleResult();
//		card.setCardName("miles card");
//		entityManager.getTransaction().commit();
//		entityManager.persist(card);
//		entityManagerFactory.close();




	}
}
