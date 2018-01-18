package fr.formation.banque;

public class Virement extends Operation
{
	public String compteVirement;

	/******************************************************************************************************************
	 * CONSTRUCTORS
	 *****************************************************************************************************************/
	public Virement()
	{
		super();
	}

	/******************************************************************************************************************
	 * GETTERS SETTERS
	 *****************************************************************************************************************/
	public double getMontant()
	{
		return getDebit() / 100.0 + 0;
	}

	public void setMontant(double montant)
	{
		setDebit((int) (-montant * 100));
	}

	public int getTypeOperation()
	{
		return TypeOperation.TYPE_VIREMENT;
	}
}
