package fr.formation.banque;

public class Virement extends Operation
{
	public String compteVirement;

	/******************************************************************************************************************
	 * CONSTRUCTORS
	 *****************************************************************************************************************/
	public Virement()
	{
		this.typeOperation = TypeOperation.TYPE_VIREMENT;
	}

	public Virement(double montant)
	{
		super(montant);
		this.typeOperation = TypeOperation.TYPE_VIREMENT;
	}

	public Virement(String libelle, double montant)
	{
		super(libelle, montant);
		this.typeOperation = TypeOperation.TYPE_VIREMENT;
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
}
