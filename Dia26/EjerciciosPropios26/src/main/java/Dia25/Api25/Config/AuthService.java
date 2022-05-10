package Dia25.Api25.Config;



import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component
public class AuthService extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authEx) throws IOException
{
    response.addHeader("WW-Authenticate", "Basic Realm=" + getRealmName());
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);


}
@Override
public void afterPropertiesSet() {
setRealmName("POCfwhibbit");
super.afterPropertiesSet();
    }

}
