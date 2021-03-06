package com.hello;



// Externalized Configuration   
import org.springframework.beans.factory.annotation.Value;

// Securing a Web Application
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
// Securing a Web Application
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated();
        http
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                
            .logout()
                .logoutUrl("/logout")
               // .logoutSuccessUrl("/bye")
                .permitAll();
    }

    @Configuration
    protected static class AuthenticationConfiguration extends
            GlobalAuthenticationConfigurerAdapter {
        
        // Externalized Configuration   
        @Value("${security.user.name:123}")
        private String name;

        @Value("${security.user.password:123}")
        private String password;

        @Value("${management.security.role:USER}")
        private String role;
    

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth 
                    .inMemoryAuthentication()
                    .withUser(name).password(password).roles(role);
                    //.withUser("123").password("123").roles("USER");
        }

    }

}
