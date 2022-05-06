package Dia20.EjerciciosPropios20;

import Dia20.EjerciciosPropios20.Controllers.Repositories.LoginRepository;
import Dia20.EjerciciosPropios20.Models.Users;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class EjerciciosPropios20ApplicationTests {

	@Autowired
	private LoginRepository lR;

	@Autowired
	PasswordEncoder pE;

	@Test
	void contextLoads() {
		Users user = new Users();

		user.setUsername("admins");
		user.setPassword(pE.encode("123"));

		Users r = lR.save(user);
		Assert.assertTrue(r.getPassword().equalsIgnoreCase(user.getPassword()));

	}

}
