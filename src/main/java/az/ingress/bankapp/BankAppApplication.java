package az.ingress.bankapp;

import az.ingress.bankapp.entity.Authority;
import az.ingress.bankapp.entity.Card;
import az.ingress.bankapp.entity.User;
import az.ingress.bankapp.repository.*;
import az.ingress.bankapp.service.StudentService;
import az.ingress.bankapp.service.impl.AccountServiceImpl;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
@EnableCaching
//@OpenAPIDefinition(info = @Info(
//		title = "Bank app",
//		description = "Bank app for Customer",
//		contact = @Contact(
//				name = "Shemsi",
//				url = "https://github.com/Shamsiazizaliyev"
//		)
//
//
//),externalDocs = @ExternalDocumentation(
//		url = "https://github.com/Shamsiazizaliyev",
//		description = "test"
//
//)
//
//)
public class BankAppApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
	}
	//private  final UserService userService;
	private final AccountRepository accountRepository;
	private final StRepo stRepo;
	private final TcRepo tcRepo;
	private  final UserRepository  userRepository;
	private final CardRepo cardRepo;
	private final  AdressRepo addr;
	private final  Are are;
	private final  CardBeniftRepo cardBeniftRepo;

	private final AccountServiceImpl service;

	private final StudentRepository studentRepository;

	private final StudentService studentService;

	private final BCryptPasswordEncoder passwordEncoder;



	//  private final EntityManagerFactory entityManagerFactory;
//  private final CardBeniftRepo cardBeniftRepo;
//  private final CardRepo cardRepo;
	@Override
    @Transactional
	public void run(String... args) throws Exception {



//		Authority admin = new Authority();
//		admin.setAuthority("ROLE_ADMIN");
//
//		User qulu = new User();
//		qulu.setUsername("test");
//		qulu.setPassword(passwordEncoder.encode("123"));
//
//		qulu.setAuthoritiess(Set.of(admin));
//
//		userRepository.save(qulu);


//
//		Account account=new Account();
//		account.setAccountNumber("12345");
//		account.setBalance(400);
//
//		Account  account1=accountRepository.findById(3L).get();
//		account1.setAccountNumber("5555");
//		User user=userRepository.findById(1L).get();
//		account1.setUser(user);


		String acacuntNumber="iba400";
		Double balance=233.00;
		//saveAccount(acacuntNumber,balance);
//		Student student=studentRepository.findById(1L).get();
//		Student student2=studentRepository.findById(1L).get();
//		System.out.println("student2");

		//List< Card > cards =cardRepo.findAll();


	//	System.out.println("cavab= "+cards.stream().findFirst().get().getCardNumber());





	//System.out.println(accountRepository.findByCustomGraph());



//		EntityManager entityManager=entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		Card card=entityManager.createQuery("select c from Card c where c.id=:id", Card.class)
//				.setParameter("id",3L).getSingleResult();
//		card.setCardName("miles card");
//		entityManager.getTransaction().commit();
//		entityManager.persist(card);
//		entityManagerFactory.close();

//		Student qulu = Student.builder()
//				.name("Qulu")
//				.surname("Bedelov")
//				.age(20)
//				.gender("M")
//				.build();
//		Student mehemmed = Student.builder()
//				.name("Mehemmed")
//				.surname("Ilyazov")
//				.age(20)
//				.gender("M")
//				.build();
//		Student esref = Student.builder()
//				.name("Esref")
//				.surname("Sukurlu")
//				.age(20)
//				.gender("M")
//				.build();
//		List<Student> students = List.of(qulu, mehemmed, esref);// deyismek olmur sonra List.of methodud
//		for (Student student : students) {
//        // studentService.saveStudent(student);
//		}

		//List<Student> allStudents = studentService.getStudentsAll("Qulu","Bedelov",72L);
// allStudents.forEach(System.out::println);
	//	System.out.println(studentRepository.getStudnets());

	//	List<Student> list = studentService.getStudentsAll("Qulu", "Bedelov", 20L, null);

  //  list.forEach(System.out::println);

//		Student student =studentRepository.findByNameAndAge("Qulu",44L).get();
//     Student  student= studentRepository.findById(1L).get();
//		student.setAge(44);
//		studentRepository.save(student);
//		Thread.sleep(10000);
//		System.out.println(student);
	//
		//	System.out.println(accountRepository.findByAccountNumber("iba320"));
//		List<User> all = userRepository.findAll();
//		for (User us:all){
//			System.out.println(us.getUsername());
//			//System.out.println(us.getAddress().getCity());
//		}


		//System.out.println(accountRepository.findByA());
		//tcRepo.findAll().forEach(System.out::println);

		//System.out.println(accountRepository.findAllCustom());

		//System.out.println(studentService.getStudentsAll("Qulu","Bedellov",26L));
		//System.out.println(studentRepository.findByNameAndSurnameAndAgeAndGender(null,"Bedelov",25,"M"));
	//System.out.println(studentService.getStudents(null,"Bedelov",25L,"M"));

	}

//	public  void saveAccount(String acauntNumber,Double balance){
//
//		Account  account=accountRepository.findById(3L).get();
//		account.setAccountNumber(acauntNumber);
//		account.setBalance(balance);
//		//accountRepository.save(account);
//
//
//
//
//


}
