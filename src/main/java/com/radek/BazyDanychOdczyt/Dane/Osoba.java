package com.radek.BazyDanychOdczyt.Dane;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Osoba {
	
	public String imie;
	public String nazwisko;
	
	public static List<Osoba> listaOsob = new ArrayList<Osoba>();

	
    static {
        try {
            ResultSet data = BazaDanych.getStatmentZBazyDanych().executeQuery("SELECT * FROM Osoby");

            while (data.next())
            	listaOsob.add(new Osoba(data.getString("Imie"), data.getString("Nazwisko")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
	
	public Osoba() {}
	
	public Osoba(String imie, String nazwisko) {
		this.imie = imie;
		this.nazwisko = nazwisko;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	@Override
	public String toString() {
		return "Osoba: imie = " + imie + ", nazwisko = " + nazwisko;
	}
}
