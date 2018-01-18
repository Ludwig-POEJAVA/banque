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

	class Ligne
	{
		public double montant;
		public String libelle;

		public String toString()
		{
			return "[libelle : " + this.libelle + "]" + "[montant : " + this.montant + "]";
		}
	}

	private Ligne ligneHT = new Ligne();
	private Ligne ligneTVA = new Ligne();

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

	Operation(double montant)
	{
		this();
		setMontant(montant);
	}

	Operation(String libelle, double montant)
	{
		this(montant);
		this.setLibelle(libelle);
	}

	/*
	 * Operation(String libelle, double montant, int typeOperation)
	 * {
	 * this(libelle, montant);
	 * }
	 */

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
	/*
	 * public int getTypeOperation()
	 * {
	 * return typeOperation;
	 * }
	 */

	/*
	 * private void setTypeOperation(int typeOperation)
	 * {
	 * this.typeOperation = typeOperation;
	 * }
	 */

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

	protected void setLigneHT(String libelle, double montantHT)
	{
		ligneHT.libelle = libelle;
		ligneHT.montant = montantHT;
	}

	protected void setLigneTVA(String libelle, double montantTVA)
	{
		ligneTVA.libelle = libelle;
		ligneTVA.montant = montantTVA;
	}

	public void setLigne(String libelle, double montant, double taux)
	{
		setLibelle(libelle);
		setMontant(montant);

		setLigneHT("HT", montant * (1. - taux));
		setLigneTVA("TVA", montant * taux);
	}

	public static int convertSomme(double valeur)
	{
		return (int) Math.floor(valeur * 100);
	}

	public static double convertSomme(int valeur)
	{
		return (double) valeur / 100;
	}

	public static void printOperation(Operation operation)
	{

		System.out.println("Operation <" + operation.getTypeOperation().toString() + ">");
		System.out.println(" \tLibelle: '" + operation.getLibelle() + "'");
		System.out.println(" \tCredit: " + operation.getCredit());
		System.out.println(" \tDébit: '" + operation.getDebit());
		System.out.println(" \tMontant: '" + operation.getMontant());
	}

	public String toString()
	{
		return "Operation" + getTypeOperation().toString() + " - '" + getLibelle() + "'" + " \tMontant : "
				+ getMontant() + " \tDebit : " + getDebit() + " \tCredit : " + getCredit() + " \tligneHT : "
				+ ligneHT.toString() + " \tligneTVA : " + ligneTVA.toString();
	}
}
