package fr.formation.banque;

public class Prelevement extends Operation
{
	public String destinataire;

	/******************************************************************************************************************
	 * CONSTRUCTORS
	 *****************************************************************************************************************/
	public Prelevement()
	{
		this.typeOperation = TypeOperation.TYPE_PRELEVEMENT;
	}

	public Prelevement(double montant)
	{
		super(montant);
		this.typeOperation = TypeOperation.TYPE_PRELEVEMENT;
	}

	public Prelevement(String libelle, double montant)
	{
		super(libelle, montant);
		this.typeOperation = TypeOperation.TYPE_PRELEVEMENT;
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
