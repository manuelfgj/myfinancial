package com.manuelfgj.myfinancial.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.manuelfgj.myfinancial.entities.Element;
import com.manuelfgj.myfinancial.entities.User;
import com.manuelfgj.myfinancial.entities.enums.Group;
import com.manuelfgj.myfinancial.entities.enums.Operation;
import com.manuelfgj.myfinancial.entities.enums.Type;
import com.manuelfgj.myfinancial.repositories.ElementRepository;
import com.manuelfgj.myfinancial.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ElementRepository elementRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Manuel Gomes", "manuel@gmail.com", "988888888", "123456");

		Element e1 = new Element(null, "Salary", Instant.parse("2022-01-01T19:53:07Z"), 7650.0, Operation.REVENUE, Group.REVENUE_ENTRY, Type.MONEY, 1, u1);
		Element e2 = new Element(null, "Savings", Instant.parse("2022-01-02T03:42:10Z"), 2000.0, Operation.REVENUE, Group.REVENUE_ECONOMY, Type.MONEY, 1, u1);
		Element e3 = new Element(null, "Mobile phone", Instant.parse("2022-01-04T08:53:07Z"), 40.0, Operation.EXPENSE, Group.EXPENSE_PERSONAL, Type.DEBIT, 1, u1);
		Element e4 = new Element(null, "Rent home", Instant.parse("2022-01-05T15:21:22Z"), 1600.0, Operation.EXPENSE, Group.EXPENSE_HOME, Type.DEBIT, 1, u1);
		Element e5 = new Element(null, "Internet", Instant.parse("2022-01-06T09:00:22Z"), 85.0, Operation.EXPENSE, Group.EXPENSE_HOME, Type.CREDIT, 1, u1);
		Element e6 = new Element(null, "Clothes", Instant.parse("2022-01-10T08:53:07Z"), 200.0, Operation.EXPENSE, Group.EXPENSE_PERSONAL, Type.CREDIT, 4, u1);
		
		userRepository.saveAll(Arrays.asList(u1));		
		elementRepository.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6));
		
	}
}
