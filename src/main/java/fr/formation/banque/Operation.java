package fr.formation.banque;

import java.util.Date;

public class Operation
{
	private Date dateOperation = new Date();
	private Date dateValeur = null;
	private String libelle = "test";
	private double montant = 0; // montant, en unité de monnaie 1 = 1 €
	private double credit = 0; // valeur en unité miniamle de monnaie 1 = 0.01€
	private double debit = 0;// valeur en unité miniamle de monnaie 1 = 0.01€

	public Operation()
	{
		setDateOperation(new Date());
		setDateValeur(null);
		montant = 0;
	}

	/******************************************************************************************************************
	 * CONSTRUCTORS
	 *****************************************************************************************************************/

	public Operation(double montant)
	{
		this();
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

	/******************************************************************************************************************
	 * FINALIZER (when GC deletes this object
	 *****************************************************************************************************************/

	protected void finalize()
	{
		System.out.println("You have been terminated");
	}

	/******************************************************************************************************************
	 * GETTERS SETTERS
	 *****************************************************************************************************************/

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
		return (credit - debit) / 100;
	}

	public void setMontant(double montant)
	{
		if (montant < 0)
		{
			debit = Math.floor(-montant * 100);
			credit = 0;
		}
		else if (montant > 0)
		{
			debit = 0;
			credit = Math.floor(montant * 100);
		}
		else
		{
			credit = 0;
			debit = 0;
		}

		this.montant = montant;

	}

	public double getCredit()
	{
		return montant > 0 ? (-montant * 100) : 0;
	}

	public void setCredit(double credit)
	{
		this.credit = credit;
	}

	public double getDebit()
	{
		return montant < 0 ? (-montant * 100) : 0;
	}

	public void setDebit(double debit)
	{
		this.debit = debit;
	}
}
