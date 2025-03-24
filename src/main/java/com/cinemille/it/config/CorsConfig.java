package com.cinemille.it.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        
        // ✅ Permetti richieste da qualsiasi origine (modifica se necessario)
        config.setAllowedOrigins(List.of("http://localhost:4200"));

        // ✅ Permetti i metodi HTTP (GET, POST, PUT, DELETE, ecc.)
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // ✅ Permetti intestazioni personalizzate
        config.setAllowedHeaders(List.of("Authorization", "Content-Type"));

        // ✅ Permetti invio di credenziali (cookie, autenticazione, ecc.)
        config.setAllowCredentials(true);

        // ✅ Configura il CORS per tutte le rotte
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}