//package com.academiavivere.projetosemana3.configuration;
//
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.Arrays;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//import com.academiavivere.projetosemana3.entities.Cashbook;
//import com.academiavivere.projetosemana3.entities.Client;
//import com.academiavivere.projetosemana3.entities.User;
//import com.academiavivere.projetosemana3.repositories.CashbookRepository;
//import com.academiavivere.projetosemana3.repositories.ClientRepository;
//import com.academiavivere.projetosemana3.repositories.UserRespository;
//import com.academiavivere.projetosemana3.services.CashbookService;
//
//@Configuration
//public class Config implements CommandLineRunner {
//
//	@Autowired
//	private UserRespository userRepository;
//
//	@Autowired
//	private ClientRepository clientRepository;
//
//	@Autowired
//	private CashbookRepository cashbookRepository;
//
//	@Autowired
//	private CashbookService cashbookService;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		User u1 = new User(null, Date.from(LocalDate.of(2020, 8, 21).atStartOfDay(ZoneId.systemDefault()).toInstant()),
//				"Rodolfo", "rodolfo", "123456", "111111111", "r@gmail.com", 'A', 'A');
//
//		userRepository.save(u1);
//
//		Client c1 = new Client(null,
//				Date.from(LocalDate.of(2020, 1, 22).atStartOfDay(ZoneId.systemDefault()).toInstant()), "Marcelo",
//				"15478326548", "Avenida branca, 220", "Campina Grande", "BR", "12345678", "77777777",
//				"marcelo@gmail.com", 0);
//
//		Client c2 = new Client(null,
//				Date.from(LocalDate.of(2020, 1, 19).atStartOfDay(ZoneId.systemDefault()).toInstant()), "Ricardo",
//				"23587412034", "Avenida azul, 20", "Campina Grande", "BR", "87456123", "11111111", "ricardo@gmail.com",
//				0);
//
//		clientRepository.saveAll(Arrays.asList(c1, c2));
//
//		Cashbook cb1 = new Cashbook(null,
//				Date.from(LocalDate.of(2020, 1, 25).atStartOfDay(ZoneId.systemDefault()).toInstant()),
//				"Pagamento carro", 'C', 500, c1);
//
//		Cashbook cb2 = new Cashbook(null,
//				Date.from(LocalDate.of(2020, 2, 22).atStartOfDay(ZoneId.systemDefault()).toInstant()), "Deposito", 'C',
//				500, c1);
//		Cashbook cb3 = new Cashbook(null,
//				Date.from(LocalDate.of(2020, 8, 22).atStartOfDay(ZoneId.systemDefault()).toInstant()),
//				"Pagamento apartamento", 'D', 1500, c2);
//		Cashbook cb4 = new Cashbook(null,
//				Date.from(LocalDate.of(2020, 1, 22).atStartOfDay(ZoneId.systemDefault()).toInstant()), "Loteria", 'C',
//				50000, c2);
//
//		cashbookService.insert(cb1);
//		cashbookService.insert(cb2);
//		cashbookService.insert(cb3);
//		cashbookService.insert(cb4);
//
//	}
//
//}
