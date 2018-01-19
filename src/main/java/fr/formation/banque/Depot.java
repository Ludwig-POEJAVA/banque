package fr.formation.banque;

public class Depot extends Operation
{
	public String modePaiement;
	private TypeOperation typeOperation = TypeOperation.CB;

	/******************************************************************************************************************
	 * CONSTRUCTORS
	 *****************************************************************************************************************/
	public Depot(String libelle, double montant, TypeOperation typeOperation)
	{
		super(libelle, montant);
		this.typeOperation = typeOperation;
	}

	/******************************************************************************************************************
	 * GETTERS SETTERS
	 *****************************************************************************************************************/
	public double getMontant()
	{
		{
			return (getCredit() - getDebit()) / 100.0;
		}
	}

	public void setMontant(double montant)
	{
		{
			if (montant < 0)
			{
				setDebit((int) Math.floor(-montant * 100));
				setCredit(0);
			}
			else if (montant > 0)
			{
				setCredit((int) Math.floor(montant * 100));
				setDebit(0);
			}
			else
			{
				setCredit(0);
				setDebit(0);
			}
		}
	}

	public TypeOperation getTypeOperation()
	{
		return typeOperation;
	}
}
