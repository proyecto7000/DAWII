package Anthony.VR46.Practica2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${empleosApp.ruta.imagenes}")
	private String rutaimagenes;
	
	
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("/logos/**").addResourceLocations("file:C:/Empleos/img-vacantes/");
		registry.addResourceHandler("/logos/**").addResourceLocations("file:" + rutaimagenes);
	}
}
