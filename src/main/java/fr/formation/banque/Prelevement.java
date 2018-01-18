package fr.formation.banque;

public class Prelevement extends Operation
{
	public String destinataire;

	/******************************************************************************************************************
	 * CONSTRUCTORS
	 *****************************************************************************************************************/
	public Prelevement()
	{
		super();
	}

	public Prelevement(String libelle, double montant)
	{
		super(libelle, montant);
	}

	/******************************************************************************************************************
	 * GETTERS SETTERS
	 *****************************************************************************************************************/
	public double getMontant()
	{
		return getDebit() / 100.0;
	}

	public void setMontant(double montant)
	{
		setDebit((int) (-montant * 100));
	}

	public int getTypeOperation()
	{
		return TypeOperation_pre_jdk5.TYPE_PRELEVEMENT;
	}
}
