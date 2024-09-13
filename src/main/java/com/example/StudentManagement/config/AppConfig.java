package com.example.StudentManagement.config;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class AppConfig  {

    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtFilter jwtFilter;


    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService(); // Implement this service
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(request -> request
                        .requestMatchers("/employee/addStudent","/department/add","/course/add",
                                "/employee/getAllData","/employee/{id}","/department/{id}","/course/{id}",
                                "/parent/add","/parent/{id}","/course/{deletedId}","/course/allCourses")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                        .userDetailsService(myUserDetailsService)
                        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
      return http.build();

    }













//    @Bean
//    public UserDetailsService userDetailsService() {
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        userDetailsManager.createUser(users.username("admin").password("abhinaw").roles("ADMIN").build());
//        return userDetailsManager;
//    }

}
