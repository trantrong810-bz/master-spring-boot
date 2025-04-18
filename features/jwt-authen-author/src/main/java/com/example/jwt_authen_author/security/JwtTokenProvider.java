package com.example.jwt_authen_author.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    private final String JWT_SECRET = "superSecureJWTSecretKeyForHS512ThatIsAtLeast64CharactersLong12345678     ";
    private final long JWT_EXPIRATION = 86400000; // 1 day

    public String generateToken(UserDetails userDetails) {
        String token = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                // Include roles or authorities as claims if needed
                //.claim("roles", userDetails.getAuthorities())
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)  // Ensure you sign it correctly using HS512
                .compact();

        return token;
    }

    public String getUsernameFromJWT(String token) {
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
