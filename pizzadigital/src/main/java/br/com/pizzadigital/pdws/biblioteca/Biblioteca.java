package br.com.pizzadigital.pdws.biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Base64;

public class Biblioteca {

    //-------------------------------------------------------------------------
	public static String formatarValor(double valor) {
		
		BigDecimal bigDecimal     = new BigDecimal (String.valueOf(valor));  
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();  
		String saidaFormatada     = numberFormat.format(bigDecimal);
		
		return saidaFormatada;
	}
    //-------------------------------------------------------------------------
    public static String encodeImage(String imagePath) {
    	String base64Image = "";
    	File file = new File(imagePath);
    	try (FileInputStream imageInFile = new FileInputStream(file)) {
    		// Reading a Image file from file system
    		byte imageData[] = new byte[(int) file.length()];
    		imageInFile.read(imageData);
    		base64Image = Base64.getEncoder().encodeToString(imageData);
    	} catch (FileNotFoundException e) {
    		System.out.println("Image not found" + e);
    	} catch (IOException ioe) {
    		System.out.println("Exception while reading the Image " + ioe);
    	}
    	return base64Image;
    }
    //-------------------------------------------------------------------------
}
