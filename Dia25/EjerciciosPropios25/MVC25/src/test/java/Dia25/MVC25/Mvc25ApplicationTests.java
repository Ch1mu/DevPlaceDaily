package Dia25.MVC25;


import Dia25.MVC25.Controllers.MicroServices.Adapters.UserAdapter;
import Dia25.MVC25.Controllers.MicroServices.Ports.UserPort;
import Dia25.MVC25.Models.Users;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class EjerciciosPropios20ApplicationTests {

	@Autowired
	private UserPort uA;

	@Autowired
	PasswordEncoder pE;

	@Test
	void contextLoads() {
		Users user = new Users();

		user.setEmail("premium@premium.com");
		user.setPassword(pE.encode("123"));
		user.setRole(3);

		uA.save(user);
		Users r = uA.getByEmail(user.getEmail());
		Assert.assertTrue(r.getPassword().equalsIgnoreCase(user.getPassword()));

	}

}
