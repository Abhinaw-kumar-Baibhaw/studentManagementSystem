package com.example.StudentManagement.config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Date;


@Service
public class JwtService {

    private static final long TOKEN_VALIDITY = 60 *60 * 1000;

    private final byte[] secretKey =("qXbFtb5dN8HG9j6+PhD7LDBb02fW3sP6M5LkW8nA0K8j34fB/3g7Wx2site").getBytes();

//    JwtService(){
//        secretKey=generateSecretKey();
//    }
//
//    public String generateSecretKey(){
//        try {
//            KeyGenerator key=KeyGenerator.getInstance("HmacSHA256");
//            System.out.println(key);
//            SecretKey secretKey= key.generateKey();
//            System.out.println("Secret Key:"+secretKey.toString());
//            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
//        }catch (NoSuchAlgorithmException e){
//            throw new RuntimeException("Error generating secret key",e);
//        }
//    }


    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY))
                .signWith(getSignKey())
                .compact();
    }


    private SecretKey getSignKey() {
        return Keys.hmacShaKeyFor(secretKey);
    }


    public String extractUserName(String token){
        Claims claims = getAllClaimsFromToken(token);
        return claims.getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        Claims claimsDetails = getAllClaimsFromToken(token);
        String userName = claimsDetails.getSubject();
        return (userName.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    public Claims getAllClaimsFromToken(String token){
        return Jwts.parser()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getPayload();
    }

    private Date extractExpiration(String token){
        Claims claims=getAllClaimsFromToken(token);
        return claims.getExpiration();
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
}