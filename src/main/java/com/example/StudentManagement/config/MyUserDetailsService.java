package com.example.StudentManagement.config;
import com.example.StudentManagement.entities.Student;
import com.example.StudentManagement.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepo studentRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student byEmail = studentRepo.findByEmail(username);
        if (byEmail!=null){
            return User.builder()
                    .username(byEmail.getEmail())
                    .password(byEmail.getPassword())
                    .roles(byEmail.getRoles().toArray(String[]::new))
                    .build();
       }
        throw new UsernameNotFoundException("NOT FOUND");
    }
}
