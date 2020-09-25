package Practica.EmpleosWalter.Util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	public static String guardarArchivo(MultipartFile multipart,String ruta) {
		String nombreOriginal = multipart.getOriginalFilename();
		nombreOriginal = nombreOriginal.replace(" ", "-");
		String nombreFinal = randomAlphaNumeric(8) + nombreOriginal;
		
		try {
			File imageFile=new File(ruta+nombreFinal);
			System.out.println("Archivo: "+imageFile.getAbsolutePath());
			
			multipart.transferTo(imageFile);
			return nombreFinal;
		}catch(IOException e) {
			System.out.println("Error "+e.getMessage());
			return null;
		}
	}
	
	
	public static String randomAlphaNumeric(int count) {
		String CARACTERES ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder=new StringBuilder();
		while(count-- !=0) {
			int character = (int)(Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}
}
