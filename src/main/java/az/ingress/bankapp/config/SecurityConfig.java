package az.ingress.bankapp.config;

import az.ingress.bankapp.auth.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    //private final CustomFilter customFilter;
    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
             .authorizeHttpRequests(auth ->
                auth.requestMatchers(GET, "/accouts/security").permitAll()
                       // .requestMatchers(GET, "accounts/security/*").permitAll()
                        .requestMatchers(POST, "/accouts/security").hasRole("ADMIN")
                        .anyRequest().authenticated()

        );

        httpSecurity.httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
//        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        httpSecurity.csrf(AbstractHttpConfigurer::disable);
//        httpSecurity.authorizeHttpRequests(auth ->
//                auth.requestMatchers(GET, "accounts/security").permitAll()
//                        .requestMatchers("accounts/security/*").hasAnyAuthority("USER")
//                        .requestMatchers(POST, "accounts/security").hasAnyAuthority("USER", "TEST")
//                        .requestMatchers("accounts/security/**").hasAnyAuthority("ADMIN")
//                        .anyRequest().authenticated()
//        );
//        httpSecurity.httpBasic(Customizer.withDefaults());
//        httpSecurity.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
//        return httpSecurity.build();
    }

   @Bean
   public UserDetailsService userDetailsService() {
//////        UserDetails user1 = User.withDefaultPasswordEncoder()
//////                .username("user1")
//////                .password("password")
//////                .roles("USER")
//////                .build();
//////
//////        UserDetails user2 = User.withDefaultPasswordEncoder()
//////                .username("user2")
//////                .password("password")
//////                .roles("ADMIN")
//        //  .build();
   return customUserDetailsService;
 }
//
//   @Bean    public WebSecurityCustomizer webSecurityCustomizer() {
//       return (web) -> web.ignoring().requestMatchers("/swagger-ui/","/swagger-ui/*");
//
//
//   }
//                "/swagger-resources",
//                "/swagger-resources/**",
//                "/configuration/ui",
//                "/configuration/security",
//                "/swagger-ui.html",
//                "/webjars/**",
//                // -- Swagger UI v3 (OpenAPI)
//                "/v3/api-docs/**",
//                "/swagger-ui/**");
//    }
//
//
   // }
        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;

    }


}
