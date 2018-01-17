package fr.formation.banque;

import java.util.ArrayList;

public class Portefeuille
{
	private String libelle;
	private String nomBanque;
	ArrayList<Compte> comptes = new ArrayList<Compte>();

	public Portefeuille(String libelle, String nomBanque)
	{
		this.libelle = libelle;
		this.nomBanque = nomBanque;
		System.out.println("i am a " + getClass().getSimpleName() + " with : <libelle = " + this.libelle + "> & <nomBanque = " + this.nomBanque + ">");
	}

	public String getLibelle()
	{
		return libelle;
	}

	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}

	public String getNomBanque()
	{
		return nomBanque;
	}

	public void setNomBanque(String nomBanque)
	{
		this.nomBanque = nomBanque;
	}

}
