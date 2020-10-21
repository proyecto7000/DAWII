package Practica.EmpleosWalter.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer{
	
	@Value("${empleosapp.ruta.imagenes}")
	private String rutaImagenes;
	
	public void  addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/logos/**").addResourceLocations("file:"+rutaImagenes);
	}
	
}