package br.com.fiap.semaforo_sql.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private VerificarToken verificarToken;

    @Bean
    public SecurityFilterChain filtrarCadeiaDeSeguranca(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf
                        .disable()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/usuario").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/usuario/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/usuario").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/semaforo").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/semaforo/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/semaforo").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/sensor").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/sensor/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/sensor").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/leitura-sensor").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/leitura-sensor/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/leitura-sensor").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/evento").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/evento/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/evento").hasRole("ADMIN")
//                        .requestMatchers("/h2-console/**").permitAll() para permitir acesso ao console do H2 DB
                        .anyRequest().authenticated()
                )
//                .headers(headers -> headers.frameOptions().sameOrigin()) para habilitar o console do H2 DB
                .addFilterBefore(
                        verificarToken,
                        UsernamePasswordAuthenticationFilter.class
                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
