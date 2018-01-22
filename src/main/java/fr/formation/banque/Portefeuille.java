package fr.formation.banque;

import java.util.Hashtable;

public class Portefeuille
{
	private String libelle;
	private String nomBanque;
	private static Hashtable<String, Compte> comptes = new Hashtable<String, Compte>();

	public Portefeuille(String libelle, String nomBanque)
	{
		this.libelle = libelle;
		this.nomBanque = nomBanque;
		System.out.println("<" + getClass().getSimpleName() + "> {libelle : '" + this.libelle + "', nomBanque : '"
				+ this.nomBanque + "';}");
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
}
