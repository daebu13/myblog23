package com.myblog.myblog22.config;

import com.myblog.myblog22.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // cross site request forgery security feature ,it is disabled as we are in environment development
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").permitAll()  //this line means Get urls can be accessible by all
                .antMatchers(HttpMethod.POST,"/api/posts").hasRole("ADMIN") // this means that this post url  can be accessible by only admin
                .antMatchers(HttpMethod.POST,"/api/auth/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/auth/signin").permitAll()
                // we can also use   @PreAuthorize("hasRole('ADMIN')") ANNOTATION in post controller for same cause
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws  Exception{

            auth.userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder());

    }
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.builder().username("faisal").password(passwordEncoder()
//                        .encode("password")).roles("USER").build();
//        UserDetails admin =
//                User.builder().username("admin").password(passwordEncoder()
//                        .encode("admin")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}