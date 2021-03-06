package Dia25.MVC25.Confing;


import Dia25.MVC25.Controllers.Services.UsersService;
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
    private UsersService uS;



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {


        auth.userDetailsService(uS).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception
    {

           http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/premium/**").hasRole("PREMIUM")
                .antMatchers("/normal*").hasRole("NORMAL")
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/albums", true)
                .failureUrl("/login")
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID");




    }



}
