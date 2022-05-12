package Dia12.EjerciciosPropios12;


import Dia12.EjerciciosPropios12.Models.MyUser;
import Dia12.EjerciciosPropios12.Models.Role;
import Dia12.EjerciciosPropios12.Services.UserService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class EjerciciosTarde12ApplicationTests {

	@Autowired
	private UserService uA;
	@Autowired
	private PasswordEncoder pE;
	@Autowired
	private WebApplicationContext webC;
	private MockMvc mvc;

	@Test
	void contextLoads() {
		MyUser user = new MyUser();

		user.setUsername("user");
		user.setPassword(pE.encode("123"));
		Role role = new Role();
		role.setId(2);
		role.setName("USER");
		user.setRole(role);

		uA.save(user);
		MyUser r = uA.findByUsername(user.getUsername());
		Assert.assertTrue(r.getPassword().equalsIgnoreCase(user.getPassword()));

	}




}
