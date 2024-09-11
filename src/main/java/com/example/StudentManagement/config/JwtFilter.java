package com.example.StudentManagement.config;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    ApplicationContext context;

    @Autowired
    JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Why taking Authorization :-  the Authorization header is a standard mechanism
        // for transmitting authentication credentials from the client to the server.
        String authHeader= request.getHeader("Authorization");
        String token = null; //taking null is for better to handling exceptions
        String userName = null;
        if(authHeader !=null && authHeader.startsWith("Bearer ")){ //Authorization: Bearer <token>
            token = authHeader.substring(7);
            userName = jwtService.extractUserName(token);
        }
        //SecurityContextHolder.getContext().getAuthentication() is a key method used to retrieve
        // the current authentication information for the user.
        if(userName != null && SecurityContextHolder.getContext().getAuthentication()==null){

            // you are loading user details based on a username.
            UserDetails userDetails=context.getBean(MyUserDetailsService.class).loadUserByUsername(userName);
            if(jwtService.validateToken(token, userDetails)){

                //The UsernamePasswordAuthenticationToken class encapsulates the information
                // required to authenticate a user based on their username and password.
                UsernamePasswordAuthenticationToken authToken=
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                // Set additional details about the authentication request, such as the user's IP address
                // and session ID, for logging or auditing purposes
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Set the authentication in the security context
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response); // Continue with the filter chain
    }
}