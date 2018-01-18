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

	public Virement(String libelle, double montant)
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

	public TypeOperation getTypeOperation()
	{
		return TypeOperation.VIREMENT;
	}
}
