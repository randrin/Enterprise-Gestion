package com.enterprise.gestion.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployesUtils {

	/**
	 * Generate Matricule Employées: xxx|xxx|xx|x|xx
	 */
	public static String generateMatricule(String nom, String prenom, Date dateNaissance, String role) {
		System.out.println("################# DATE NAISSANCE ... " +dateNaissance);
		String matricule = "";
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
		String strDate = formatter.format(dateNaissance); 
		String day = strDate.substring(8);
		String year = strDate.substring(2, 4);
		String matricule1 = nom.substring(0, 3).toUpperCase();
		String matricule2 = prenom.substring(0, 3).toUpperCase();
		String matricule3 = year;
		String matricule4 = role.substring(0, 1).toUpperCase();
		String matricule5 = day;
		
		matricule = matricule1 + matricule2 + matricule3 + matricule4 + matricule5;
		
		System.out.println("################# Matricule ... " +matricule);
		return matricule;
	}
}
