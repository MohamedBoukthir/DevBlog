package com.mohamed.blog.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtProvider {

    @Value("${env.JWT_SECRET}")
    private String jwtSecret;

    private final SecretKey secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());

    // generate token
    public String generateToken(Authentication authentication){
        String jsonWebToken = Jwts.builder().setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 2400))
                .claim("email", authentication.getName())
                .signWith(secretKey)
                .compact();
        return jsonWebToken;
    }

    // get Email from jwt token
    public String getEmailFromJwt(String jwt){
        jwt = jwt.substring(7);
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        String email = String.valueOf(claims.get("email"));
        return email;
    }

}
