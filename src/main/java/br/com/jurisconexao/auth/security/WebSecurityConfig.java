
package br.com.jurisconexao.auth.security;

/**
 *
 * @author Marcos
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	// métodos de configuração



	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JwtFilter jwtFilter;


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) 
	         throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	CorsConfiguration corsConfig = new CorsConfiguration();
	corsConfig.addAllowedOrigin("*");
	corsConfig.addAllowedHeader("*");
	corsConfig.addAllowedMethod("*");
	source.registerCorsConfiguration("/**", corsConfig);
	return source;
}




	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.cors().and()
		.csrf().disable()
		.authorizeHttpRequests( (authorize) -> authorize
				.requestMatchers("/perfispagamento/**","/vendedores/**","/islogged/**", "/forgot_password/**",
						"/reset_password/**", "/register", "/*", "/user/**", "/cinefilos/**", "/textoes/**",
						"/files/**", "/file/**","/auth/**","/resultpagos/**","/preferences/**",
						"/eventos/**","/vendidos/**","/files/**", "/filelist/**", "/download/**",
						"/create/**","/generic/**","/notifications/**","/produtos/**", "/register",
						"/user/**", "/cinefilos/**", "/textoes/**", "/uploadFile/**", "/file/**",
						"/loja/**", "/vendas/**", "/auth/**", "/fretes/**", "/dominios/**", "/process_register/**").permitAll()
				.requestMatchers("/users").authenticated()
				.anyRequest().authenticated()
				)
		.formLogin()
		.loginPage("/authenticate")
		.defaultSuccessUrl("/", true)
		.failureUrl("/login-error")
		.permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/")
		.deleteCookies("JSESSIONID")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/negado");

		return http.build();
	}

}
