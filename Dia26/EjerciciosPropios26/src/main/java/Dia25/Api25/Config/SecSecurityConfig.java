package Dia25.Api25.Config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity

public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthService authEntryPoint;



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {


        auth.inMemoryAuthentication().withUser("POCfwhibbit").password(passwordEncoder().encode("POCfwhibbit")).roles("USER");
        
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception
    {
        http.csrf().disable().authorizeRequests().anyRequest().authenticated()
        .and()
        .httpBasic().authenticationEntryPoint(authEntryPoint);



    }



}
