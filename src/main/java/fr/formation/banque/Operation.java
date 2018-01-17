package fr.formation.banque;

import java.util.Date;

public abstract class Operation implements IOperation
{
	private Date dateOperation = new Date();
	private Date dateValeur = null;
	private String libelle = "test";
	// private double montant = 0; // montant, en unité de monnaie 1 = 1 €
	private int credit = 0; // valeur en unité miniamle de monnaie 1 = 0.01€
	private int debit = 0;// valeur en unité miniamle de monnaie 1 = 0.01€

	// private int typeOperation = TypeOperation.TYPE_CB;

	/******************************************************************************************************************
	 * CONSTRUCTORS
	 *****************************************************************************************************************/
	public Operation()
	{
		setDateOperation(new Date());
		setDateValeur(null);
		credit = 0;
		debit = 0;
	}

	Operation(int typeOperation)
	{
		this();
		this.typeOperation = typeOperation;
	}

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

	Operation(String libelle, double montant, int typeOperation)
	{
		this(libelle, montant);
		this.typeOperation = typeOperation;
	}

	/******************************************************************************************************************
	 * FINALIZER (when GC deletes this object
	 *****************************************************************************************************************/
	protected void finalize()
	{
		System.out.println("OPERATION > " + getClass().getSimpleName() + " terminated");
	}

	/******************************************************************************************************************
	 * MÉTHODES
	 *****************************************************************************************************************/

	/*
	 * double calculerMontantTTC(double taux) { return getMontant() * (1 + taux); }
	 */
	public int getTypeOperation()
	{
		return typeOperation;
	}

	private void setTypeOperation(int typeOperation)
	{
		this.typeOperation = typeOperation;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.formation.banque.IOperation#getMontant()
	 */
	public abstract double getMontant();

	/*
	 * (non-Javadoc)
	 * @see fr.formation.banque.IOperation#setMontant(double)
	 */
	public abstract void setMontant(double montant);

	public int getCredit()
	{
		// return montant > 0 ? (-montant * 100) : 0;
		return credit;
	}

	public void setCredit(int credit)
	{
		this.credit = credit;
	}

	public int getDebit()
	{
		// return montant < 0 ? (-montant * 100) : 0;
		return debit;
	}

	public void setDebit(int debit)
	{
		this.debit = debit;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.formation.banque.IOperation#getDateOperation()
	 */
	public Date getDateOperation()
	{
		return dateOperation;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.formation.banque.IOperation#setDateOperation(java.util.Date)
	 */
	public void setDateOperation(Date dateOperation)
	{
		this.dateOperation = dateOperation;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.formation.banque.IOperation#getDateValeur()
	 */
	public Date getDateValeur()
	{
		return dateValeur;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.formation.banque.IOperation#setDateValeur(java.util.Date)
	 */
	public void setDateValeur(Date dateValeur)
	{
		this.dateValeur = dateValeur;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.formation.banque.IOperation#getLibelle()
	 */
	public String getLibelle()
	{
		return libelle;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.formation.banque.IOperation#setLibelle(java.lang.String)
	 */
	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}
}
