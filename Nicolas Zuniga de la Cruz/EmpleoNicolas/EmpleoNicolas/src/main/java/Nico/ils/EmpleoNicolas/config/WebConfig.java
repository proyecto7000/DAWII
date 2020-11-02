package Nico.ils.EmpleoNicolas.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Value("${empleosapp.ruta.imagenes}")
	private String rutaImagenes;
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//Windows
		registry.addResourceHandler("/logos/**").addResourceLocations("file:"+rutaImagenes);
	}
	
}
