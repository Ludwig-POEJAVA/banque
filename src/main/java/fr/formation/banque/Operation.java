package fr.formation.banque;

import java.util.Date;

public class Operation
{
	private Date dateOperation = new Date();
	private Date dateValeur = null;
	private String libelle = "test";
	// private double montant = 0; // montant, en unité de monnaie 1 = 1 €
	private double credit = 0; // valeur en unité miniamle de monnaie 1 = 0.01€
	private double debit = 0;// valeur en unité miniamle de monnaie 1 = 0.01€

	public Operation()
	{
		setDateOperation(new Date());
		setDateValeur(null);
		credit = 0;
		debit = 0;
	}

	/******************************************************************************************************************
	 * CONSTRUCTORS
	 *****************************************************************************************************************/
	public Operation(double montant)
	{
		this();
		setCredit(montant);
		setDebit(montant);
	}

	public Operation(String libelle, double montant)
	{
		this(montant);
		this.setLibelle(libelle);
	}

	/******************************************************************************************************************
	 * MÉTHODES
	 *****************************************************************************************************************/
	double calculerMontantTTC(double taux)
	{
		return getMontant() * (1 + taux);
	}

	/******************************************************************************************************************
	 * FINALIZER (when GC deletes this object
	 *****************************************************************************************************************/
	protected void finalize()
	{
		System.out.println("OPERATION terminated");
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
			debit = (int) Math.floor(-montant * 100);
			credit = 0;
		}
		else if (montant > 0)
		{
			debit = 0;
			credit = (int) Math.floor(montant * 100);
		}
		else
		{
			credit = 0;
			debit = 0;
			// je sais ...
		}

		// this.montant = montant;

	}

	public double getCredit()
	{
		// return montant > 0 ? (-montant * 100) : 0;
		return credit;
	}

	public void setCredit(double credit)
	{
		this.credit = credit;
	}

	public double getDebit()
	{
		// return montant < 0 ? (-montant * 100) : 0;
		return debit;
	}

	public void setDebit(double debit)
	{
		this.debit = debit;
	}
}
