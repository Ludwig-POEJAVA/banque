package fr.formation.banque;

import java.util.Date;

public abstract class Operation
{
	private Date dateOperation = new Date();
	private Date dateValeur = null;
	private String libelle = "test";
	// private double montant = 0; // montant, en unité de monnaie 1 = 1 €
	private int credit = 0; // valeur en unité miniamle de monnaie 1 = 0.01€
	private int debit = 0;// valeur en unité miniamle de monnaie 1 = 0.01€

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
	Operation(double montant)
	{
		this();
		// setCredit((int) (montant * 100));
		// setDebit((int) (montant * 100));
		setMontant(montant);
	}

	Operation(String libelle, double montant)
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
		System.out.println("OPERATION > " + getClass().getSimpleName() + " terminated");
	}

	/******************************************************************************************************************
	 * GETTERS SETTERS
	 *****************************************************************************************************************/
	public abstract double getMontant()
	/*
	 * { return (credit - debit) / 100; }
	 */;

	public abstract void setMontant(double montant)
	/*
	 * { if (montant < 0) { debit = (int) Math.floor(-montant * 100); credit = 0; }
	 * else if (montant > 0) { debit = 0; credit = (int) Math.floor(montant * 100);
	 * } else { credit = 0; debit = 0; // je sais ... } // this.montant = montant; }
	 */;

	protected int getCredit()
	{
		// return montant > 0 ? (-montant * 100) : 0;
		return credit;
	}

	protected void setCredit(int credit)
	{
		this.credit = credit;
		System.out.println("setcred " + this.credit);
	}

	protected int getDebit()
	{
		// return montant < 0 ? (-montant * 100) : 0;
		return debit;
	}

	protected void setDebit(int debit)
	{
		this.debit = debit;
		System.out.println("setdeb " + this.debit);
	}

	/******************************************************************************************************************
	 * GETTERS SETTERS std
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
}
