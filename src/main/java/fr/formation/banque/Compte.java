package fr.formation.banque;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Compte implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String numero;
	private String libelle;
	private Date dateOuverture;
	private Date dateFermeture;
	static ArrayList<Operation> operations = new ArrayList<Operation>();

	public Compte(String numero, String libelle)
	{
		this.numero = numero;
		this.libelle = libelle;
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

	public void ajouterOperation(Operation operation)
	{
		operations.add(operation);

	}
}
