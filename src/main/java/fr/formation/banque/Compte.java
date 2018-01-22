package fr.formation.banque;

import java.util.ArrayList;
import java.util.Date;

public class Compte
{
	private String numero;
	private String libelle;
	private Date dateOuverture;
	private Date dateFermeture;
	ArrayList<Operation> operations = new ArrayList<Operation>();

	public void compte(String numero, String libelle, Date dateOuverture, Date dateFermeture)
	{
		this.numero = numero;
		this.libelle = libelle;
		this.dateOuverture = dateOuverture;
		this.dateFermeture = dateFermeture;
	}

	public String getNumero()
	{
		return numero;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
	}

	public String getLibelle()
	{
		return libelle;
	}

	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}

	public Date getDateOuverture()
	{
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture)
	{
		this.dateOuverture = dateOuverture;
	}

	public Date getDateFermeture()
	{
		return dateFermeture;
	}

	public void setDateFermeture(Date dateFermeture)
	{
		this.dateFermeture = dateFermeture;
	}
}
