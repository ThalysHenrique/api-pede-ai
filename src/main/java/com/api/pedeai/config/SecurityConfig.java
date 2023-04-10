package com.api.pedeai.config;

import com.api.pedeai.security.jwt.JwtAuthFilter;
import com.api.pedeai.security.jwt.JwtService;
import com.api.pedeai.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private JwtService jwtService;

    public OncePerRequestFilter jwtFilter(){
        return new JwtAuthFilter(jwtService, usuarioService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usuarioService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/clientes/**")
                .hasAnyRole("USER", "ADMIN")
                    .antMatchers("/pedidos/**")
                .hasAnyRole("USER", "ADMIN")
                    .antMatchers("/pizzas/**")
                .hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST,"/usuarios/**")
                .permitAll()
                        .anyRequest().authenticated()
                    .and()
                .sessionManagement()
                         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                        .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
