package net.engineeringdigest.journalApp.config;

import lombok.extern.log4j.Log4j2;
import net.engineeringdigest.journalApp.service.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Log4j2
@Profile("dev")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/journal_new/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/checkhealth/**")
                .permitAll()
                .antMatchers(HttpMethod.POST,"/user").permitAll()
                .antMatchers("/user"  ).authenticated()
                .and()
                .httpBasic();
//                .and()
//                .formLogin(Customizer.withDefaults())
//                .logout()
//                .logoutSuccessUrl("/login?logout")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID");

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();

//        http.authorizeRequests((authorize) -> authorize
//                .requestMatchers(request -> ( HttpMethod.GET).matches("/checkhealth")).hasAuthority("read")
//                );

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        log.info("passwordEncoder bean method call from ApplicationConfig class");
        return new BCryptPasswordEncoder();
    }

}
