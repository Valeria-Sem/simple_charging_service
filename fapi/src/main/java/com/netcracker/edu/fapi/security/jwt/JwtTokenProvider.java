//package com.netcracker.edu.fapi.security.jwt;
//
//import com.netcracker.edu.fapi.models.enums.Role;
//import io.jsonwebtoken.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.Date;
//import java.util.List;
//
//@Component
//public class JwtTokenProvider {
//
//    @Value("${jwt.token.secret}")
//    private String secret;
//
//    @Value("${jwt.token.expired}")
//    private long validityTime;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }
//
//    @PostConstruct
//    protected void init(){
//        secret = Base64.getEncoder().encodeToString(secret.getBytes());
//    }
//
//    public String createToken(String login, List<Role> roles){
//        Claims claims = Jwts.claims().setSubject(login);
//        claims.put("roles", getRoleNames(roles));
//
//        Date now = new Date();
//        Date validity = new Date (now.getTime() + validityTime);
//
//        return Jwts.builder()//
//        .setClaims(claims)//
//        .setIssuedAt(now)//
//        .setExpiration(validity)//
//        .signWith(SignatureAlgorithm.HS256, secret)//
//        .compact();
//    }
//
//    public Authentication getAuthentication(String token){
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//    public String getUsername(String token){
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public String resolveToken(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")){
//            return bearerToken.substring(7, bearerToken.length());
//        }
//        return null;
//    }
//
//    public boolean validateToken(String token){
//        try{
//            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//            if (claims.getBody().getExpiration().before(new Date())) {
//                return false;
//            }
//
//            return true;
//        } catch (JwtException | IllegalArgumentException e) {
//            throw new JwtAuthenticationException("Jwt token is expired or invalid");
//        }
//
//    }
//
//    private List<String> getRoleNames(List<Role> userRoles){
//       List<String> result = new ArrayList<>();
//
//       userRoles.forEach(role ->
//               result.add(role.name()));
//
//       return result;
//    }
//}
