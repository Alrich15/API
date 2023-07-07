package com.example.config;
//package com.example.common;
//
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
//
//import java.util.ArrayList;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.example.signup.entity.Users;
//import com.example.signup.repository.IUserRepo;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private IUserRepo userRepository;
//
//    public SecurityConfig(IUserRepo userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//            .authorizeRequests()
//                .antMatchers("/api/login").permitAll()
//                .anyRequest().authenticated()
//            .and()
//            .addFilter(new JwtAuthenticationFilter(authenticationManager()))
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(username -> {
//            Users user = userRepository.findByUsername(username);
//            if (user != null) {
//                return new org.springframework.security.core.userdetails.User(user.getUsername(),
//                        user.getPassword(),
//                        new ArrayList<>());
//            }
//            throw new UsernameNotFoundException("User not found: " + username);
//        });
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
//
