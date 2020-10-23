package dawii.elena.empleoselena.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, estatus from  usuarios where username=?")
		.authoritiesByUsernameQuery("select u.username, p.perfil from usuarioperfil up " +
		"inner join usuarios u on u.id = up.idUsuario " +
		"inner join perfiles p on p.id = up.idPerfil " +
		"where u.username = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//los recursos estáticos no requieren autenticacion
		.antMatchers(
				"/bootstrap/**",
				"/images/**",
				"/tinymce/**",
				"/logos/**").permitAll()
		//las vistas publicas no requieren autentcacion
		.antMatchers("/",
				"/signup",
				"/search",
				"/VACANTE/detalle/**").permitAll()
		//todas las demas URLs de la aplicacion requieren autenticacion
		.anyRequest().authenticated()
		//el fomulario de login no requiere autenticacion
		.and().formLogin().permitAll();
		
	}
}
