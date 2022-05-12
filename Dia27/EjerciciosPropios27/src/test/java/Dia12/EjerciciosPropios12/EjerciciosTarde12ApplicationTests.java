package Dia12.EjerciciosPropios12;

import Dia12.EjerciciosPropios12.Models.MyUser;
import Dia12.EjerciciosPropios12.Models.Role;
import Dia12.EjerciciosPropios12.Services.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class EjerciciosTarde12ApplicationTests {

	@Autowired
	private UserService uA;

	@Autowired
	PasswordEncoder pE;

	@Test
	void contextLoads() {
		MyUser user = new MyUser();

		user.setUsername("admin");
		user.setPassword(pE.encode("123"));
		Role role = new Role(1,"ADMIN");
		user.setRole(role);

		uA.save(user);
		MyUser r = uA.findByUsername(user.getUsername());
		Assert.assertTrue(r.getPassword().equalsIgnoreCase(user.getPassword()));

	}

}
