/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.configuracao.security.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author alecsander
 */
class JWTAuth {

        // EXPIRATION_TIME = 1 dias
    private static final long EXPIRATION_TIME = TimeUnit.DAYS.toMillis(1);
    private static final String SECRET = "b%c{^BTEj[qO";
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";
    private static final String CLAIMS_PRIVILEGES = "privileges";
    
    static void addAuthentication(HttpServletResponse response, Authentication auth) throws JsonProcessingException, IOException {
        Date expiration = new Date(System.currentTimeMillis() + EXPIRATION_TIME);

        Claims claims = Jwts.claims()
                .setIssuedAt(new Date())
                .setSubject(auth.getName())
                .setExpiration(expiration)
                .setSubject(auth.getName());

        claims.put(CLAIMS_PRIVILEGES, auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

        String JWT = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(claims)
                .compact();

        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
        response.addHeader("Content-Type", "application/json");
        
        String json = new ObjectMapper().writeValueAsString(HEADER_STRING + ":" + TOKEN_PREFIX + " " + JWT );
        response.getWriter().write(json);
        response.flushBuffer();
    }
    
    static Authentication getAuthentication(HttpServletRequest request) {
        
        try{
        
        String token = request.getHeader(HEADER_STRING);
        
        
        if (token != null) {

            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();

            String user = claims.getSubject();

            List<GrantedAuthority> objects = new ArrayList<>();
            if (claims.containsKey(CLAIMS_PRIVILEGES)) {
                List<String> privileges = (List<String>) claims.get(CLAIMS_PRIVILEGES);
                for (String privilege : privileges) {
                    objects.add(() -> privilege);
                }
            }
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, objects);
            }
        }
        return null;
        
        }catch(ExpiredJwtException e){
            System.out.println("TOKEN EXPIRADO. REFAÇA O LOGIN!");
            return null;
        }
    }
}
