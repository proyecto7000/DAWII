package Practica.EmpleosWalter.Util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	public static String guardarArchivo(MultipartFile multipart,String ruta) {
		String nombreOriginal = multipart.getOriginalFilename();
		try {
			File imageFile=new File(ruta+nombreOriginal);
			System.out.println("Archivo: "+imageFile.getAbsolutePath());
			
			multipart.transferTo(imageFile);
			return nombreOriginal;
		}catch(IOException e) {
			System.out.println("Error "+e.getMessage());
			return null;
		}
	}
}
