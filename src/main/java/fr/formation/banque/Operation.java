package fr.formation.banque;

import java.util.Date;

public class Operation
{
	private Date dateOperation = new Date();
	private Date dateValeur = null;
	private String libelle = "test";
	private double montant = 0;
	private double credit = 0;
	private double debit = 0;

	public Operation()
	{
		setDateOperation(new Date());
		setDateValeur(null);
		montant = 0;
	}

	/* CONSTRUC */
	public Operation(double montant)
	{
		this();// appel du constructeur par défaut
		this.montant = montant;
	}

	public Operation(String libelle, double montant)
	{
		this(montant);
		this.setLibelle(libelle);
	}

	double calculerMontantTTC(double taux)
	{
		return montant * (1 + taux);
	}

	/* FINALIZER */
	protected void finalize()
	{
		System.out.println("You have been terminated");
	}

	/* GETTERS SETTERS */

	public Date getDateOperation()
	{
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation)
	{
		this.dateOperation = dateOperation;
	}

	public Date getDateValeur()
	{
		return dateValeur;
	}

	public void setDateValeur(Date dateValeur)
	{
		this.dateValeur = dateValeur;
	}

	public String getLibelle()
	{
		return libelle;
	}

	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}

	public double getMontant()
	{
		setMontant();
		return montant;
	}

	public void setMontant()
	{
		this.montant = credit - debit;
	}

	public double getCredit()
	{
		return credit;
	}

	public void setCredit(double credit)
	{
		this.credit = credit;
		setMontant();
	}

	public double getDebit()
	{
		return montant < 0 ? -montant : 0;
	}

	public void setDebit(double debit)
	{
		this.debit = debit;
		setMontant();
	}
}
