package com.domingoslatorre.springsecurityjwt.security;

import com.domingoslatorre.springsecurityjwt.security.jwt.AuthEntryPointJwt;
import com.domingoslatorre.springsecurityjwt.security.jwt.AuthJwtTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {
    private final AuthEntryPointJwt authEntryPointJwt;
    private final AuthJwtTokenFilter authJwtTokenFilter;

    public SecurityConfiguration(AuthEntryPointJwt authEntryPointJwt, AuthJwtTokenFilter authJwtTokenFilter) {
        this.authEntryPointJwt = authEntryPointJwt;
        this.authJwtTokenFilter = authJwtTokenFilter;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests(auth -> auth.anyRequest().authenticated())
//            .httpBasic(Customizer.withDefaults());

//        http.authorizeRequests(auth -> auth.anyRequest().permitAll());
//        return http.build();

        http
            .cors().disable()
            .csrf().disable()
            .exceptionHandling().authenticationEntryPoint(authEntryPointJwt).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
            .antMatchers("api/auth/**").permitAll()
            .antMatchers("api/test/**").permitAll()
            .anyRequest().authenticated();

        http.addFilterBefore(authJwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
        return (web) -> web.ignoring().anyRequest();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
