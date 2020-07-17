package com.radek.BazyDanychOdczyt.Controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.radek.BazyDanychOdczyt.Dane.BazaDanych;
import com.radek.BazyDanychOdczyt.Dane.Osoba;


@Controller
public class Nawigacja {
	
	@GetMapping("/kontakt")
	public String toKontakt(Model model) {
		model.addAttribute("konto", new Osoba());
		return "kontakt";
	}
	
	@PostMapping("/kontakt")
	public String getKontakt(@ModelAttribute Osoba osoba) {

		if(!osoba.getImie().isEmpty() && !osoba.getNazwisko().isEmpty()) {
			Osoba.listaOsob.add(osoba);
			 try {
				 BazaDanych.getStatmentZBazyDanych().execute("INSERT INTO Osoby (Imie, Nazwisko) VALUES "+ "('" + osoba.getImie() + "' , '" + osoba.getNazwisko() + "');");
             } catch (SQLException e) {
                 e.printStackTrace();
             }
		
			System.out.println(Osoba.listaOsob);
			return "redirect:/";
		}
		
		return "brakDanych";
	}
	
	
	@GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("listaOsob", Osoba.listaOsob);
		
		return "index";
	}
}