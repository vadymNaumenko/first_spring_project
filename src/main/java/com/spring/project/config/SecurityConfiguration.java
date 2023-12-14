package com.spring.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

//    @Bean
//    public AuthorizationFilter authorizationFilter(A)

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authUrl-> authUrl
                .requestMatchers(antMatcher("/login"),antMatcher("/users/registration"),antMatcher("/v3/api-docs/**"),antMatcher("/swagger-ui/**")).permitAll()
                                .requestMatchers(antMatcher("/users/{\\d+}/delete")).hasAuthority("ADMIN")
                                .requestMatchers(antMatcher("/admin/**")).hasAuthority("ADMIN")
                                .anyRequest().authenticated()
                )
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic(Customizer.withDefaults());
                .logout(logout->logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .deleteCookies("JSESSIONID"))
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/users").permitAll());

//                .requestMatchers("/api/v1/auth/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
//             .authorizeHttpRequests()
//                        .requestMatchers("/login","/users/registration","/v3/api-docs/**","/swagger-ui/**").permitAll()
//                        .requestMatchers("/users/{\\d+}/delete").hasAuthority("ADMIN")
//                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
//                        .anyRequest().authenticated()
//                .and()

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
