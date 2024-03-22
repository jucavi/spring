package com.example.ob07springsecurityjwt.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filters incoming requests and installs a Spring Security principal if a header corresponding to
 * a valid user is found
 *
 * Se ejecuta por cada petición entrante con el fin de validar el token JWT
 * en caso de que lo sea se añade al contexto para indicar que un usuario está aputenticado
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);
    public static final String BEARER = "Bearer";

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetails userDetails;

    /**
     * This doFilter implementation stores a request attribute for "already filtered",
     * proceeding without filtering again if the attribute is already there.
     * See Also:
     * getAlreadyFilteredAttributeName, shouldNotFilter, doFilterInternal
     */
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        try {
            String token = parseJwt(request);

            if (token != null && jwtTokenUtil.validateJwtToken(token)) {

                String username = jwtTokenUtil.getUsernameFromJwtToken(token);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
        }

        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        return "hola";
    }


}
