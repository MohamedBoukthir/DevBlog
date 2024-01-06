package com.mohamed.blog.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtProvider {

    private SecretKey secretKey = Keys.hmacShaKeyFor(JwtConstants.JWT_SECRET.getBytes());

    // generate token
    public String generateToken(Authentication authentication){
        String jsonWebToken = Jwts.builder().setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 24000))
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
