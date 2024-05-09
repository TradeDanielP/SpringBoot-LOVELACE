package com.riwi.beautySalon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //Crear rutas publicas
    private final String[] PUBLIC_RESOURCES = { "/services/public/get","/auth/**" };
    
    //  @Bean le indica a SpringBoot el objeto retornado por el metodo debe ser registrado como un bean en el contexto de spring
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        return http
            .csrf(csrf -> csrf.disable()) //Desabilitar proteccion csrf -> statless
            .authorizeHttpRequests(authRequest -> authRequest
                .requestMatchers(PUBLIC_RESOURCES).permitAll() //Configurar rutas publicas
                .anyRequest().authenticated()
                ).build();
            }
    
}
