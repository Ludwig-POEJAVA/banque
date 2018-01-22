package fr.formation.banque;

import java.io.Serializable;
import java.util.Hashtable;

public class Portefeuille implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String libelle;
	private String nomBanque;
	private static Hashtable<String, Compte> comptes = new Hashtable<String, Compte>();

	public Portefeuille(String libelle, String nomBanque)
	{
		this.libelle = libelle;
		this.nomBanque = nomBanque;
		System.out.println(this.toString());
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

	public boolean possedeCompte(String numero)
	{
		return comptes.containsKey(numero);
	}

	public void ajouterCompte(Compte compte)
	{
		comptes.put(compte.getNumero(), compte);
	}

	public String toString()
	{
		return "<" + getClass().getSimpleName() + "> {libelle : '" + this.libelle + "', nomBanque : '" + this.nomBanque
				+ "';}";
	}

	public static Hashtable<String, Compte> getComptes()
	{
		return comptes;
	}

	public static void setComptes(Hashtable<String, Compte> comptes)
	{
		Portefeuille.comptes = comptes;
	}
}
