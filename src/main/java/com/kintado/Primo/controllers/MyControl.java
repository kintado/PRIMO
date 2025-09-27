package com.kintado.Primo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kintado.Primo.Dati.DatiScontro;
import com.kintado.Primo.Dati.Persona;

@RestController

public class MyControl {
	
	@GetMapping("/")
	public String HOME() {
		return "home page, amico!!!";
	}
	
	@PostMapping("/datiamico")
	public Persona datiamico(@RequestBody Persona dati ) {
		int id = dati.getId();
		if (id == 1)
		{
            return new Persona(1, "Gesualdo", "Gesualdi", "Via dei Gesualdi", "3333333333");
        }
        else if (id == 2)
        {
            return new Persona(2, "Gianni", "Giannini", "Via dei Giannini", "4444444444");
        }
        else if (id == 3)
        {
            return new Persona(3, "Peppe", "Peppei", "Via dei Peppei", "5555555555");
			
		}
        else
		{
			return null;
		}
				
	}
	
	@GetMapping("/daticollega/{id}")
	public String daticollega(@PathVariable int id) {
		if (id == 1)
			return "Tu stai cercando Gesualdo!";
		else if (id == 2)
			return "Tu stai cercando MariaMiriamMeredeth!";
		else
			return "Tu stai cercando un altro rompicoglioni!";
	}
	
	@PostMapping("/datidragonball")
	public String dati(@RequestBody int id) {
		if (id == 1)
			return "Tu stai cercando Goku!";
		else if (id == 2)
			return "Tu stai cercando Bulma!";
		else
			return "Tu stai cercando un altro supereroe!";
	}
	
	@PostMapping("/scontrodragonball")
	public String dati(@RequestBody DatiScontro dati) {
		String scontro = "Scontro tra ";
		String eroe1 = "";
		String eroe2 = "";
		if (dati.getId1() == 1) {
			eroe1 = "Goku";
		} else if (dati.getId1() == 2) {
			eroe1 = "Bulma";
		} else {
			eroe1 = "un altro supereroe";			
		}
		
		if (dati.getId2() == 1) {
			eroe2 = "Goku";
		} else if (dati.getId2() == 2) {
			eroe2 = "Bulma";
		} else {
			eroe2 = "un altro supereroe";
		}
		
		scontro = scontro + eroe1 + " contro " + eroe2;
		return scontro;	
	}

	
}
